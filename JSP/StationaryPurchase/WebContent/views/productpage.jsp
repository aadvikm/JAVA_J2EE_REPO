<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.StationaryPurchase.Item" %>
     <%@ page import="com.StationaryPurchase.OrderDetails" %>
      <%@ page import="com.StationaryPurchase.SubmitProduct" %>
       <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
<link rel="stylesheet" type="text/css" href="css/mytheme.css">
<script type='text/javascript' src='js/productpage.js'></script>
</head>
<body>
<form id ='productpage' name ='productpage'>
<img src='img/statShopp.png' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %></h1><br/><br/>
<% OrderDetails orderDetail = (OrderDetails) session.getAttribute("orderDetails"); %>
<% if(orderDetail != null){ %>
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
		<td align ="center"> <input type="checkbox" id="checkbox1" name ="checkbox1" <%= request.getAttribute("checkbox1") != null && request.getAttribute("checkbox1").equals("on") ? "checked" : "" %> /> </td>
		<td align ="center">Pen</td>
		<td align ="center">$30</td>
		<td align ="center"><select id="penQuantity" name="penQuantity">
        <option value="1" <%= request.getAttribute("penQuantity") != null &&  request.getAttribute("penQuantity").equals("1") ? "selected" : "" %>>One</option>
        <option value="2" <%= request.getAttribute("penQuantity") != null && request.getAttribute("penQuantity").equals("2") ? "selected" : "" %>>Two</option>
        <option value="3" <%= request.getAttribute("penQuantity") != null && request.getAttribute("penQuantity").equals("3") ? "selected" : "" %>>Three</option>
    		</select></td>
    </tr>
    <tr>		
    	<td align ="center"> <input type="checkbox" id="checkbox2" name="checkbox2" <%= request.getAttribute("checkbox1") != null && request.getAttribute("checkbox2").equals("on") ? "checked" : "" %> /> </td>
		<td align ="center">Pencil</td>
		<td align ="center">$25</td>
		<td align ="center"><select id="pencilQuantity" name="pencilQuantity">
        <option value="1" <%= request.getAttribute("pencilQuantity") != null && request.getAttribute("pencilQuantity").equals("1") ? "selected" : "" %>>One</option>
        <option value="2" <%= request.getAttribute("pencilQuantity") != null && request.getAttribute("pencilQuantity").equals("2") ? "selected" : "" %>>Two</option>
        <option value="3" <%= request.getAttribute("pencilQuantity") != null && request.getAttribute("pencilQuantity").equals("3") ? "selected" : "" %>>Three</option>
    		</select></td>
    
    </tr>
    <tr>		
    	<td align ="center"> <input type="checkbox" id="checkbox3" name="checkbox3" <%= request.getAttribute("checkbox1") != null && request.getAttribute("checkbox2").equals("on") ? "checked" : "" %>/> </td>
		<td align ="center">Eraser</td>
		<td align ="center">$20</input></td>
		<td align ="center"><select id="eraserQuantity" name="eraserQuantity">
        <option value="1" <%= request.getAttribute("eraserQuantity") != null && request.getAttribute("eraserQuantity").equals("1") ? "selected" : "" %>>One</option>
        <option value="2" <%= request.getAttribute("eraserQuantity") != null && request.getAttribute("eraserQuantity").equals("2") ? "selected" : "" %>>Two</option>
        <option value="3" <%= request.getAttribute("eraserQuantity") != null && request.getAttribute("eraserQuantity").equals("3") ? "selected" : "" %>>Three</option>
    		</select></td>
		
	</tr>
	</tbody>
</table>
<%}else{ %>
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
		<td align ="center">Pen</td>
		<td align ="center">$30</td>
		<td align ="center"><select id="penQuantity" name="penQuantity">
        <option value="1" selected>One</option>
        <option value="2">Two</option>
        <option value="3">Three</option>
    		</select></td>
    </tr>
    <tr>		
    	<td align ="center"> <input type="checkbox" id="checkbox2" name="checkbox2"  /> </td>
		<td align ="center">Pencil</td>
		<td align ="center">$25</td>
		<td align ="center"><select id="pencilQuantity" name="pencilQuantity">
        <option value="1">One</option>
        <option value="2" selected>Two</option>
        <option value="3">Three</option>
    		</select></td>
    
    </tr>
    <tr>		
    	<td align ="center"> <input type="checkbox" id="checkbox3" name="checkbox3" /> </td>
		<td align ="center">Eraser</td>
		<td align ="center">$20</input></td>
		<td align ="center"><select id="eraserQuantity" name="eraserQuantity">
        <option value="1">One</option>
        <option value="2">Two</option>
        <option value="3" selected>Three</option>
    		</select></td>
		
	</tr>
	</tbody>
</table>
<%}%> 
<br></br>
<td colspan='5' align="right"><bold><input type="button" class='button button2' value="Reset" onclick="resetForm();">&nbsp;<input type="button" class='button button2' onclick="validateAndSubmit();" value="Proceed Purchase"></bold></td>
<td colspan='3'><input type='button' onclick='logout()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Logout'/></td><br/>
</form>
</body>
</html>