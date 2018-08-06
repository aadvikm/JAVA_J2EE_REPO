<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.jspDeptCrud.DepartmentEntity" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Department Page</title>
<<link rel='stylesheet' type='text/css' href='css/mytheme.css'>
</head>
<script type='text/javascript' src='js/deletepage.js'></script>
<body>
<form id='deletepage' name='deletepage'>
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
</tr>
<% if(deptEntity != null && request.getAttribute("successMsg") == null){%>
<tr>
<td><bold>Department Name :</bold></td>
<td><input type='text' id='deptName' name='deptName' value ='<%=deptEntity.getDeptName() %>'></td>
</tr>
<tr>
<td><bold>Manager Id :</bold></td>
<td><input type='text' id='managerId' name='managerId' value ='<%=deptEntity.getManagerId() %>'></td>
</tr>
<tr>
<td><bold>Location Id:</bold></td>
<td><input type='text' id='locationId' name='locationId' value ='<%=deptEntity.getLocationId() %>'></td>
</tr>
<%}
else if(deptEntity != null && request.getAttribute("successMsg") != null){%>
<tr>
<td><bold>Department Id:</bold></td>
<td><%=deptEntity.getDeptId()%></td>
</tr>
<tr>
<td><bold>Department Name :</bold></td>
<td><%=deptEntity.getDeptName()%></td>
</tr>
<tr>
<td><bold>Manager Id :</bold></td>
<td><%=deptEntity.getManagerId()%></td>
</tr>
<tr>
<td><bold>Location Id:</bold></td>
<td><%=deptEntity.getLocationId()%></td>
</tr>
<tr>
<td colspan=3><h1><%= request.getAttribute("successMsg") %></h1></td>
</tr>
<%}%>
<% if(deptEntity != null && request.getAttribute("successMsg") == null){%>
<td colspan=2><input type='button' class="button button2" onclick='deleteDept()' value='Delete Dept'/></td>
<td><input type='button' class="button button2" onclick='goHome()' value='Go Home'/></td>
<%}else{ %>
<td colspan=3><input type='button' class="button button2" onclick='goHome()' value='Go Home'/></td>
<%} %>
</tr>
</table>

</body>
</html>