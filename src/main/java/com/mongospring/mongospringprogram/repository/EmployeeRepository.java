package com.mongospring.mongospringprogram.repository;

import com.mongospring.mongospringprogram.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee,String> {

    List<Employee> findByNameAndCity(String name, String city);
}
