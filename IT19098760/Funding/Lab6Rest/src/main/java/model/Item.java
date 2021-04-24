package model; 
import java.sql.*; 
public class Item 
{ //A common method to connect to the DB

private Connection connect() 
 { 
 Connection con = null; 
 try
 { 
 Class.forName("com.mysql.jdbc.Driver"); 
 
 //Provide the correct details: DBServer/DBName, username, password 
 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/funding_db", "root", ""); 
 } 
 catch (Exception e) 
 {e.printStackTrace();} 
 return con; 
 } 


public String insertItem(String createdDate , String amount) 
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 {return "Error while connecting to the database for inserting."; } 
 // create a prepared statement
 String query = "INSERT INTO fund"+ " VALUES(NULL,?,?);"; 
 PreparedStatement preparedStmt = con.prepareStatement(query); 
 // binding values
 preparedStmt.setString(1, createdDate); 
 preparedStmt.setInt(2, Integer.parseInt(amount)); 
// execute the statement3
 preparedStmt.execute(); 
 con.close(); 
 output = "Inserted successfully"; 
 } 
 catch (Exception e) 
 { 
 output = "Error while inserting the item."; 
 System.err.println(e.getMessage()); 
 } 
 return output; 
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
 output = "<table border='1'><tr><th>Fund ID</th><th>Created Date</th>" +
 "<th>Amount</th>" + 
 "<th>Update</th><th>Remove</th></tr>"; 
 
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
 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
 + "<td><form method='post' action='items.jsp'>"
 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
 + "<input name='itemID' type='hidden' value='" + fundID 
 + "'>" + "</form></td></tr>"; 
 } 
 con.close(); 
 
 // Complete the html table
 output += "</table>"; 
 
 
 
 
 } 
 catch (Exception e) 
 { 
 output = "Error while reading the items."; 
 System.err.println(e.getMessage()); 
 } 
 return output; 
 } 






public String updateItem(String fundID, String createdDate, String amount)
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 {return "Error while connecting to the database for updating."; } 
 
 // create a prepared statement
 String query = "UPDATE fund SET createdDate=?,amount=? WHERE fundID=?"; 
 PreparedStatement preparedStmt = con.prepareStatement(query); 
 // binding values
 preparedStmt.setString(1, createdDate); 
 preparedStmt.setInt(2, Integer.parseInt(amount));  
 preparedStmt.setInt(3, Integer.parseInt(fundID)); 
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







public String deleteItem(String fundID) 
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 {return "Error while connecting to the database for deleting."; } 
 
 // create a prepared statement
 String query = "delete from fund where fundID=?"; 
 PreparedStatement preparedStmt = con.prepareStatement(query); 
 // binding values
 preparedStmt.setInt(1, Integer.parseInt(fundID)); 
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






}