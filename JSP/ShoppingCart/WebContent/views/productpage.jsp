<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
<link rel="stylesheet" type="text/css" href="css/mytheme.css">
<script type='text/javascript' src='js/productpage.js'></script>
</head>
<body>
<form id='productpage' name='productpage'>
<img src='img/statShopp.png' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %>,</h1><br/><br/>
<table border =2 style='width:50%'>
	<thead>
	<tr>
		<th width="15%" align="center"><bold>Select</bold></th>
		<th width="15%" align="center"><bold>Product</bold></th>
		<th width="15%" align="center"><bold>Price</bold></th>
		<th width="15%" align="center"><bold>Quantity</bold></th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td align ="center"> <input type="checkbox" id="checkbox1" name ="checkbox1" /> </td>
		<td align ="center">OilPaints</td>
		<td align ="center">$30</td>
		<td align ="center"><select id="oilPaintsQuantity" name="oilPaintsQuantity">
        <option value="1" selected>One</option>
        <option value="2">Two</option>
        <option value="3">Three</option>
    		</select></td>
    </tr>
    <tr>		
    	<td align ="center"> <input type="checkbox" id="checkbox2" name="checkbox2"  /> </td>
		<td align ="center">ColorPencil</td>
		<td align ="center">$25</td>
		<td align ="center"><select id="colorPencilQuantity" name="colorPencilQuantity">
        <option value="1">One</option>
        <option value="2" selected>Two</option>
        <option value="3">Three</option>
    		</select></td>
    
    </tr>
    <tr>		
    	<td align ="center"> <input type="checkbox" id="checkbox3" name="checkbox3" /> </td>
		<td align ="center">Crayons</td>
		<td align ="center">$20</input></td>
		<td align ="center"><select id="crayonsQuantity" name="crayonsQuantity">
        <option value="1">One</option>
        <option value="2">Two</option>
        <option value="3" selected>Three</option>
    		</select></td>
		
	</tr>
	</tbody>
</table>
<br></br>
<td colspan='5' align="right"><bold><input type="button" class='button button2' value="Reset" onclick="resetForm();">&nbsp;<input type="button" class='button button2' onclick="validateAndSubmit();" value="Proceed Purchase"></bold></td>
<td colspan='3'><input type='button' onclick='logout()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Logout'/></td><br/>
</form>
</body>
</html>