<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.locationCrud.LocationEntity" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=\"ISO-8859-1\">
<title>Delete Location Page</title>
<link rel="stylesheet" type="text/css" href="css/mytheme.css">
</head>
<script type='text/javascript' src='js/deletepage.js'></script>
<body>
<form id='deletepage' name='deletepage'>
<img src='images/locimage.png' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %>,</h1><br/>
<table>
<tr>
<td>Location Id :</td>
<td><input type='text' id='locId' name='locId' value =''></td>
</tr>
<tr>
<td><input type='button'  class='button button2' onclick ='findLoc()' value='Search Location'/></td>
<td><input type='button' class="button button2" onclick='goHome()' value='Go Home'/></td>
</tr>
</form>
</body>
</html>