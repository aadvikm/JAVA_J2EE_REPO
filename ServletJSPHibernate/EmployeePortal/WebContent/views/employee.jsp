<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.EmployeePortal.EmployeeServlet" %>
     <%@ page import="com.EmployeePortal.Employee" %>
     <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details Page</title>
<link rel='stylesheet' type='text/css' href='css/mytheme.css'>
<script type='text/javascript' src='js/jquery-3.3.1.min.js'></script>
<script type='text/javascript' src='js/employeepage.js'></script>
</head>
<body>
<form id='employeepage' name='employeepage'>
<img src='image/empbanner.png' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %>,</h1><br/><br/>
<h3>Employee List : </h3><br/><br/>
<table border =2 style='width:50%'>
	<thead>
	<tr>
		<th width="15%" align="center"><bold>Select</bold></th>
		<th width="15%" align="center"><bold>Employee Name</bold></th>
		<th width="15%" align="center"><bold>Employee Mgr Name</bold></th>
		<th width="15%" align="center"><bold>Location</bold></th>
		<th width="15%" align="center"><bold>Salary</bold></th>
	</tr>
	</thead>
	<%ArrayList<Employee> empList =(ArrayList<Employee>)request.getAttribute("employeeList"); %>
	<tbody  id="empTBody">
		<% for(Employee emp :empList) {%>
	 	<tr>
		<td align ="center"> <input type="checkbox" id="checkbox_<%= emp.getId() %>" name ="checkbox" /> </td>
		<td align ="center"> <%= emp.getName() %></td>
		<td align ="center"><%= emp.getMgrName() %></td>
		<td align ="center"><%= emp.getLocation() %></td>
		<td align ="left">$ <%= emp.getSalary() %></td>
		</tr>
		<% }%>
	<tr nowrap><td colspan = 5 align="right"><input type="button" style="width:80px" onclick="loadEmployeeUsingJqueryAndJson(<%=request.getAttribute("p_offset") %>,<%=request.getAttribute("p_limit") %>)" value='Prev'/><%= request.getAttribute("offset") %>-<%= request.getAttribute("limit") %><input type="button" style='width:80px' onclick="loadEmployeeUsingJqueryAndJson(<%=request.getAttribute("n_offset") %>,<%=request.getAttribute("n_limit") %>)" value='Next'/></td></tr>	
	</tbody>
	
</table>
<br/><br/>
<td colspan='5' align="right"><bold><input type="button" class='button button2' value="Reset" onclick="resetForm();">&nbsp;<input type="button" class='button button2' onclick="validateAndSubmit();" value="Proceed"></bold></td>
<td colspan='3'><input type='button' onclick='logout()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Logout'/></td><br/>
&nbsp;<input style="width:180px" type='button' onclick='showEmpDetail()' class='button button2' value='Show Emp Detail'/>
&nbsp;<input style="width:180px" type='button' onclick='showEmpDetailUsingJquery()' class='button button2' value='Show Emp Detail Using JQuery'/>

<td colspan=2>
<div id="empDetail" ></div>
</td>
<td colspan=2>
<div id="empDetailJquery" ></div>
</td>
</form>
</body>
</html>