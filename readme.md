Hello and welcome to my River Meadow Migration Tool

	I have been working on the project since about 9:00 this morning. I currently have my programming PC out of commission due to mismatched part purchase timing. So for this assignment I have needed to set up my entire Java development environment on my sister in-laws PC. As such the project has taken quite a bit longer than anticipated.
   
   The final result is non the less to adequate satisfaction. It has an embeded tomcat server, mangoDB serve, and basic credential validation. Enter the following urls in your web browser to execute the desired actions
   
   Login with the following credentials
   user rivermeadow
   pass rivermeadow
   
   Execute this url first to populate the embeded database with data
   http://localhost:8080/rivermeadowassignment/execute/dataPopulation
   Execute this url to retrieve all data
   http://localhost:8080/rivermeadowassignment/execute/getAllData 
   Execute the following with a Migration ID to execute one of the pre planned migrations 
   http://localhost:8080/rivermeadowassignment/execute/migrations/{id}

   The following url format can be used to access and manipulate all specific data sets
   data table		related POJO		sample POJO
   targetClouds		TargetCloud	
   volumes			Volume
   migrations		Migration			
   workLoads		WorkLoad
   
   http://localhost:8080/rivermeadowassignment/{dataTable}
	  Get all data 			/		method = GET	
   	  Get single record		/{id} 	method = GET
	  Update record			/{id} 	method = PUT	RequestBody {related POJO}
	  create new record		/ 		method = POST 	RequestBody {related POJO} 
	  delete record			/{id} 	method = DELETE
   