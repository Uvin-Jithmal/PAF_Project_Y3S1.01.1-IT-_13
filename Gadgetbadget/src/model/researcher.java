package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class researcher {

	
	public Connection connect()
	{ 
	 Connection con = null; 
	 
	 try 
	 { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", ""); 
	 //For testing
	 System.out.print("Successfully connected"); 
	 } 
	 catch(Exception e) 
	 { 
	 e.printStackTrace(); 
	 } 
	 
	 return con; 
	}
	
	

	
//insert
	
	
	public String insertResearcher(int RID, String Rname, String Remail, String Rabout,String Pname,String PDes,int Pprice)
	{ 
	 String output = ""; 
	try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 { 
	 return "Error while connecting to the database"; 
	 } 
	 // create a prepared statement

	 
	 String query = " insert into researcher( ResearcherID,ResearcherName,ResearcherEmail,AboutResearcher,ProjectName,ProjectDescription,Projectprice)"
	 + " values (?, ?, ?, ?, ?, ?, ?)"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, RID); 
	 preparedStmt.setString(2, Rname); 
	 preparedStmt.setString(3, Remail); 
	 preparedStmt.setString(4, Rabout);
	 preparedStmt.setString(5, Pname);
	 preparedStmt.setString(6, PDes);
	 preparedStmt.setInt(7, Pprice);
	//execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Inserted successfully"; 
	 } 
	catch (Exception e) 
	 { 
	 output = "Error while inserting"; 
	 System.err.println(e.getMessage()); 
	 } 
	return output; 
	}

	
	
	public String readResearcher() 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for reading."; } 
	 // Prepare the html table to be displayed
	 output = "<table border='1'><tr><th>Reseacher ID</th><th>Researcher Name</th>" +
	 "<th>Researcher Email</th>" + 
	 "<th>About Researcher</th>" + 
	 "<th>Project Name</th>" +
	 "<th>Project Description</th>" +
	 "<th>Project Price</th>" +
	 "<th>Update</th><th>Remove</th></tr>"; 
	 
	 String query = "select * from researcher"; 
	 Statement stmt = con.createStatement(); 
	 ResultSet rs = stmt.executeQuery(query); 
	 // iterate through the rows in the result set
	 while (rs.next()) 
	 { 
	 String RID = Integer.toString(rs.getInt("ResearcherID")); 
	 String Rname = rs.getString("ResearcherName"); 
	 String Remail = rs.getString("ResearcherEmail"); 
	 String Rabout =rs.getString("AboutResearcher"); 
	 String Pname =rs.getString("ProjectName"); 
	 String PDes = rs.getString("ProjectDescription");
	 String Pprice = Integer.toString(rs.getInt("Projectprice"));
	 // Add into the html table
	 output += "<tr><td>" + RID + "</td>"; 
	 output += "<td>" + Rname + "</td>"; 
	 output += "<td>" + Remail + "</td>";
	 output += "<td>" + Rabout + "</td>"; 
	 output += "<td>" + Pname + "</td>";
	 output += "<td>" + PDes + "</td>";
	 output += "<td>" + Pprice + "</td>";
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
	 + "<td><form method='post' action='items.jsp'>"
	 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
	 + "<input name='itemID' type='hidden' value='" + RID 
	 + "'>" + "</form></td></tr>"; 
	 } 
	 con.close(); 
	 // Complete the html table
	 output += "</table>"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while reading Researchers."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	
	
	public String updateResearcher(int RID, String Rname, String Remail, String Rabout,String Pname,String PDes,int Pprice)
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for updating."; } 
	 // create a prepared statement
	 String query = "UPDATE researcher SET ResearcherName=?,ResearcherEmail=?,AboutReseacher=?,ProjectName=?,ProjectDescription=?,ProjectPrice=? WHERE ResearcherID=?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setString(1, Rname); 
	 preparedStmt.setString(2, Remail); 
	 preparedStmt.setString(3, Rabout);
	 preparedStmt.setString(4, Pname);
	 preparedStmt.setString(5, PDes);
	 preparedStmt.setInt(6, Pprice); 
	 preparedStmt.setInt(7, (RID)); 
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Updated successfully"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while updating the item."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	
	/*
	public String deleteItem(String itemID) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for deleting."; } 
	 // create a prepared statement
	 String query = "delete from items where itemID=?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(itemID)); 
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Deleted successfully"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while deleting the item."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	
	
	
	
	
	*/
	
	
	
}
