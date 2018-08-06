<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.jspDeptCrud.DepartmentEntity" %>
     <%@ page import="com.jspDeptCrud.Manager" %>
     <%@ page import="com.jspDeptCrud.Location" %>
     <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Department</title>
<link rel='stylesheet' type='text/css' href='css/mytheme.css'>
</head>
<script type='text/javascript' src='js/createpage.js'></script>
<body>
<form id='createpage' name='createpage'>
<img src='images/jspdept.jpg' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %></h1><br/><br/>
<% DepartmentEntity deptEntity =(DepartmentEntity)request.getAttribute("deptEntity");%>
<table>
<%if(deptEntity ==null) {%>
<tr>
<td><bold>Department Name :</bold></td>
<td><input type='text' id='deptName' name='deptName' value ='<%= request.getParameter("deptName") == null ? "" : request.getParameter("deptName")%>'></td>
</tr>
<tr>
<td><bold>Location Id:</bold></td>
<!--<td><input type='text' id='locationId' name='locationId' value =''></td> -->
<td><select id='locationId' name='locationId' value ='' onchange='getLocationManagers(this);' >
<%
ArrayList<Location> locList = (ArrayList<Location>) request.getAttribute("locationList");
for(Location location : locList){
%>
<option <%= request.getParameter("locationId") != null && location.getLocationId().longValue() == Long.parseLong((request.getParameter("locationId"))) ? "selected" : "" %> value="<%= location.getLocationId()%>"><%= location.getStreetAddress()%></option>
<%} %>
</select>
</td> 
</tr>
<tr>
<td><bold>Manager Id :</bold></td>
<!-- <td><input type='text' id='managerId' name='managerId' value =''></td>  -->
<td><select id='managerId' name='managerId' value ='' style="width:285px">
<%
ArrayList<Manager> mgrList = (ArrayList<Manager>) request.getAttribute("managerList");
for(Manager manager : mgrList){
%>
<option value="<%= manager.getManagerId()%>"><%= manager.getManagerName()%></option>
<%} %>
</select>
</td> 
</tr>

<%}
else if(deptEntity != null && request.getAttribute("createDeptSuccess") != null){%>
<tr>
<td><bold>Department Id:</bold></td>
<td><%=deptEntity.getDeptId()%></td>
</tr>
<tr>
<td><bold>Department Name :</bold></td>
<td><%=deptEntity.getDeptName()%></td>
</tr>
<tr>
<td><bold>Location Id:</bold></td>
<td><%=deptEntity.getLocationId()%></td>
</tr>
<tr>
<td><bold>Manager Id :</bold></td>
<td><%=deptEntity.getManagerId()%></td>
</tr>

<tr>
<td colspan=2><h1><%= request.getAttribute("createDeptSuccess") %></h1></td>
</tr>
<tr>
<td><input type='button' class="button button2" onclick='goHome()' value='Go Home'/></td>
</tr>
<%} %>
<%if(deptEntity ==null) {%>
<tr>
<td><input type='button'  class='button button2' onclick ='createDept()' value='Create Dept'/></td>
<td><input type='button' class="button button2" onclick='goHome()' value='Go Home'/></td>
</tr>
<%} %>
</table>
</body>
</html>