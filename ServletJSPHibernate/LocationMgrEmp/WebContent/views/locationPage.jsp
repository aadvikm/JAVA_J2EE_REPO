<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@  page import="java.util.*" %>
     <%@  page import="com.LocMgrEmp.Location" %>
      <%@  page import="com.LocMgrEmp.LocationServlet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location Page</title>
<link rel="stylesheet" type="text/css" href="css/mytheme.css">
<script type='text/javascript' src='js/jquery-3.3.1.min.js'></script>
<script type='text/javascript' src='js/locationPage.js'></script>
</head>
<body>
<form id='locationPage' name='locationPage'>
<img src='image/LocDeptEmp.png' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %>,</h1><br/><br/>
<table>
<tr>
<td><bold>Locations :</bold></td>
<td><select id='locId' name='locId' style ='width:150px' value ='';>
<%
ArrayList<Location> locList = (ArrayList<Location>) request.getAttribute("locList");%>
<option value =' '></option>
<%for(Location loc : locList){%>
	
	<option value =<%=loc.getLocId() %>> <%=loc.getCity() %></option>

<% } %>
</select>
</td> 
</tr>
</table>
<td colspan='3'><input type='button' onclick='next()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Next'/></td><br/>
</form>
</body>
</html>