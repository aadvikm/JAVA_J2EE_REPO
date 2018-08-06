<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.StationaryPurchase.OrderDetails" %>
    <%@ page import="com.StationaryPurchase.Item" %>
    <%@ page import="com.StationaryPurchase.SubmitProduct" %>
       <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Confirm Page</title>
<link rel="stylesheet" type="text/css" href="css/mytheme.css">
<script type='text/javascript' src='js/orderConfirm.js'></script>
</head>
<body>
<form id ='orderConfirm' name ='orderConfirm'>
<img src='img/statShopp.png' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %>,</h1><br/><br/>
<% OrderDetails orderDetail =(OrderDetails)session.getAttribute("orderDetails");%>
<table border =2 style='width:50%'>
	<h3>Thank you for your order..!!</h3>
	<h3>Your Order Confirmation Number is 1004500..!!</h3>
	
	<h3>And your order is placed for $ <%=orderDetail.getOrderAmount() %> and will be shipped soon..!!</h3>
	
</table>
<input type='button' onclick='logout()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Logout'/><br/>
</form>
</body>
</html>