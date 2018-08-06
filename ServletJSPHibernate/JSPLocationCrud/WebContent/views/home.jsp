<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel='stylesheet' type='text/css' href='css/mytheme.css'>
</head>
<script type='text/javascript' src='js/homepage.js'></script>
<body>
<form id='homepage' name='homepage'>
<img src='images/locimage.png' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %></h1><br/><br/>
<input type='button' onclick='createLoc()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Create Location'/><br/>
<input type='button' onclick='updateLoc()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Update Location'/><br/>
<input type='button' onclick='deleteLoc()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Delete Location'/><br/>
<input type='button' onclick='findLoc()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Find Location'/><br/>
<input type='button' onclick='logout()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Logout'/><br/>
</form>
</body>
</html>