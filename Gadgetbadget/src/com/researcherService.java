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
	public String insertResearcher(@FormParam("RID") int RID, 
	 @FormParam("Rname") String Rname, 
	 @FormParam("Remail") String Remail, 
	 @FormParam("Rabout") String Rabout,
	 @FormParam("Pname") String Pname,
	 @FormParam("PDes") String PDes,
	 @FormParam("Pprice") int Pprice) 
	{ 
	 String output = reObj.insertResearcher(RID, Rname, Remail, Rabout,Pname,PDes,Pprice); 
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
