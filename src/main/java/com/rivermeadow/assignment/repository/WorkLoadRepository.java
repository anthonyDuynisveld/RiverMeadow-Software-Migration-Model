package com.rivermeadow.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rivermeadow.assignment.model.WorkLoad;

@Repository
public interface WorkLoadRepository extends MongoRepository<WorkLoad, Long> {

}
