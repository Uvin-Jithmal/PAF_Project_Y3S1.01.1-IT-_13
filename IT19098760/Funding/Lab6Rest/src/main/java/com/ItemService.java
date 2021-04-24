package com;
import model.Item; 
//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*; 
//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 



@Path("/Items") 
public class ItemService 
{ 
 Item itemObj = new Item(); 
@GET
@Path("/") 
@Produces(MediaType.TEXT_HTML) 
public String readItems() 
 { 
	return itemObj.readItems(); 
 } 


@POST
@Path("/") 
@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
@Produces(MediaType.TEXT_PLAIN) 
public String insertItem(@FormParam("createdDate") String createdDate, @FormParam("amount") String amount) 
{ 
 String output = itemObj.insertItem(createdDate, amount); 
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
 String fundID = itemObject.get("fundID").getAsString(); 
 String createdDate = itemObject.get("createdDate").getAsString(); 
 String amount = itemObject.get("amount").getAsString(); 
 String output = itemObj.updateItem(fundID, createdDate, amount); 
return output; 
}



@DELETE
@Path("/") 
@Consumes(MediaType.APPLICATION_XML) 
@Produces(MediaType.TEXT_PLAIN) 
public String deleteItem(String itemData) 
{ 
//Convert the input string to an XML document
 Document doc = Jsoup.parse(itemData, "", Parser.xmlParser()); 
 
//Read the value from the element <itemID>
 String fundID = doc.select("fundID").text(); 
 String output = itemObj.deleteItem(fundID); 
return output; 
}


}