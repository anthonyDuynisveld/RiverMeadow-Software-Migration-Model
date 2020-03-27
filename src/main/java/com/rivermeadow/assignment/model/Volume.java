
package com.rivermeadow.assignment.model;

import org.springframework.data.annotation.Id;

import com.rivermeadow.assignment.model.generics.IdedTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 	Define class Volume that contains the following fields

	Mount point  (c:\)
	Total size of the volume

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Volume implements IdedTable {
	
	@Id
	private Long id;
	
	private String MountPoint;
	
	private long size;
}
