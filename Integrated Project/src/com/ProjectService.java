package com;


import model.ProjectModel;

//for REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

//Implement Restful APIs for CRUD operations
@Path("/ProjectModel")
public class ProjectService {
	
	ProjectModel ProjectObj = new ProjectModel();
	
	
	
	//Restful web service for Get Method
	@GET
	@Path("/retrieveProjects")
	@Produces(MediaType.TEXT_HTML)
	public String retrieveProjects()
	{
		return ProjectObj.retrieveProjects();//call the retrieveProjects() method in the ProjectModel class
	}
	
	
	//Restful web service for Post Method
	@POST
	@Path("/insertProjects")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) //Specify the input type
	@Produces(MediaType.TEXT_PLAIN) //Specify the output type as text plain 
	public String insertProjects(@FormParam("Pro_Name") String Pro_Name,
			@FormParam("Pro_Category") String Pro_Category,
			@FormParam("Pro_Description") String Pro_Description)
			 
	{ 
		//Pass the element values to retrieveProjects() method
		String output = ProjectObj.insertProjects(Pro_Name, Pro_Category, Pro_Description);
		return output; 
	}
	
	
	//Restful web service for Put Method	
	@PUT 	
	@Path("/updateProjects")
	@Consumes(MediaType.APPLICATION_JSON) //Accept the input to this End point as JSON 
	@Produces(MediaType.TEXT_PLAIN) //Specify the output type
	public String updateProjects(String ProjectData) 
	{
		//Convert the input string to a JSON object
		JsonObject ProjectOb = new JsonParser().parse(ProjectData).getAsJsonObject(); 
		
		//Read the values from the JSON object 
		String Pro_ID = ProjectOb.get("Pro_ID").getAsString();
		String Pro_Name = ProjectOb.get("Pro_Name").getAsString();
		String Pro_Category = ProjectOb.get("Pro_Category").getAsString(); 
		String Pro_Description = ProjectOb.get("Pro_Description").getAsString(); 
		
		//Call the updateProjects() method in ProjectModel class
		String output = ProjectObj.updateProjects(Pro_ID, Pro_Name, Pro_Category, Pro_Description); 
		
		return output;
	}
	
	
	//Restful web service for Delete Method
	@DELETE
	@Path("/deleteProjects")
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProjects(String ProjectData) //Method for read XML data set
	{
		//Convert the input string to an XML document 
		Document doc = Jsoup.parse(ProjectData, "", Parser.xmlParser()); 
		
		//Read the value from the element <Pro_ID>
		String Pro_ID = doc.select("Pro_ID").text(); 
		String output = ProjectObj.deleteProjects(Pro_ID); 
		return output;
		
	}
	
}
