<%@ page import="com.EmpCrudJSP.Employee" %>
<html>
			<head>
			<meta charset='ISO-8859-1'>
			<title>Emp Page</title>
			<link rel='stylesheet' type='text/css' href='css/mytheme.css'>
			</head>
			<script type='text/javascript' src='js/getempdetail.js'></script>
			<body>
			<form id='getEmpPageForm' name='getEmpPageForm'>
			<img src='img/emp_banner1.gif' style='width:800px;height:150px;'>
			<% Employee employee = (Employee) request.getAttribute("employee"); %>
			Welcome  <%= session.getAttribute("uname") %>,<br/><br/>
			<table>
			<% if(employee == null){ %>
			<tr>
			<td colspan=3><h1>Employee not found for <%= request.getParameter("empId") %>.</h1></td>
			</tr>
			<%} %>
			<tr>
			<td>Emp Id: </td>
			<td><input type='text' id='empId' name='empId' value='<%= request.getParameter("empId") %>'/></td>
			<td><input type='button' class='button button2' onclick='findEmp()' value='Search'/></td>
			</tr>
			<% if(employee != null){ %>
			<tr>
			<td>First Name: </td>
			<td colspan=2><%= employee.getFirstName() %></td>
			</tr>
			<tr>
			<td>Last Name: </td>
			<td colspan=2><%= employee.getLastName() %></td>
			</tr>
			<tr>
			<td>Salary: </td>
			<td colspan=2><%= employee.getSalary() %></td>
			</tr>
			<% } %>
			<tr>
			<td colspan=3><input type='button' class='button button2' onclick='goHome()' value='Go Home'/></td>
			</tr>
			</table>
			</form>
			</body>
			</html>