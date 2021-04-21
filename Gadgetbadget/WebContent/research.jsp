<%@page import="model.researcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
			if (request.getParameter("Rname") != null) 
			{ 
				session.setAttribute("RID", request.getParameter("RID")); 
			 session.setAttribute("Rname", request.getParameter("Rname")); 
			 session.setAttribute("Remail", request.getParameter("Remail")); 
			 session.setAttribute("Rabout", request.getParameter("Rabout")); 
			 session.setAttribute("Pname", request.getParameter("Pname"));
			 session.setAttribute("PDes", request.getParameter("PDes"));
			 session.setAttribute("Pprice", request.getParameter("Pprice"));
			 }
 
 %>







    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Young researcher</title>
</head>
<body>
	<h1>Young Researcher </h1>
	<form method="post" action="research.jsp">
	
    <input type ="hidden" name="RID" value ="0"> <br>
	Reseacher Name : <input type="text" name="Rname"> <br><br>
	Reseacher Email: <input type="email" name="Remail"><br><br>
	About Reseacher: <textarea name="Rabout"></textarea> <br><br>
	Project Name: <input type="text" name="Pname"><br><br>
	Project Description: <textarea name="PDes"></textarea> <br><br>
	Project Price: <input type="text" name="Pprice"><br>
	
	<input type="submit" name="btnSubmit" value="Submit">
	</form>
	
	
	<br>
	<table border ="1">
		<tr>
			<th>Reseacher ID</th> <th>Reseacher Name</th><th>Reseacher Email</th> <th>About Reseacher</th> <th>Project Name</th> <th>Project Description</th> <th>Project Price</th>
		</tr>
		
		<tr><td></td> <td></td> <td></td> <td></td> <td></td> <td></td><td></td>
			<td> <input type="submit" name="btnUpdate" value="Update"> </td>
			<td> <input type="submit" name="btnRemove" value="Remove"> </td>
		</tr>
		
					
			
			
							<tr>
				<td><%out.print(session.getAttribute("RID")); %></td>
				<td><%out.print(session.getAttribute("Rname")); %></td>
				<td><%out.print(session.getAttribute("Remail")); %></td>
				<td><%out.print(session.getAttribute("Rabout")); %></td>
				<td><%out.print(session.getAttribute("Pname")); %></td>
				<td><%out.print(session.getAttribute("PDes")); %></td>
				<td><%out.print(session.getAttribute("Pprice")); %></td>
				<td><input name="btnUpdate" type="button" value="Update"></td>
				<td><input name="btnRemove" type="button" value="Remove"></td>
				</tr>
			
			
	
			
			
	 </table>
	 
	 
	
	
	


</body>
</html>