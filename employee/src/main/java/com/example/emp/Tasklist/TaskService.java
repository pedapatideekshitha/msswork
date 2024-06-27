package com.example.emp.Tasklist;

import java.sql.Date;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    JdbcTemplate j;

    public String addTask(TaskPojo p) {
        try {
            int task_id = p.getTask_id();
            String task_name = p.getTask_name();
            String created_by = p.getCreated_by();
            int assigned_to = p.getAssigned_to();
            LocalDate assign_date = LocalDate.now(); // Current date
            Date start_date = p.getStart_date();
            int duration = p.getDuration();
            LocalDate end_date = start_date.toLocalDate().plusDays(duration);
            String statuss = p.getStatuss();
            String desc = p.getDesc();

            String roleCheckSql = "SELECT COUNT(*) FROM Emp INNER JOIN roles ON Emp.role_id = roles.role_id WHERE Emp.username = ? AND roles.role = 'Lead'";
            int roleCount = j.queryForObject(roleCheckSql, Integer.class, created_by);

            if (roleCount == 0) {
                return "Only lead can add tasks.";
            }

            String leadCheckSql = "SELECT COUNT(*) FROM Emp_Pro_Details WHERE emp_id = ? AND emp_lead = ?";
            int leadCount = j.queryForObject(leadCheckSql, Integer.class, assigned_to, created_by);

            if (leadCount == 0) {
                return "Assigned employee must be under the lead.";
            }

            String assignCheck= "select count(*) from Tasklist where assigned_to=?";
            int empCount= j.queryForObject(assignCheck, Integer.class,assigned_to);
            if(empCount > 0){
                return "Employee already assigned to a task";
            }
            String insertSql = "INSERT INTO Tasklist (task_id, task_name, created_by, assigned_to, assign_date, start_date, duration, end_date, statuss, `desc`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            j.update(insertSql, task_id, task_name, created_by, assigned_to, assign_date, start_date, duration, Date.valueOf(end_date), statuss, desc);

            return "Task added successfully.";
        } catch (Exception e) {
            System.out.println(e);
            return "Failed to add task: " + e.getMessage();
        }
    }
    // public List<Map<String, Object>> getTasksByEmpIdAndProjectId(int emp_id, int project_id) {
    //     StringBuilder sql = new StringBuilder("SELECT * FROM Tasklist WHERE 1=1");
    
    //     if (emp_id > 0) {
    //         sql.append(" AND assigned_to = ").append(emp_id);
    //     }
    //     if (project_id > 0) {
    //         sql.append(" AND project_id = ").append(project_id);
    //     }
    
    //     return j.queryForList(sql.toString());
    // }
   
    
}