<%@page import="model.researcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	

if (request.getParameter("txtRName") != null) {
	researcher ReObj = new researcher();
	String stsMsg = "";
	//Insert--------------------------
	if (request.getParameter("hidItemIDSave") == "") {
		stsMsg = ReObj.insertResearcher(request.getParameter("txtRName"),request.getParameter("txtEmail"),request.getParameter("txtAbout"),request.getParameter("txtPName"),request.getParameter("txtPDescription"),request.getParameter("txtPPrice"));
	} else//Update----------------------
	{
		stsMsg = ReObj.updateResearcher(request.getParameter("hidResearcherIDSave"),request.getParameter("txtRName"),request.getParameter("txtEmail"),request.getParameter("txtAbout"),request.getParameter("txtPName"),request.getParameter("txtPDescription"),request.getParameter("txtPPrice"));
	}
	session.setAttribute("statusMsg", stsMsg);
}
//Delete-----------------------------
if (request.getParameter("hidItemIDDelete") != null) {
	researcher ReObj = new researcher();
	String stsMsg = ReObj.deleteResearcher(request.getParameter("hidItemIDDelete"));
	session.setAttribute("statusMsg", stsMsg);
}
%>









<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Young researcher</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/researcher.js"></script>
</head>
<body>
	


	<div class="container">
		<div class="row">
			<div class="col-8">
				<h1 class="m-3">Young Researcher details</h1>
				<form id="formResearcher" name ="formResearcher" method="post" action="research.jsp">

					<!-- NAME -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Researcher Name: </span>
						</div>
						<input type="text" id="txtRName" name="txtRName">
					</div>

					<!-- Email -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Researcher Email: </span>
						</div>
						<input type="email" id="txtEmail" name="txtEmail">
					</div>

					<!-- About -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">About Researcher: </span>
						</div>
						<input type="text" id="txtAbout" name="txtAbout">
					</div>

					<!-- Proj NAME -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Project Name: </span>
						</div>
						<input type="text" id="txtPName" name="txtPName">
					</div>

					<!-- Proj description -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Project Description: </span>
						</div>
						<input type="text" id="txtPDescription" name="txtPDescription">
					</div>

					<!-- Proj Price -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Project Price: </span>
						</div>
						<input type="text" id="txtPPrice" name="txtPPrice">
					</div>

					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					<input type="button" id="btnSave" value="Save"
						class="btn btn-primary">
						
					<input type="hidden" id="hidResearcherIDSave" name="hidResearcherIDSave" value="">
						
						
					</form>
			</div>
		</div>

		<br>
		<div class="row">
			<div class="col-12" id="colStudents"></div>
		</div>
	</div>



	




























</body>
</html>