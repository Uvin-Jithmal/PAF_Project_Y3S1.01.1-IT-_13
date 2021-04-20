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
	
	Project ProjectObj = new Project();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String retrieveProjects()
	{
		return ProjectObj.retrieveProjects();
	}
}
