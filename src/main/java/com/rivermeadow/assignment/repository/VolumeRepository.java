package com.rivermeadow.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rivermeadow.assignment.model.Volume;

@Repository
public interface VolumeRepository extends MongoRepository<Volume, Long> {

}
