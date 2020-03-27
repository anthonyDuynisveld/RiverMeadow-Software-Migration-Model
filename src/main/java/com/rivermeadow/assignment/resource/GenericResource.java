package com.rivermeadow.assignment.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rivermeadow.assignment.model.Migration;
import com.rivermeadow.assignment.model.generics.IdedTable;
import com.rivermeadow.assignment.repository.MigrationRepository;

import javax.validation.Valid;
import java.util.List;

public class GenericResource<R extends MongoRepository<P, Long>, P extends IdedTable> {
	  @Autowired
	  private R repository;
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<P> getAllMigration() {
	    return repository.findAll();
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public P getById(@PathVariable("id") Long id) {
	    return repository.findById(id).get();
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyMigrationById(@PathVariable("id") Long id, @Valid @RequestBody P param) {
	    param.setId(id);
	    repository.save(param);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public P createMigration(@Valid @RequestBody P param) {
	    param.setId(param.getId());
	    repository.save(param);
	    return param;
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
