<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.jspDeptCrud.DepartmentEntity" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Department Page</title>
<link rel='stylesheet' type='text/css' href='css/mytheme.css'>
</head>
<script type='text/javascript' src='js/findpage.js'></script>
<body>
<form id='findpage' name='findpage'>
<img src='images/jspdept.jpg' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %></h1><br/><br/>
<% DepartmentEntity deptEntity =(DepartmentEntity)request.getAttribute("deptEntity");%>
<table>
<% if(deptEntity == null && request.getParameter("deptId") != null){%>
<tr>
<td colspan=3><h1>Department not found for <%= request.getParameter("deptId") %>.</h1></td>
</tr>	
<% }%>
<tr>
<td><bold> Department Id :</bold></td>
<td><input type='text' id='deptId' name='deptId' value ='<%= request.getParameter("deptId") == null ? "" : request.getParameter("deptId")%>'></td>
<td><input type='button'  class='button button2' onclick ='findDept()' value='Search Dept'/></td>
<td><input type='button' class="button button2" onclick='goHome()' value='Go Home'/></td>
</tr>
<%if(deptEntity != null && request.getAttribute("findDeptSuccess") != null){%>
<tr>
<td colspan=2><h1><%= request.getAttribute("findDeptSuccess") %></h1></td>
</tr>
<tr>
<td><bold>Department Id:</bold></td>
<td><%=deptEntity.getDeptId()%></td>
</tr>
<tr>
<td><bold>Department Name :</bold></td>
<td><%=deptEntity.getDeptName()%></td>
</tr>
<tr>
<td><bold>Manager  :</bold></td>
<td><%=deptEntity.getManagerName()%></td>
</tr>
<tr>
<td><bold>Location :</bold></td>
<td><%=deptEntity.getStreetAddress() %></td>
</tr>
<tr>
<td><input type='button' class="button button2" onclick='goHome()' value='Go Home'/></td>
</tr>
<%} %>
</table>
</body>
</html>