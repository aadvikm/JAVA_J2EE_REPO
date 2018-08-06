<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department Login Page</title>
<link rel="stylesheet" type="text/css" href="css/mytheme.css">
<script type ='text/javascript'>
alert('Welcome to Department Portal..!!');
</script>
<script type ='text/javascript' src='js/loginpage.js'></script>
</head>
<body>
<form id='loginpage' name='loginpage'>
<img src='image/deptimage.jpg' style='width:800px;height:150px;'>
<table>
<td colspan=2>
<%= request.getAttribute("loginFailMessage") == null ? "" :  request.getAttribute("loginFailMessage")%>
</td>
<tr>
<td>UserName: </td>
<td><input type='text' id='username' name='username' value='<%= request.getParameter("username") == null ? "" :  request.getParameter("username")%>'/></td>
</tr>
<tr>
<td>Password: </td>
<td><input type='password' id='password' name='password' value='<%= request.getParameter("password") == null ? "" :  request.getParameter("password")%>'/></td>
</tr>
<tr>
<td colspan=2>
<input type='button' onclick='login()' class='button button2' value='Login'/>&nbsp;<input type='button' onclick='reset()' class='button button2' value='Reset'/>
</td>
</tr>
</table>
</form>
</body>
</html>