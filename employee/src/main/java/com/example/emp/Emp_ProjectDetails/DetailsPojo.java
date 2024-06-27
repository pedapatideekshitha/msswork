package com.example.emp.Emp_ProjectDetails;

import java.time.LocalDateTime;

public class DetailsPojo {
    private int emp_id;
    private int project_id;
    private String username;
    private String lead;
    private String password;
    private LocalDateTime assigned_date;

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getAssigned_date() {
        return assigned_date;
    }

    public void setAssigned_date(LocalDateTime assigned_date) {
        this.assigned_date = assigned_date;
    }
}
