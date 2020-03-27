package com.rivermeadow.assignment.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rivermeadow.assignment.model.Volume;
import com.rivermeadow.assignment.repository.VolumeRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/volumes")
public class VolumeResource {
	  @Autowired
	  private VolumeRepository repository;
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<Volume> getAllVolume() {
	    return repository.findAll();
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public Volume getVolumeById(@PathVariable("id") Long id) {
	    return repository.findById(id).get();
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyVolumeById(@PathVariable("id") Long id, @Valid @RequestBody Volume volumes) {
	    volumes.setId(id);
	    repository.save(volumes);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public Volume createVolume(@Valid @RequestBody Volume volumes) {
	    volumes.setId(volumes.getId());
	    repository.save(volumes);
	    return volumes;
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteVolume(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
	  @RequestMapping(value = "/", method = RequestMethod.DELETE)
	  public void deleteAll() {
	    repository.deleteAll();
	  }

	}
