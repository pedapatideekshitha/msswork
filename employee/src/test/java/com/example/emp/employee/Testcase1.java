package com.example.emp.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Testcase1 {
    DataSource dataSource = createDataSource();
    EmpService ec = new EmpService(dataSource);
    JdbcTemplate jdbc = new JdbcTemplate(dataSource);   

    @Test
    public void test_insert_emp()
    {
        EmpPojo e = new EmpPojo();
        e.setFname("xyz");
        e.setLname("yzx");
        e.setDept("swtrainee");
        e.setEmail("xyz@gmail.com");
        e.setPincode(522007);
        e.setPn_no(12398745);
        e.setSalary(4645);
        e.setLocation("vizag");
        e.setRole_id(1);
        e.setAddedby(1);
        String result = ec.addEmp(e);
        assertEquals("Employee added successfully.", result);
    }
    
        @Test
    public void test_show_emp()
    {
        EmpPojo e = new EmpPojo();
        e.setFname("samuel");
        e.setLname("shaik");
        e.setDept("Sales");
        e.setLocation("Vizag");
        String query = "SELECT * FROM Emp WHERE 1=1 ";
        List<Map<String,Object>> result = ec.getDetails(e.getFname(), e.getLname(), e.getDept(), e.getLocation());
        if(e.getFname()!=null)
        {
            query=query+" and fname=\""+e.getFname()+"\"";
        }
        if(e.getLname()!=null)
        {
            query=query+" and lname=\""+e.getLname()+"\"";
        }
        if(e.getDept()!=null)
        {
            query=query+" and dept=\""+e.getDept()+"\"";
        }
        if(e.getLocation()!=null)
        {
            query=query+" and location like \'%"+e.getLocation()+"%\'";
        }
            List<Map<String,Object>> details = jdbc.queryForList(query);
        List<Map<String,Object>> a = new ArrayList<>();


        String keys[]={"emp_id","fname","lname","dept","pn_no","join_date","salary","work_mail","location",
        "password","pincode","email","role_id","username","addedby"};
        for(int i=0;i<details.size();i++)
        {
            Collection<Object> values=details.get(i).values();
            Map<String,Object> dummy=new LinkedHashMap<>();
            for(int j=0;j<keys.length;j++)
            {
                dummy.put(keys[j],values.toArray()[j]);
            }
            a.add(dummy);
        }
        assertEquals(result.size(), a.size());

        for (Map<String, Object> resultMap : result) {
            assertTrue(a.contains(resultMap));
        }
    }
    private DataSource createDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Employee");
        dataSource.setUsername("root");
        dataSource.setPassword("M1racle@123");
        return dataSource;
    }
}
