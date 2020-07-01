package com.mongospring.mongospringprogram.controller;

import com.mongospring.mongospringprogram.model.Department;
import com.mongospring.mongospringprogram.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping(value="/save1")
    public String saveDept(@RequestBody Department department){
        departmentRepository.save(department);
        return "Dept saved";
    }
}
