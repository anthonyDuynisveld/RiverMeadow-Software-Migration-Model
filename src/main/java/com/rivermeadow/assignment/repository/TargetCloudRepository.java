package com.rivermeadow.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rivermeadow.assignment.model.TargetCloud;

@Repository
public interface TargetCloudRepository extends MongoRepository<TargetCloud, Long> {

}
