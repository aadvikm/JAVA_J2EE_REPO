<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Emp CRUD Page</title>
<link rel='stylesheet' type='text/css' href='css/mytheme.css'>
</head>
<script type='text/javascript' src='js/empcrud.js'></script>
<body>
<form id='empCrudForm' name='empCrudForm'>
		<img src='img/emp_banner1.gif' style='width: 800px; height: 150px;'>
		Welcome <%= session.getAttribute("uname") %>,<br />
		<br /> 
		<input type='button' onclick='getEmpDetail()'
			class='button button2' style='margin-top: 1px; margin-bottom: 1px;'
			value='Find Emp' /><br />
		<input type='button'
			onclick='updateEmpDetail()' class='button button2'
			style='margin-top: 1px; margin-bottom: 1px;' value='Update Emp' /><br />
		<input type='button' onclick='deleteEmpDetail()'
			class='button button2' style='margin-top: 1px; margin-bottom: 1px;'
			value='Delete Emp' /><br /> 
		<input type='button'
			onclick='createEmpDetail()' class='button button2'
			style='margin-top: 1px; margin-bottom: 1px;' value='Create Emp' /><br />
</form>
</body>
</html>