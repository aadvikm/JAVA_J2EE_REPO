<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="css/mytheme.css">
</head>
<script type='text/javascript' src='js/login.js'></script>
<body>
<form id='loginForm' name='loginForm'>
<img src='img/emp_banner1.gif' style='width:800px;height:150px;'>
<table>
<tr>
<td colspan=2>
<%= request.getAttribute("errorMessage") == null ? "" :  request.getAttribute("errorMessage")%>
</td>
</tr>
<tr>
<td>UserName: </td>
<td><input type='text' id='uname' name='uname' value='<%= request.getParameter("uname") == null ? "" :  request.getParameter("uname")%>'/></td>
</tr>
<tr>
<td>Password: </td>
<td><input type='password' id='pwd' name='pwd' value='<%= request.getParameter("pwd") == null ? "" :  request.getParameter("pwd")%>'/></td>
</tr>
<tr>
<td colspan=2>
<input type='button' onclick='login()' class='button button2' value='Login'/>&nbsp;<input type='button' onclick='clearForm()' class='button button2' value='Clear'/>
</td>
</tr>
</table>
</form>
</body>
</html>