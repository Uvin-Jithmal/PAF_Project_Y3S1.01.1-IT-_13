package com.controller;

public class Project {
	
	private int Pro_ID;
	private String Pro_Name;
	private String Pro_Category;
	private String Description;
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Project(int pro_ID, String pro_Name, String pro_Category, String description) {
		super();
		Pro_ID = pro_ID;
		Pro_Name = pro_Name;
		Pro_Category = pro_Category;
		Description = description;
	}

	public int getPro_ID() {
		return Pro_ID;
	}

	public void setPro_ID(int pro_ID) {
		Pro_ID = pro_ID;
	}

	public String getPro_Name() {
		return Pro_Name;
	}

	public void setPro_Name(String pro_Name) {
		Pro_Name = pro_Name;
	}

	public String getPro_Category() {
		return Pro_Category;
	}

	public void setPro_Category(String pro_Category) {
		Pro_Category = pro_Category;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}



}
