package com.rivermeadow.assignment.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rivermeadow.assignment.model.WorkLoad;
import com.rivermeadow.assignment.repository.WorkLoadRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/workLoads")
public class WorkLoadResource {
	  @Autowired
	  private WorkLoadRepository repository;
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<WorkLoad> getAllWorkLoad() {
	    return repository.findAll();
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public WorkLoad getWorkLoadById(@PathVariable("id") Long id) {
	    return repository.findById(id).get();
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyWorkLoadById(@PathVariable("id") Long id, @Valid @RequestBody WorkLoad workLoads) {
	    workLoads.setId(id);
	    repository.save(workLoads);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public WorkLoad createWorkLoad(@Valid @RequestBody WorkLoad workLoads) {
	    workLoads.setId(workLoads.getId());
	    repository.save(workLoads);
	    return workLoads;
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteWorkLoad(@PathVariable Long id) {
	    repository.deleteById(id);
	  }

	  @RequestMapping(value = "/", method = RequestMethod.DELETE)
	  public void deleteAll() {
	    repository.deleteAll();
	  }
}
