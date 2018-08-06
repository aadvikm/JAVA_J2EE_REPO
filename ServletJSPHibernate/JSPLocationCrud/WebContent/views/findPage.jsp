<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.locationCrud.LocationEntity" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Location Page</title>
<link rel="stylesheet" type="text/css" href="css/mytheme.css">
</head>
<script type='text/javascript' src='js/findpage.js'></script>
<body>
<form id='findpage' name='findpage'>
<img src='images/locimage.png' style='width:800px;height:150px;'>
<% LocationEntity locEntity = (LocationEntity) request.getAttribute("locationEntity"); %>
<h1>Welcome <%= session.getAttribute("username") %></h1><br/><br/>
<table>
<% if(locEntity == null){%>
<tr>
<td colspan=3><h1>Location not found for <%= request.getParameter("locId") %>.</h1></td>
</tr>	
<% }%>
<tr>
<td>Location Id: </td>
<td><input type='text' id='locId' name='locId' value='<%= request.getParameter("locId") ==null ? "" :  request.getParameter("locId")%>'/></td>
<td><input type='button' class='button button2' onClick='findLoc()' value='Search Location'/></td>
</tr>
<% if(locEntity != null){%>
<tr>
<td>Street Address : </td>
<td colspan=2><%=locEntity.getStreetAdd()%></td>
</tr>
<tr>
<td>Postal Code : </td>
<td colspan=2><%=locEntity.getPostalCode()%></td>
</tr>
<tr>
<td>City : </td>
<td colspan=2><%=locEntity.getCity()%></td>
</tr>
<tr>
<td>State Province : </td>
<td colspan=2><%=locEntity.getStateProvince()%></td>
</tr>
<tr>
<td>Country Id : </td>
<td colspan=2><%=locEntity.getCountryId()%></td>
</tr>
<% } %>
<tr>
<td colspan=3><input type='button' class="button button2" onclick='goHome()' value='Go Home'/></td>
</tr>
</table>
</form>
</body>
</html>