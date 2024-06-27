package com.example.emp.Emp_ProjectDetails;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DetailsService {
    @Autowired
    JdbcTemplate j;

    public Integer validateUser(String username, String password) {
        String sql = "SELECT Emp.emp_id FROM Emp INNER JOIN roles ON Emp.role_id = roles.role_id WHERE username = ? AND password = ? AND roles.role IN ('HR', 'Project Manager')";
        try {
            Map<String, Object> result = j.queryForMap(sql, username, password);
            return (Integer) result.get("emp_id");
        } catch (Exception e) {
            System.out.println("User validation failed: " + e.getMessage());
            return null;
        }
    }

    public boolean isLeadValid(String lead) {
        String sql = "SELECT COUNT(*) FROM Emp INNER JOIN roles ON Emp.role_id = roles.role_id WHERE username = ? AND roles.role IN ('Lead', 'Project Manager')";
        try {
            Integer count = j.queryForObject(sql, Integer.class, lead);
            System.out.println("Lead validation count for " + lead + ": " + count);
            return count != null && count > 0;
        } catch (Exception e) {
            System.out.println("Error validating lead: " + e.getMessage());
            return false;
        }
    }

    public String addDetails(DetailsPojo d) {
        Integer empId = validateUser(d.getUsername(), d.getPassword());

        if (empId != null) {
            try {
                if (!isLeadValid(d.getLead())) {
                    return "Invalid lead.";
                }

                String checkEmpRoleSql = "SELECT roles.role FROM roles INNER JOIN Emp ON Emp.role_id = roles.role_id WHERE Emp.emp_id = ?";
                String empRole = j.queryForObject(checkEmpRoleSql, String.class, d.getEmp_id());

                if (!"Employee".equalsIgnoreCase(empRole) && !"Lead".equalsIgnoreCase(empRole)) {
                    return "Only Employee or Lead can be added.";
                }

                if ("Employee".equalsIgnoreCase(empRole)) {
                    String checkLeadRoleSql = "SELECT roles.role FROM roles INNER JOIN Emp ON Emp.role_id = roles.role_id WHERE Emp.username = ?";
                    String leadRole = j.queryForObject(checkLeadRoleSql, String.class, d.getLead());

                    if (!"Lead".equalsIgnoreCase(leadRole)) {
                        return "Only Lead can assign";
                    }
                } else if ("Lead".equalsIgnoreCase(empRole)) {
                    String checkLeadRoleSql = "SELECT roles.role FROM roles INNER JOIN Emp ON Emp.role_id = roles.role_id WHERE Emp.username = ?";
                    String leadRole = j.queryForObject(checkLeadRoleSql, String.class, d.getLead());

                    if (!"Project Manager".equalsIgnoreCase(leadRole)) {
                        return "Only project manager can assigna lead.";
                    }
                }

                String checkProjectDateSql = "SELECT start_date FROM Project WHERE project_id = ?";
                Date startDate = j.queryForObject(checkProjectDateSql, Date.class, d.getProject_id());
                LocalDate assignedDate = d.getAssigned_date().toLocalDate();

                if (!assignedDate.isAfter(startDate.toLocalDate())) {
                    return "Assigned date must be after the project start date.";
                }

                String checkEmpProjectSql = "SELECT COUNT(*) FROM Emp_Pro_Details WHERE emp_id = ?";
                int empProjectCount = j.queryForObject(checkEmpProjectSql, Integer.class, d.getEmp_id());

                if (empProjectCount > 0) {
                    return "This employee is already assigned to a project.";
                }

                String checkLeadProjectSql = "SELECT COUNT(DISTINCT project_id) FROM Emp_Pro_Details WHERE emp_lead = ? AND project_id != ?";
                int leadProjectCount = j.queryForObject(checkLeadProjectSql, Integer.class, d.getLead(), d.getProject_id());

                if (leadProjectCount > 0) {
                    return "This lead is already assigned to a different project.";
                }

                String sql = "INSERT INTO Emp_Pro_Details (emp_id, project_id, assigned_date, assignedby, emp_lead) VALUES (?, ?, ?, ?, ?)";
                j.update(sql, d.getEmp_id(), d.getProject_id(), assignedDate, d.getUsername(), d.getLead());
                return "Details added successfully.";
            } catch (Exception e) {
                return "Error adding details: " + e.getMessage();
            }
        } else {
            return "User validation failed. Only HR or Project Manager can add details.";
        }
    }
    public List<Map<String, Object>> getEmployeeDetailsByEmpLeadAndProjectId(String emp_lead, Integer project_id) {
        StringBuilder sql = new StringBuilder("SELECT e.*, epd.assigned_date, epd.assignedby, epd.emp_lead, epd.project_id ");
        sql.append("FROM Emp_Pro_Details epd ");
        sql.append("JOIN Emp e ON epd.emp_id = e.emp_id WHERE 1=1 ");

        if (emp_lead != null && !emp_lead.isEmpty()) {
            sql.append("AND epd.emp_lead = '").append(emp_lead).append("' ");
        }
        if (project_id != null && project_id > 0) {
            sql.append("AND epd.project_id = ").append(project_id);
        }

        return j.queryForList(sql.toString());
    }
    
    public List<Map<String, Object>> getEmpByProId(Integer project_id) {
        String sql = "SELECT *"+
                     "FROM Emp e " +
                     "INNER JOIN Emp_Pro_Details epd ON e.emp_id = epd.emp_id " +
                     "WHERE epd.project_id = ?";

        return j.queryForList(sql, project_id);
    }

    

    public List<Map<String,Object>> getDetails(DetailsPojo p){
        String sql= "select * from Project where project_id=?";
        List<Map<String,Object>> l= j.queryForList(sql,p.getProject_id());
        if(l.isEmpty()){
            return l;
    }
    String sql1="select distinct(emp_lead) from Emp_Pro_Details where project_id=?";
    List<Map<String,Object>> l1= j.queryForList(sql1,p.getProject_id());
    List<String> leads= l1.stream().map(row -> (String)row.get("emp_lead")).collect(Collectors.toList());
    List<Map<String,Object>> leadDetails = new ArrayList<>();
    for(String emp_id:leads){
        String sql2="select * from Emp where username=?";
        List<Map<String,Object>> empLead = j.queryForList(sql2,emp_id);
        if(!empLead.isEmpty()){
            leadDetails.add(empLead.get(0));
        }
    }
    String sql2 = "select emp_id from Emp_Pro_Details where project_id=?";
    List<Map<String, Object>> l2 = j.queryForList(sql2,p.getProject_id());
    List<Integer> employeeIds = l2.stream().map(row -> (Integer) row.get("emp_id")).collect(Collectors.toList());


    //getting details of each employee present in a project
    List<Map<String, Object>> employeeDetails = new ArrayList<>();
    for (Integer emp_id : employeeIds) {
        String sqlEmp = "select * from Emp where emp_id = ?";
        List<Map<String, Object>> empDetails = j.queryForList(sqlEmp, emp_id);
        if (!empDetails.isEmpty()) {
            employeeDetails.add(empDetails.get(0));
        }
    }
    // creating new map and adding all the above obtained results
    Map<String, Object> map = l.get(0);
    map.put("emp_leads",leadDetails);           
    map.put("employee_details", employeeDetails);    
    return List.of(map);

}
}