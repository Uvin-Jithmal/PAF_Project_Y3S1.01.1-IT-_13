package com;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*; 
//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

import model.researcher;

@Path("/researcher")
public class researcherService {

	researcher reObj = new researcher(); 
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readResearcher() 
	 { 
	 return reObj.readResearcher(); 
	 } 
	
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertResearcher( 
	 @FormParam("ResearcherName") String ResearcherName, 
	 @FormParam("ResearcherEmail") String ResearcherEmail, 
	 @FormParam("AboutResearcher") String AboutResearcher,
	 @FormParam("ProjectName") String ProjectName,
	 @FormParam("ProjectDescription") String ProjectDescription,
	 @FormParam("ProjectPrice") String ProjectPrice) 
	{ 
	 String output = reObj.insertResearcher(ResearcherName, ResearcherEmail, AboutResearcher,ProjectName,ProjectDescription,ProjectPrice); 
	return output; 
	}

	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateItem(String itemData) 
	{ 
	//Convert the input string to a JSON object 
	 JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject(); 
	//Read the values from the JSON object
	 int RID = itemObject.get("RID").getAsInt(); 
	 String Rname = itemObject.get("Rname").getAsString(); 
	 String Remail = itemObject.get("Remail").getAsString(); 
	 String Rabout = itemObject.get("Rabout").getAsString();
	 String Pname = itemObject.get("Pname").getAsString();
	 String PDes = itemObject.get("PDes").getAsString(); 
	 int Pprice = itemObject.get("Pprice").getAsInt(); 
	 String output = reObj.updateResearcher(RID, Rname, Remail, Rabout, Pname, PDes, Pprice);
	return output; 
	}
	
	
}
