package com.example.emp.Project;

import java.sql.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProService {
    @Autowired
    JdbcTemplate j;

    public Integer validateUser(String username, String password) {
        String sql = "SELECT Emp.emp_id FROM Emp INNER JOIN roles ON Emp.role_id = roles.role_id WHERE username = ? AND password = ? AND roles.role IN ('HR', 'Admin')";
        try {
            Map<String, Object> result = j.queryForMap(sql, username, password);
            return (Integer) result.get("emp_id");
        } catch (Exception e) {
            return null;
        }
    }
 
    public String addProject(ProPojo p) {
        Integer empId = validateUser(p.getUsername(), p.getPassword());

        if (empId != null) {
            try {
                Date startDate = p.getStart_date();
                Date endDate = p.getEnd_date();
                long duration = getDateDiff(startDate, endDate);
                String checkHr = "SELECT COUNT(*) FROM Project WHERE hr = ? AND project_id <> ?";
                String checkManager = "SELECT COUNT(*) FROM Project WHERE manager = ? AND project_id <> ?";
                
                int countHr = j.queryForObject(checkHr, Integer.class, p.getHR(), p.getProject_id());
                int countManager = j.queryForObject(checkManager, Integer.class, p.getManager(), p.getProject_id());

                if (countHr > 0) {
                    return "Project cannot be assigned. HR (" + p.getHR() + ") already assigned to another project.";
                } else if (countManager > 0) {
                    return "Project cannot be assigned. Manager (" + p.getManager() + ") already assigned to another project.";
                }
                String sql = "INSERT INTO Project (project_id, project_name, client_info, assignedby, start_date, end_date, duration, hr, manager) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                j.update(sql, p.getProject_id(), p.getProject_name(), p.getClient_info(),
                        empId, p.getStart_date(), p.getEnd_date(), duration,
                        p.getHR(), p.getManager());
                return "Project added successfully.";
            } catch (Exception ex) {
                return "Error adding project: " + ex.getMessage();
            }
        } else {
            return "User validation failed. Only Admin or  HR can add projects.";
        }
    }

    private long getDateDiff(Date date1, Date date2) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}