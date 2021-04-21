package model;

import java.sql.*;

public class Customer {
	
	private Connection connect()
	{
		Connection con = null;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		//Provide the correct details: DBServer/DBName, username, password
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pafcus", "root", "");
	}
	catch (Exception e)
		{e.printStackTrace();}
	return con;
	
	}
	
	public String insertcustomer(String Name,String Email,String Phone_number)
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{return "Error while connecting to the database for inserting."; }
			
			String query = " insert into customer('customerid','Name','Email','Phone_number')"+ " values(?,?,?,?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, Name);
			preparedStmt.setString(3, Email);
			preparedStmt.setString(4, Phone_number);
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
			
			}
		
			catch (Exception e)
			{
				output = "Error while inserting the Customer.";
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
			output = "<table border='1'><tr><th>Name</th><th>Email</th>" +
						"<th>Phone_number</th></tr>";
			
			String query = "select * from customer";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			
			while (rs.next()) {
				
				String customerid = Integer.toString(rs.getInt("customerid"));
				String Name = rs.getString("Name");
				String Email = rs.getString("Email");
				String Phone_number = rs.getString("Phone_number");
				
				// Add into the html table
				
				output += "<tr><td>" + Name + "</td>";
				output += "<td>" + Email + "</td>";
				output += "<td>" + Phone_number + "</td>";
				
				// buttons
				
				output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
						+ "<td><form method='post' action='items.jsp'>"
				        + "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
				        + "<input name='itemID' type='hidden' value='" + customerid+ "'>" + "</form></td></tr>";
				}
			
				con.close();
				
				// Complete the html table
				output += "</table>";
				
				}
				catch (Exception e)
				{
					output = "Error while reading the customer.";
					System.err.println(e.getMessage());
				}
				return output;
			}
	
	public String updatecustomer(String customerid, String Name, String Email, String Phone_number)
	{
		String output = "";
		
		try
		{
			Connection con = connect();
		if (con == null)
		{return "Error while connecting to the database for updating."; }
		
		// create a prepared statement
		String query = "UPDATE items SET Name=?,Email=?,Phone_number=?WHERE customerid=?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		// binding values
		preparedStmt.setString(1, Name);
		preparedStmt.setString(2, Email);
		preparedStmt.setString(3, Phone_number);
		
		// execute the statement
		preparedStmt.execute();
		con.close();
		output = "Updated successfully";
		
		}
		
		catch (Exception e)
		{
			output = "Error while updating the customer.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	public String deleteCustomer(String customerid)
	{
		String output = "";
		
		try
		{
			
			Connection con = connect();
			if (con == null)
			{return "Error while connecting to the database for deleting."; }
			
			// create a prepared statement
			String query = "delete from customer where customerid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(customerid));
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		}
		
		catch (Exception e)
		{
			output = "Error while deleting the customer.";
			System.err.println(e.getMessage());
		}
		
		return output;
		
		
		
		}

}
