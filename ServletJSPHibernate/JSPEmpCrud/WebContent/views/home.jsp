<html>
<head>
<meta charset='ISO-8859-1'>
<title>Emp CRUD Page</title>
<link rel='stylesheet' type='text/css' href='css/mytheme.css'>
</head>
<script type='text/javascript' src='js/empcrud.js'></script>
<body>
	<form id='empCrudForm' name='empCrudForm'>
		<img src='img/emp_banner1.gif' style='width: 800px; height: 150px;'>
		Welcome <%= session.getAttribute("uname") %>,<br />
		<br /> <input type='button' onclick='getEmpDetail()'
			class='button button2' style='margin-top: 1px; margin-bottom: 1px;'
			value='Find Emp' /><br /> <input type='button'
			onclick='updateEmpDetail()' class='button button2'
			style='margin-top: 1px; margin-bottom: 1px;' value='Update Emp' /><br />
		<input type='button' onclick='deleteEmpDetail()'
			class='button button2' style='margin-top: 1px; margin-bottom: 1px;'
			value='Delete Emp' /><br /> <input type='button'
			onclick='createEmpDetail()' class='button button2'
			style='margin-top: 1px; margin-bottom: 1px;' value='Create Emp' /><br />
	</form>
</body>
</html>