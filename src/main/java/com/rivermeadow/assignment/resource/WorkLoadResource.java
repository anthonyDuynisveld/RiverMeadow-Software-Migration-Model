package com.rivermeadow.assignment.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rivermeadow.assignment.model.TargetCloud;
import com.rivermeadow.assignment.model.WorkLoad;
import com.rivermeadow.assignment.repository.TargetCloudRepository;
import com.rivermeadow.assignment.repository.WorkLoadRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/workLoads")
public class WorkLoadResource extends GenericResource<WorkLoadRepository, WorkLoad>{

}
