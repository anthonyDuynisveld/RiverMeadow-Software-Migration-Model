package com.rivermeadow.assignment.model;

import java.util.List;

import javax.security.enterprise.credential.BasicAuthenticationCredential;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.rivermeadow.assignment.model.data.WebAuthenticationCredentials;
import com.rivermeadow.assignment.model.generics.IdedTable;
import com.rivermeadow.assignment.ultilities.UniqueIP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 	Define class Workload that contains the following fields:

	IP address
	Credentials (username, password, domain)
	Storage that contains array of volumes
	Constraints:

	Username, password, IP cannot not be Null
	IP cannot change
	You cannot have more than one source with the same IP

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkLoad implements IdedTable {
	
	@Id
	private Long id;

	@UniqueIP
	@NotNull
	private WebAuthenticationCredentials credentials;
	
	private List<Volume> volumes;

	
}
