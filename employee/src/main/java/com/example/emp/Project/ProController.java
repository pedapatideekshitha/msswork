package com.example.emp.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProController {

    @Autowired
    private ProService proService;

    @PostMapping("/add")
    public String addProject(@RequestBody ProPojo project) {
        return proService.addProject(project);
    }
}