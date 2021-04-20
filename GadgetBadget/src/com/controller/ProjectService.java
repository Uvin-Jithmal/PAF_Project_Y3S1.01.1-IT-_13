package com.controller;


import com.model.ProjectModel;

//for REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/ProjectModel")
public class ProjectService {
	
	ProjectModel ProjectObj = new ProjectModel();
	
	
	//Restful web service for Get Method
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String retrieveProjects()
	{
		return ProjectObj.retrieveProjects();
	}
	
	
	//Restful web service for Post Method
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertProjects(@FormParam("name") String name,
			@FormParam("category") String category,
			@FormParam("description") String description)
			 
	{ 
		String output = ProjectObj.insertProjects(name, category, description);
		return output; 
	}
	
	
	//Restful web service for Put Method	
	@PUT 	
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProjects(String ProjectData) 
	{
		//Convert the input string to a JSON object
		JsonObject ProjectOb = new JsonParser().parse(ProjectData).getAsJsonObject(); 
		
		//Read the values from the JSON object 
		Integer Pro_ID = ProjectOb.get("Pro_ID").getAsInt();
		String Pro_Name = ProjectOb.get("Pro_Name").getAsString();
		String Pro_Category = ProjectOb.get("Pro_Category").getAsString(); 
		String Pro_Decription = ProjectOb.get("Pro_Decription").getAsString(); 
		
		String output = ProjectObj.updateProjects(Pro_ID, Pro_Name, Pro_Category, Pro_Decription); 
		
		return output;
	}
	
	
	//Restful web service for Delete Method
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProjects(String itemData) 
	{
		//Convert the input string to an XML document 
		Document doc = Jsoup.parse(itemData, "", Parser.xmlParser()); 
		
		//Read the value from the element <Pro_ID>
		String Pro_ID = doc.select("Pro_ID").text(); 
		String output = ProjectObj.deleteProjects(Pro_ID); 
		return output;
		
	}
	
}
