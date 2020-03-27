package com.rivermeadow.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rivermeadow.assignment.model.Migration;

@Repository
public interface MigrationRepository extends MongoRepository<Migration, Long> {

}
