<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href='/resources/css/mytheme.css' />
</head>
<script type='text/javascript' src='/resources/js/loginPage.js'></script>
<body>
<form id='loginPage' name ='loginPage'>
<img src='/resources/images/deptimage.jpg' style='width:800px;height:150px;'>
<table>
<tr>
<td>UserName: </td>
<td><input type='text' id='username' name='username' value=''/></td>
</tr>
<tr>
<td>Password: </td>
<td><input type='password' id='password' name='password' value=''/></td>
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