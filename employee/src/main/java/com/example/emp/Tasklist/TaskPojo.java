package com.example.emp.Tasklist;

import java.sql.Date;
import java.time.LocalDate;

public class TaskPojo {
    private int task_id;
    private String task_name;
    private String created_by;
    private int assigned_to;
    private LocalDate assign_date; 
    private Date start_date; 
    private int duration;
    public int getTask_id() {
        return task_id;
    }
    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }
    public String getTask_name() {
        return task_name;
    }
    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }
    public String getCreated_by() {
        return created_by;
    }
    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
    public int getAssigned_to() {
        return assigned_to;
    }
    public void setAssigned_to(int assigned_to) {
        this.assigned_to = assigned_to;
    }
    public LocalDate getAssign_date() {
        return assign_date;
    }
    public void setAssign_date(LocalDate assign_date) {
        this.assign_date = assign_date;
    }
    public Date getStart_date() {
        return start_date;
    }
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getStatuss() {
        return statuss;
    }
    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    private String statuss;
    private String desc;


}
