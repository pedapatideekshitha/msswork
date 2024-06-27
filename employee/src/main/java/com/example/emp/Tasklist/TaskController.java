package com.example.emp.Tasklist;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/task")

public class TaskController {
    @Autowired
TaskService ts;
@PostMapping("/add")

public String addTask(@RequestBody TaskPojo p) {
    
    return ts.addTask(p);
}
 

}
