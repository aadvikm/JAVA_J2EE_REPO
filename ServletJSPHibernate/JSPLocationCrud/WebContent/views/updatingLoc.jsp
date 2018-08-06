<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.locationCrud.LocationEntity" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Updating Location Page</title>
<link rel="stylesheet" type="text/css" href="css/mytheme.css">
</head>
<script type='text/javascript' src='js/updatepage.js'></script>
<body>
<form id='updatepage' name='updatepage'>
<img src='images/locimage.png' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %></h1><br/>
<%LocationEntity locEntity =(LocationEntity) request.getAttribute("locationEntity"); %>
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
<td><input type='text' id='streetAdd' name='streetAdd' value='<%=locEntity.getStreetAdd() %>'/></td>
</tr>
<tr>
<td>Postal Code : </td>
<td><input type='text' id='postalCode' name='postalCode' value='<%=locEntity.getPostalCode()%>'/></td>
</tr>
<tr>
<td>City : </td>
<td><input type='text' id='city' name='city' value='<%= locEntity.getCity() %>'/></td>
</tr>
<tr>
<td>State Province : </td>
<td><input type='text' id='stateProvince' name='stateProvince' value='<%=locEntity.getStateProvince()%>'/></td>
</tr>
<tr>
<td>Country Id : </td>
<td><input type='text' id='countryId' name='countryId' value='<%=locEntity.getCountryId()%>'/></td>
</tr>
<% } %>
<tr>
<td colspan=3><input type='button' class="button button2" onclick='updateLoc()' value='Update Location'/></td>
<td colspan=3><input type='button' class="button button2" onclick='goHome()' value='Go Home'/></td>
</tr>
</table>
</form>
</body>
</html>