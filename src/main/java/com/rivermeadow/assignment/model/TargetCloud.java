package com.rivermeadow.assignment.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.rivermeadow.assignment.model.data.CloudType;
import com.rivermeadow.assignment.model.data.WebAuthenticationCredentials;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 	Define class TargetCloud that contains the following fields:

	Cloud type: aws, azure, vsphere, vcloud - no other types are allowed
	Cloud credentials of type Credentials
	Target object of type Workload

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TargetCloud {

	@Id
	private Long id;

	private CloudType cloudType; 

	@NotNull
	private WebAuthenticationCredentials credentials;
	
	private WorkLoad target;
	
}
