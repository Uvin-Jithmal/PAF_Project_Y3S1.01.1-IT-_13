package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewItem {
	
	public Connection connect()
	{ 
	 Connection con = null; 
	 
	 try 
	 { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/funding_db", "root", ""); 
	 //For testing
	 System.out.print("Successfully connected"); 
	 } 
	 catch(Exception e) 
	 { 
	 e.printStackTrace(); 
	 } 
	 
	 return con; 
	}
	
	
	
	
	public String readItems() 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for reading."; } 
	 // Prepare the html table to be displayed
	 output = "<center><table border='1' ><tr><th>Fund ID</th><th>Created Date</th>" +
	 "<th>Amount</th></tr>"; 
	 
	 String query = "select * from fund;"; 
	 Statement stmt = con.createStatement(); 
	 ResultSet rs = stmt.executeQuery(query); 
	 // iterate through the rows in the result set
	 while (rs.next()) 
	 { 
	 String fundID = Integer.toString(rs.getInt("fundID")); 
	 String createdDate = rs.getString("createdDate"); 
	 String amount =  Integer.toString(rs.getInt("amount")); 

	 // Add into the html table
	 output += "<tr><td>" +fundID + "</td>"; 
	 output += "<td>" + createdDate + "</td>"; 
	 output += "<td>" + amount + "</td>";  
	 // buttons
	 output += "</td></tr>"; 
	 } 
	 con.close(); 
	 
	 // Complete the html table
	 output += "</table></center>"; 
	 
	 
	 
	 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while reading the items."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 

	
}
