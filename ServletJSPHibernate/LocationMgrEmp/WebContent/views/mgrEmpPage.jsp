<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@  page import="java.util.*" %>
     <%@  page import="com.LocMgrEmp.DepartmentMgr" %>
      <%@  page import="com.LocMgrEmp.ManagerServlet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager & Employee Page</title>
<link rel="stylesheet" type="text/css" href="css/mytheme.css">
<script type='text/javascript' src='js/jquery-3.3.1.min.js'></script>
<script type='text/javascript' src='js/mgrEmpPage.js'></script>
</head>
<body>
<form id='mgrEmpPage' name='mgrEmpPage'>
<img src='image/LocDeptEmp.png' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %>,</h1><br/><br/>
<table>
<tr>
<td><bold>Manager :</bold></td>
<td><select id='mgrId' name='mgrId' style ='width:150px' value ='' onchange ="getEmpDatails(this, '<%=request.getAttribute("locId")%>')">
<% ArrayList<DepartmentMgr> mgrList = (ArrayList<DepartmentMgr>) request.getAttribute("mgrList");%>
<option value =' '></option>
<%for(DepartmentMgr mgr : mgrList){%>
	
	<option value =<%=mgr.getMgrId() %>> <%=mgr.getMgrId() %></option>

<% } %>
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
<td colspan='3'><input type='button' onclick='prev()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Previous'/></td><br/>
<td colspan='3'><input type='button' onclick='logout()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Logout'/></td><br/>

</form>
</body>
</html>