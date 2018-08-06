<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.DeptPortal.DeptServlet" %>
     <%@ page import="com.DeptPortal.Department" %>
     <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department Details Page</title>
<link rel='stylesheet' type='text/css' href='css/mytheme.css'>
<script type='text/javascript' src='js/deptpage.js'></script>
</head>
<body>
<form id='deptpage' name='deptpage'>
<img src='image/deptimage.jpg' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %>,</h1><br/><br/>
<h3>Department Details : </h3><br/><br/>
<table border =2 style='width:50%'>
	<thead>
	<tr>
		<th width="15%" align="center"><bold>Select</bold></th>
		<th width="15%" align="center"><bold>Department Id</bold></th>
		<th width="15%" align="center"><bold>Department Name</bold></th>
		<th width="15%" align="center"><bold>Location Id</bold></th>
		<th width="15%" align="center"><bold>Manager Id</bold></th>
	</tr>
	</thead>
	<%ArrayList<Department> deptList =(ArrayList<Department>)request.getAttribute("deptList"); %>
	<tbody id="deptTBody">
		<% for(Department dept :deptList) {%>
	 	<tr>
		<td align ="center"> <input type="checkbox" id="checkbox_<%= dept.getDeptId() %>" name ="checkbox" /> </td>
		<td align ="center"> <%= dept.getDeptId() %></td>
		<td align ="center"><%= dept.getDeptName() %></td>
		<td align ="center"><%= dept.getLocationId() %></td>
		<td align ="left"> <%= dept.getManagerId() %></td>
		</tr>
		<% }%>
	<tr nowrap><td colspan = 5 align="right"><input type="button" style="width:80px" onclick="loadDepts(<%=request.getAttribute("p_offset") %>,<%=request.getAttribute("p_limit") %>)" value='Prev'><%= request.getAttribute("offset") %>-<%= request.getAttribute("limit") %><input type="button" style='width:80px' onclick="loadDepts(<%=request.getAttribute("n_offset") %>,<%=request.getAttribute("n_limit") %>)" value='Next'/></td></tr>	
	</tbody>
</table>
<br/><br/>
<td colspan='5' align="right"><bold><input type="button" class='button button2' value="Reset" onclick="resetForm();">
&nbsp;<input type="button" class='button button2' onclick="validateAndSubmit();" value="Proceed"></bold></td>
<td colspan='3'><input type='button' onclick='logout()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Logout'/></td><br/></form>
</body>
</html>