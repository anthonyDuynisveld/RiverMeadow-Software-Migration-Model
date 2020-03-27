package com.rivermeadow.assignment.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rivermeadow.assignment.model.Migration;
import com.rivermeadow.assignment.repository.MigrationRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/migrations")
public class MigrationResource {
	  @Autowired
	  private MigrationRepository repository;
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<Migration> getAllMigration() {
	    return repository.findAll();
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public Migration getMigrationById(@PathVariable("id") Long id) {
	    return repository.findById(id).get();
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyMigrationById(@PathVariable("id") Long id, @Valid @RequestBody Migration migrations) {
	    migrations.setId(id);
	    repository.save(migrations);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public Migration createMigration(@Valid @RequestBody Migration migrations) {
	    migrations.setId(migrations.getId());
	    repository.save(migrations);
	    return migrations;
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteMigration(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.DELETE)
	  public void deleteAll() {
	    repository.deleteAll();
	  }

	}
