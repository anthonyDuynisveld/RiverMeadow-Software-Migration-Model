package com.rivermeadow.assignment.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.rivermeadow.assignment.model.data.MigrationStatus;
import com.rivermeadow.assignment.model.generics.IdedTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 	Define class Migration that contains the following

	Selected Mount Points (array of strings)
	Source field of type Workload
	TargetCloud field of type TargetCloud
	Migration state: not started, running, error, success

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Migration implements IdedTable {
	
	@Id
	private Long id;
	
	private WorkLoad workLoad;
	
	private List<Volume> targetVolumes;
	
	private TargetCloud targetCloud;
	
	private MigrationStatus migrationStatus;

}
