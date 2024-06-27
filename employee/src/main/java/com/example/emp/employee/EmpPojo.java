package com.example.emp.employee;

import java.time.LocalDateTime;

public class EmpPojo {
 private String fname;
    private String lname;
    private String dept;
    private long pn_no;
    private LocalDateTime join_date;
    private long salary;
    private String location;
    private int pincode;
   private String email;
   private int role_id;
   private int addedby;


    public int getRole_id() {
    return role_id;
}
public void setRole_id(int role_id) {
    this.role_id = role_id;
}
public int getAddedby() {
    return addedby;
}
public void setAddedby(int addedby) {
    this.addedby = addedby;
}
    public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public long getPn_no() {
        return pn_no;
    }
    public void setPn_no(long pn_no) {
        this.pn_no = pn_no;
    }
    public LocalDateTime getJoin_date() {
        return join_date;
    }
    public void setJoin_date(LocalDateTime join_date) {
        this.join_date = join_date;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getPincode() {
        return pincode;
    }
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

}
