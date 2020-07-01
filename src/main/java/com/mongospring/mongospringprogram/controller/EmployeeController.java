package com.mongospring.mongospringprogram.controller;


import com.mongospring.mongospringprogram.model.Employee;
import com.mongospring.mongospringprogram.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(value="/save")
    public String saveData(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return "Employee saved";
    }

    @GetMapping(value="/getallemp")
    public List<Employee> getEmpList(){

        return employeeRepository.findAll();
    }

    @GetMapping(value="/getemp")
    public Map<String,Object> getEmp(@RequestParam(required = false) String id){

        Map<String,Object> map=new HashMap();
        try {
            Optional<Employee> e = employeeRepository.findById(id);
            map.put("data",e);
            return map;
        }catch (Exception e){
            System.out.println("Data not found");

            map.put("data","Employee not available");
           return map;
        }

    }

    @GetMapping(value="/getempdata/{name}/{city}")
    public List<Employee> getList(@PathVariable String name,
                                  @PathVariable String city){

        List<Employee> list=employeeRepository.findByNameAndCity(name,city);
        return list;

    }
}
