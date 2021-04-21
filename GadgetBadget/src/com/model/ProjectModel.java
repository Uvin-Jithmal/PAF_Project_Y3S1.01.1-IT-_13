package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProjectModel {

	// Database connection method
	public Connection connect() {

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gadgetbadget?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

	// Insert Projects Details
	public String insertProjects(String name, String category, String description) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			
			// create a prepared statement
			String query = " insert into projects(Pro_ID, Pro_Name, Pro_Category, Pro_Description) values ( ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, name);
			preparedStmt.setString(3, category);
			preparedStmt.setString(4, description);
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} 
		catch (Exception e) {
			output = "Error while inserting the Projects.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// Read  Projects
	public String retrieveProjects() {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading...";
			}

			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Project ID</th><th>Project Name</th><th>Project Category</th>"
					+ "<th>Project Description</th>" + "<th>Update</th><th>Delete</th></tr>";

			String query = "select * from projects";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String Pro_ID = Integer.toString(rs.getInt("Pro_ID"));
				String Pro_Name = rs.getString("Pro_Name");
				String Pro_Category = rs.getString("Pro_Category");
				String Pro_Description = rs.getString("Pro_Description");

				// Add into the html table
				output += "<tr><td>" + Pro_ID + "</td>";
				output += "<td>" + Pro_Name + "</td>";
				output += "<td>" + Pro_Category + "</td>";
				output += "<td>" + Pro_Description + "</td>";

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
						+ "<td><form method='post' action='projects.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Delete' class='btn btn-danger'>"
						+ "<input name='Pro_ID' type='hidden' value='" + Pro_ID + "'>" + "</form></td></tr>";
			}

			con.close();

			// Complete the html table
			output += "</table>";
			
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;

	}

	// Update Projects Details
	public String updateProjects(String ID, String name, String category, String description) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE projects SET Pro_Name=?,Pro_Category=?,Pro_Description=?" + "      WHERE Pro_ID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, category);
			preparedStmt.setString(3, description);
			preparedStmt.setInt(4, Integer.parseInt(ID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the Projects.";
			System.err.println(e.getMessage());
		}

		return output;

	}

	// Delete Projects
	public String deleteProjects(String Pro_ID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting...";
			}

			// create a prepared statement  
			String query = "delete from projects where Pro_ID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values 
			preparedStmt.setInt(1, Integer.parseInt(Pro_ID)); 
			
			// execute the statement 
			preparedStmt.execute();
			con.close();
			
			output = "Deleted successfully"; 
			
		} catch (Exception e) {
			output = "Error while deleting the Projects.";
			System.err.println(e.getMessage());
		}

		return output;

	}

}
