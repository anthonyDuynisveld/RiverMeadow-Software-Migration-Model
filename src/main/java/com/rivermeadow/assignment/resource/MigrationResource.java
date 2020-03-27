package com.rivermeadow.assignment.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rivermeadow.assignment.model.Migration;
import com.rivermeadow.assignment.repository.MigrationRepository;

@RestController
@RequestMapping("/migrations")
public class MigrationResource extends GenericResource<MigrationRepository, Migration>{
	
}
