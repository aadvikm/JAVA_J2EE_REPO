<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="com.locationCrud.LocationEntity" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Created Location Page</title>
<link rel="stylesheet" type="text/css" href="css/mytheme.css">
</head>
<script type='text/javascript' src='js/createpage.js'></script>
<body>
<form id='createpage' name='createpage'>
<img src='images/locimage.png' style='width:800px;height:150px;'>
<h1>Welcome <%= session.getAttribute("username") %></h1><br/>
<table>
<%LocationEntity locEntity =(LocationEntity) request.getAttribute("locationEntity") ;%>
<tr>
<td colspan=3><h1>You have successfully created a location <%=locEntity.getLocId() %>.!! </h1></td>
</tr>
<tr>
<td>Location Id :</td>
<td><input type='text' id='locId' name='locId' value ='<%=locEntity.getLocId() %>'></td>
</tr>
<tr>
<td>Street Address :</td>
<td><input type='text' id='streetAdd' name='streetAdd' value ='<%= locEntity.getStreetAdd()%>'></td>
</tr>
<tr>
<td>Postal Code :</td>
<td><input type='text' id='postalCode' name='postalCode' value ='<%= locEntity.getPostalCode()%>'></td>
</tr>
<tr>
<td>City :</td>
<td><input type='text' id='city' name='city' value ='<%=locEntity.getCity()%>'></td>
</tr>
<tr>
<td>State Province:</td>
<td><input type='text' id='stateProvince' name='stateProvince' value ='<%=locEntity.getStateProvince()%>'></td>
</tr>
<tr>
<td>Country Id:</td>
<td><input type='text' id='countryId' name='countryId' value ='<%=locEntity.getCountryId()%>'></td>
</tr>
<tr>
<td><input type='button'  class='button button2' onclick ='createLoc()' value='Create Location'/></td>
<td><input type='button' class="button button2" onclick='goHome()' value='Go Home'/></td>
</tr>
</table>
</form>
</body>
</html>
		