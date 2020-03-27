package com.rivermeadow.assignment.resource;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rivermeadow.assignment.controllers.MigrationController;
import com.rivermeadow.assignment.dto.DatabaseDto;
import com.rivermeadow.assignment.dto.MigrationMessageDto;
import com.rivermeadow.assignment.model.*;
import com.rivermeadow.assignment.model.data.*;

import lombok.extern.slf4j.Slf4j;

/*
 * Implement run method - run method should sleep for 5 min (simulate running migration) copy source object to the 
target field of TargetCloud and target should only have volumes that are selected in the migration. For example, 
if source has: C:\ D: and E:\ and only C: was selected, target should only have C:\

Implement business logic to not allow running migrations when volume C:\ is not included in the 
selected mount points list

 */
		
@Slf4j
@RestController
@RequestMapping("/execute")
public class MigrationControllerResource {

	  @Autowired
	  private MigrationResource migrationResource;
	  @Autowired
	  private VolumeResource volumeResource;
	  @Autowired
	  private WorkLoadResource workLoadResource;
	  @Autowired
	  private TargetCloudResource targetCloudResource;
	  @Autowired
	  private MigrationController migrationController;

	
	  @RequestMapping(value = "/migrations/{id}", method = RequestMethod.GET)
	  public MigrationMessageDto executeMigrations(@PathVariable("id") Long id) {
		  return migrationController
				  .migrateServer(migrationResource.getMigrationById(id));
		  
	  }

	  @RequestMapping(value = "/getAllData", method = RequestMethod.GET)
	  public DatabaseDto getAllData() {
		  return new DatabaseDto(
				  migrationResource.getAllMigration(),
				  targetCloudResource.getAllTargetCloud(),
				  workLoadResource.getAllWorkLoad(),
				  volumeResource.getAllVolume()
				  );
	  }

	  @RequestMapping(value = "/dataPopulation", method = RequestMethod.GET)
	  public void populateData() {
		  List<Volume> volumes = Arrays.asList(
			  new Volume(Long.valueOf(12654), "C:\\", 1024l),
			  new Volume(Long.valueOf(126512344), "G:\\", 4096l),
			  new Volume(Long.valueOf(121254), "D:\\", 2048l),
			  new Volume(Long.valueOf(126512434), "A:\\", 8192l),
			  new Volume(Long.valueOf(223451234), "H:\\", 512),
			  new Volume(Long.valueOf(121234254), "E:\\", 256l)
			  );
		  volumeResource.createVolume(volumes.get(0));
		  volumeResource.createVolume(volumes.get(1));
		  volumeResource.createVolume(volumes.get(2));

		  List<WorkLoad> workLoads = Arrays.asList(
				  new WorkLoad(Long.valueOf(12654), 
						  new WebAuthenticationCredentials("asdf", "qwer", "xzcv"), 
						  Arrays.asList(volumes.get(3), volumes.get(4))),
				  new WorkLoad(Long.valueOf(126512344), 
						  new WebAuthenticationCredentials("hdf", "shr", "heq"), 
						  Arrays.asList(volumes.get(0), volumes.get(1))),
				  new WorkLoad(Long.valueOf(121254),  
						  new WebAuthenticationCredentials("asdasd", "awef", "heqdf"), 
						  Arrays.asList(volumes.get(2), volumes.get(5))),
				  new WorkLoad(Long.valueOf(126512434),  
						  new WebAuthenticationCredentials("awebea", "faw", "FAta"),
						  Arrays.asList(volumes.get(0), volumes.get(2), volumes.get(4))),
				  new WorkLoad(Long.valueOf(223451234),  
						  new WebAuthenticationCredentials("wrtwb", "reyt", "htru"),
						  Arrays.asList(volumes.get(1), volumes.get(4))),
				  new WorkLoad(Long.valueOf(121234254),  
						  new WebAuthenticationCredentials("awnas", "aeyyrn", "sdyb"),
						  Arrays.asList(volumes.get(5), volumes.get(3)))
				  );

		  workLoadResource.createWorkLoad(workLoads.get(0));
		  workLoadResource.createWorkLoad(workLoads.get(1));
		  workLoadResource.createWorkLoad(workLoads.get(2));

		  List<TargetCloud> targetClouds = Arrays.asList(
				  new TargetCloud(Long.valueOf(12654), CloudType.AZURE,  
						  new WebAuthenticationCredentials("aruxsdf", "erac", "ruysdfa"), 
						  workLoads.get(0)),
				  new TargetCloud(Long.valueOf(126512344), CloudType.AWS,  
						  new WebAuthenticationCredentials("xzxgr", "arytb", "abet"), 
						  workLoads.get(1)),
				  new TargetCloud(Long.valueOf(121254), CloudType.VSPHERE,  
						  new WebAuthenticationCredentials("rtsdc", "ruivz", "seyb"), 
						  workLoads.get(2)),
				  new TargetCloud(Long.valueOf(126512434), CloudType.VCLOUD,  
						  new WebAuthenticationCredentials("ursvya", "eyax", "basvdthf"),  
						  workLoads.get(3)),
				  new TargetCloud(Long.valueOf(223451234), CloudType.AZURE,  
						  new WebAuthenticationCredentials("vry", "rsvds", "byjtvgrs"),  
						  workLoads.get(4)),
				  new TargetCloud(Long.valueOf(121234254), CloudType.AWS,  
						  new WebAuthenticationCredentials("vrts", "rbtrfd", "vjrcs"),  
						  workLoads.get(5))
				  );
		  
		  targetCloudResource.createTargetCloud(targetClouds.get(0));
		  targetCloudResource.createTargetCloud(targetClouds.get(1));
		  targetCloudResource.createTargetCloud(targetClouds.get(2));

		  List<Migration> migrations = Arrays.asList(
				  new Migration(Long.valueOf(12654), 
						  workLoads.get(0),
						  Arrays.asList(volumes.get(3), volumes.get(1)),
						  targetClouds.get(1),
						  MigrationStatus.NOT_STARTED),
				  new Migration(Long.valueOf(126512344), 
						  workLoads.get(1),
						  Arrays.asList(volumes.get(3)),
						  targetClouds.get(2),
						  MigrationStatus.NOT_STARTED),
				  new Migration(Long.valueOf(121254),  
						  workLoads.get(2),
						  Arrays.asList(volumes.get(2), volumes.get(4)),
						  targetClouds.get(3),
						  MigrationStatus.NOT_STARTED),
				  new Migration(Long.valueOf(126512434),  
						  workLoads.get(3),
						  Arrays.asList(volumes.get(0), volumes.get(5)),
						  targetClouds.get(4),
						  MigrationStatus.NOT_STARTED),
				  new Migration(Long.valueOf(223451234),  
						  workLoads.get(4),
						  Arrays.asList(volumes.get(1)),
						  targetClouds.get(5),
						  MigrationStatus.NOT_STARTED),
				  new Migration(Long.valueOf(121234254),  
						  workLoads.get(5),
						  Arrays.asList(volumes.get(0)),
						  targetClouds.get(0),
						  MigrationStatus.NOT_STARTED)
				  );

		  migrationResource.createMigration(migrations.get(0));
		  migrationResource.createMigration(migrations.get(1));
		  migrationResource.createMigration(migrations.get(2));
}

}
