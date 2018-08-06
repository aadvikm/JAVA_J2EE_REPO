<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@  page import="java.util.*" %>
     <%@  page import="com.EmpDept.Employee" %>
      <%@  page import="com.EmpDept.Department" %>
       <%@  page import="com.EmpDept.DeptDetailServlet" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Department Detail Page</title>
<link rel="stylesheet" type="text/css" href="css/mytheme.css">
<script type='text/javascript' src='js/jquery-3.3.1.min.js'></script>
<script type='text/javascript' src='js/empDeptPage.js'></script>
</head>
<body>
<form id='empDeptPage' name='empDeptPage'>
<img src='image/depimage.png' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %>,</h1><br/><br/>
<table>
<tr>
<td><bold>Department Id:</bold></td>
<td><select id='deptId' name='deptId' value ='' onchange='getDepartmentDetail(this)';>
<%
ArrayList<Department> deptList = (ArrayList<Department>) request.getAttribute("DeptList");%>
<option value =' '></option>
<%for(Department dept : deptList){%>
	
	<option value =<%=dept.getDeptId() %>> <%=dept.getDeptName() %></option>

<% } %>
</select>
</td> 
</tr>
<tr>
<td><bold>Employee Details:</bold></td>
<td><select id='empDetail' name='empDetail' value ='' ></select>
</td> 
</tr>
</table>
<td colspan='3'><input type='button' onclick='logout()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Logout'/></td><br/>
</body>
</html>