package com.rivermeadow.assignment.model.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class WebAuthenticationCredentials {
	


	@Getter
	@Setter
	private String caller;
	
	@Getter
	@Setter
	private String password;

	@Getter
	private String webAddress;
	
	
}
