package com.example.emp.employee;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
@Autowired
JdbcTemplate j;
public EmpService(DataSource ds){
    this.j=new JdbcTemplate(ds);
}
public String addEmp(EmpPojo p){
    String fname= p.getFname();
    String lname= p.getLname();
    String dept= p.getDept();
    long pn_no= p.getPn_no();
    LocalDateTime join_date = LocalDateTime.now();
    long salary= p.getSalary();
    String work_mail= (fname.charAt(0)+lname+"@miraclesoft.com").toLowerCase();
    String location = p.getLocation();
    // String fn= fname.substring(fname.length() - 2, fname.length() - 1).toUpperCase()+fname.charAt(-1);
    // String ln= lname.substring(lname.length() - 2, lname.length() - 1).toUpperCase()+lname.charAt(-1);
    int role_id= p.getRole_id();
    String username= fname.charAt(0)+lname;
    int addedby= p.getAddedby();
    String fn = "";
    if (fname.length() > 1) {
        fn = fname.substring(fname.length() - 2, fname.length() - 1).toUpperCase() + fname.charAt(fname.length() - 1);
    } else if (fname.length() == 1) {
        fn = fname.toUpperCase();
    }
    
    String ln = "";
    if (lname.length() > 1) {
        ln = lname.substring(lname.length() - 2, lname.length() - 1).toUpperCase() + lname.charAt(lname.length() - 1);
    } else if (lname.length() == 1) {
        ln = lname.toUpperCase();
    }

    String timePart = join_date.format(DateTimeFormatter.ofPattern("HHmm"));
    String password= fn+"@"+ln+timePart;
    int pincode= p.getPincode();
    String email= p.getEmail();

    if (!isAuthorized(addedby)) {
        throw new RuntimeException("Only admin can insert data.");
    }
    try {
        String sql = "INSERT INTO Emp (fname, lname, dept, pn_no, join_date, salary, work_mail, location, password, pincode, email, role_id, username, addedby) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            j.update(sql, fname, lname, dept, pn_no, join_date, salary, work_mail, location, password, pincode, email, role_id, username, addedby);
            return "Employee added successfully.";
    } catch (DataAccessException e) {
        throw new RuntimeException("Error adding employee: " + e.getMessage());    }
}

public boolean isAuthorized(int addedby) {
    try {
        String query = "SELECT roles.role FROM Emp JOIN roles ON Emp.role_id = roles.role_id WHERE emp_id = ?";
        String roleName = j.queryForObject(query, String.class, addedby);
        return  roleName.equals("Admin");
    } catch (EmptyResultDataAccessException e) {
        throw new RuntimeException("User not found or unauthorized.");
    } catch (Exception e) {
        throw new RuntimeException("Error checking authorization.", e);
    }
}

public List<Map<String, Object>> getDetails(String fname, String lname, String dept, String location) {
        StringBuilder sql = new StringBuilder("SELECT * FROM Emp WHERE 1=1");

        if (fname != null && !fname.isEmpty()) {
            sql.append(" AND fname LIKE '%" + fname + "%'");
        }
        if (lname != null && !lname.isEmpty()) {
            sql.append(" AND lname LIKE '%" + lname + "%'");
        }
        if (dept != null && !dept.isEmpty()) {
            sql.append(" AND dept LIKE '%" + dept + "%'");
        }
        if (location != null && !location.isEmpty()) {
            sql.append(" AND location LIKE '%" + location + "%'");
        }

        return j.queryForList(sql.toString());
    }
}
