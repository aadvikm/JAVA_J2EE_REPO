<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@  page import="java.util.*" %>
     <%@  page import="com.LocDeptEmp.Location" %>
      <%@  page import="com.LocDeptEmp.LocationServlet" %>
      <%@  page import="com.LocDeptEmp.DepartmentServlet" %>
      <%@  page import="com.LocDeptEmp.EmployeeServlet" %>
       <%@  page import="com.LocDeptEmp.Department" %>
       <%@  page import="com.LocDeptEmp.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location-Department-Employee Details Page</title>
<link rel="stylesheet" type="text/css" href="css/mytheme.css">
<script type='text/javascript' src='js/jquery-3.3.1.min.js'></script>
<script type='text/javascript' src='js/locDeptEmpPage.js'></script>
</head>
<body>
<form id='locDeptEmpPage' name='locDeptEmpPage'>
<img src='image/LocDeptEmp.png' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %>,</h1><br/><br/>
<table>
<tr>
<td><bold>Locations :</bold></td>
<td><select id='locId' name='locId' style ='width:150px' value ='' onchange='loadLocationDetail(this)';>
<%
ArrayList<Location> locList = (ArrayList<Location>) request.getAttribute("locList");%>
<option value =' '></option>
<%for(Location loc : locList){%>
	
	<option value =<%=loc.getLocId() %>> <%=loc.getCity() %></option>

<% } %>
</select>
</td> 
</tr>
<tr>
<td><bold>Departments :</bold></td>
<td><select id='deptDetail' name='deptDetail' style ='width:150px'  value ='' onchange='loadDeptDetail(this)'; >
<option value =' '></option>
</select>
</td> 
</tr>
<tr>
<td><bold>Employees :</bold></td>
<td><select id='empDetail' name='empDetail' style ='width:150px' value ='' >
<option value =' '></option>
</select>
</td> 
</tr>
</table>
<td colspan='3'><input type='button' onclick='logout()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Logout'/></td><br/>
</body>
</html>