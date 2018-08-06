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
<title>Review Order Page</title>
<link rel="stylesheet" type="text/css" href="css/mytheme.css">
<script type='text/javascript' src='js/orderdetailpage.js'></script>
</head>
<body>
<form id ='orderdetailpage' name ='orderdetailpage'>
<img src='img/statShopp.png' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %></h1><br/><br/>
<table border =2 style='width:50%'>
<% OrderDetail orderDetail =(OrderDetail)session.getAttribute("orderDetail");
		ArrayList<Item> itemList =(ArrayList<Item>)orderDetail.getItemList();%>
		<h3><bold>Order Date :</bold><%= orderDetail.getOrderDate() %></h3>
	<thead>
	<tr>
		<th width="15%" align="center"><bold>Product</bold></th>
		<th width="15%" align="center"><bold>Price</bold></th>
		<th width="15%" align="center"><bold>Quantity</bold></th>
		<th width="15%" align="center"><bold>Amount</bold></th>
	</tr>
	</thead>
	<tbody>
		<% for(Item item :itemList){%>
		<tr>
			<td><%= item.getName()%></td>
			<td><%=item.getUnitPrice()%></td>
			<td><%=item.getQuantity()%></td>
			<td><%=(item.getItemPrice())%></td>
		</tr>	
		
	<% }%>
	</tbody>	
	<td colspan='3' align='center'><bold>Total</bold></td><td><%= orderDetail.getOrderAmount() %></td>
</table>
<br></br>
<td colspan='5'><input type="button" class='button button2' onclick="buy();" value="Buy"></bold></td>
<td colspan='3'><input type='button' onclick='logout()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Logout'/></td><br/>
</form>
</body>
</html>