package com.rivermeadow.assignment.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rivermeadow.assignment.model.TargetCloud;
import com.rivermeadow.assignment.repository.TargetCloudRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/targetClouds")
public class TargetCloudResource {
	  @Autowired
	  private TargetCloudRepository repository;
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<TargetCloud> getAllTargetCloud() {
	    return repository.findAll();
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public TargetCloud getTargetCloudById(@PathVariable("id") Long id) {
	    return repository.findById(id).get();
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyTargetCloudById(@PathVariable("id") Long id, @Valid @RequestBody TargetCloud targetClouds) {
	    targetClouds.setId(id);
	    repository.save(targetClouds);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public TargetCloud createTargetCloud(@Valid @RequestBody TargetCloud targetClouds) {
	    targetClouds.setId(targetClouds.getId());
	    repository.save(targetClouds);
	    return targetClouds;
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteTargetCloud(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.DELETE)
	  public void deleteAll() {
	    repository.deleteAll();
	  }

	}
