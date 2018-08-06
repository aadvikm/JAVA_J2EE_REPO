<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Next Page</title>
</head>
<body>
<h1>Welcome to JSP Learning!!!</h1>
<!-- JSP Declarative Tag -->
<%! 
int sub(int i, int j){
return i-j;
}
int div(int i, int j){
return i/j;
}%>
<!-- JSP Expression Tag -->
<h1><%= request.getParameter("username") %></h1>
<!-- JSP Scriptlet -->
<%
int i = 100;
int j = 15;
out.println(i-j);
%>
</br>
<%
out.println(i/j);
%>
</br>
Result of Subtraction : <%= sub(100,20) %>
</br>
Result of Division : <%= div(100,20) %>
</br>
Context Param1 : <%= application.getInitParameter("contextParam1") %>
</br>
Config Param 1: <%= config.getInitParameter("configParam1") %>
</br>
Context Param 2 : <%= config.getInitParameter("configParam2") %>
</body>
</html>