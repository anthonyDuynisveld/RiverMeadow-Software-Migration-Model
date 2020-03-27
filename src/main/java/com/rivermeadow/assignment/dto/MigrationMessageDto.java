package com.rivermeadow.assignment.dto;

import com.rivermeadow.assignment.model.data.MigrationStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MigrationMessageDto {

	public MigrationMessageDto(MigrationStatus status) {
		this(status, "");		
	}
	
	private MigrationStatus status;
	
	private String Message;
}
