package com.example.emp.employee;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
EmpService es;
@PostMapping("/add")
public String addEmp(@RequestBody EmpPojo e) {
    try {
        String resultMessage = es.addEmp(e);
        return resultMessage;
    } catch (RuntimeException ex) {
        return ex.getMessage();
    }
}

    @GetMapping("/getdata")
    // public List<Map<String, Object>> getdetails(@RequestParam (required = false)String fname,
    //                                             @RequestParam (required = false)String lname,
    //                                             @RequestParam (required = false) String dept,
    //                                             @RequestParam (required = false)String location) {
    //   EmpPojo ep= new EmpPojo();
    //   ep.setFname(fname);
    //   ep.setLname(lname);
    //   ep.setDept(dept);
    //   ep.setLocation(location);
    //   return    es.getDetails(ep);
    // }
    public List<Map<String, Object>> getDetails(
        @RequestParam(required = false) String fname,
        @RequestParam(required = false) String lname,
        @RequestParam(required = false) String dept,
        @RequestParam(required = false) String location) {
        return es.getDetails(fname, lname, dept, location);
    }
    
}
