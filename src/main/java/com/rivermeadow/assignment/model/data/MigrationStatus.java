package com.rivermeadow.assignment.model.data;

import lombok.Getter;
import lombok.Setter;

/*
 * Migration state: not started, running, error, success
 */
public enum MigrationStatus {

	NOT_STARTED(), RUNNING, ERROR, SUCCESS;
	
	@Getter
	@Setter
	private String message;
}
