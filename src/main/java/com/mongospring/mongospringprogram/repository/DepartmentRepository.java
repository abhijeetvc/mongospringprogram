package com.mongospring.mongospringprogram.repository;

import com.mongospring.mongospringprogram.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department,String> {
}
