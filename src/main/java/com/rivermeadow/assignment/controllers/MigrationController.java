package com.rivermeadow.assignment.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivermeadow.assignment.dto.MigrationMessageDto;
import com.rivermeadow.assignment.model.Migration;
import com.rivermeadow.assignment.model.TargetCloud;
import com.rivermeadow.assignment.model.WorkLoad;
import com.rivermeadow.assignment.model.data.MigrationStatus;
import com.rivermeadow.assignment.resource.TargetCloudResource;
import com.rivermeadow.assignment.resource.WorkLoadResource;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
public class MigrationController {

	private static final Random random = new Random();
	
	private WorkLoadResource workLoadResource;

	private TargetCloudResource targetCloudResource;
	
	public MigrationMessageDto migrateServer(Migration migration) { 
		WorkLoad workLoad = migration.getWorkLoad();
		TargetCloud targetCloud = migration.getTargetCloud();
		if (workLoad.getVolumes().stream().noneMatch(V -> V.equals("C:\\"))) {
			return new MigrationMessageDto (MigrationStatus.ERROR, "C drive not in mount point list");
		}
		try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
	  
	  return new MigrationMessageDto (MigrationStatus.values()[random.nextInt(2) + 1]);
	}

}
