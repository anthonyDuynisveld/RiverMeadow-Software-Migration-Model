package com.rivermeadow.assignment.dto;

import java.util.List;

import com.rivermeadow.assignment.model.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DatabaseDto {

	private List<Migration> migrations;
	
	private List<TargetCloud> targetClouds;
	
	private List<WorkLoad> workLoads;
	
	private List<Volume> volumes;
	
}
