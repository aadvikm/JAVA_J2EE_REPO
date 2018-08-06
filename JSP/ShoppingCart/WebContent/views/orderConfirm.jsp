<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.ShoppingCart.Item" %>
     <%@ page import="com.ShoppingCart.OrderDetail" %>
      <%@ page import="com.ShoppingCart.SubmitProduct" %>
       <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Confirm Page</title>
<link rel="stylesheet" type="text/css" href="css/mytheme.css">
<script type='text/javascript' src='js/orderconfirm.js'></script>
</head>
<body>
<form id ='orderconfirm' name ='orderconfirm'>
<img src='img/statShopp.png' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %>,</h1><br/><br/>
<% OrderDetail orderDetail =(OrderDetail)session.getAttribute("orderDetail");%>
<%!public Date addDays(Date date, int days) {
	GregorianCalendar cal = new GregorianCalendar();
	cal.setTime(date);
	cal.add(Calendar.DATE, days);
			
	return cal.getTime();
} %>
<table border =2 style='width:50%'>
	<h3>Thank you for your order..!!</h3>
	<h3>The Order Confirmation Number is 1004500..!!</h3>
	
	<h3>Your order is placed for $ <%=orderDetail.getOrderAmount() %> and will be shipped soon..!!</h3>
	<h3>And the product delivery date is <%=addDays(orderDetail.getOrderDate(), 3) %> .!!</h3>
</table>
<input type='button' onclick='logout()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Logout'/><br/>
</form>
</body>
</html>