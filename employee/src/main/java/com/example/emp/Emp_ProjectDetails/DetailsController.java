package com.example.emp.Emp_ProjectDetails;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    private DetailsService detailsService;

    @PostMapping("/add")
    public String addDetails(@RequestBody DetailsPojo detailsPojo) {
        return detailsService.addDetails(detailsPojo);
    }
    @GetMapping("/getdetails")
    public List<Map<String, Object>> getEmployeeDetailsByEmpLeadAndProjectId(
            @RequestParam(required = false) String emp_lead,
            @RequestParam(required = false) Integer project_id) {
        return detailsService.getEmployeeDetailsByEmpLeadAndProjectId(emp_lead, project_id);
    }
   
    @GetMapping("/getemployees")
    public List<Map<String, Object>> getEmployeesByProjectId(@RequestParam Integer project_id) {
        return detailsService.getEmpByProId(project_id);
    }

    // @GetMapping("/getempdetails")
    // public Map<String, Object> getDetails(@RequestParam Integer project_id) {
    //     return detailsService.getDetails(project_id);
    // }
@PostMapping("/getempdetails")
public List<Map<String,Object>> getDetails(@RequestBody DetailsPojo p){
    return detailsService.getDetails(p);
}



}
