<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login From JSP</title>
</head>
<body>
  <%
  	Date date = new Date();
  %>
  <!-- My name is ${name} and my password is ${password} -->
  <div>
    Current date is
    <%=date%></div>
  <p>
    <font color="red">${errorMessage}</font>
  </p>
  <form action="/login" method="POST">
    Name <input name="name" /> Password <input name="password"
      type="password" />
    <button type="submit">Login</button>
  </form>
</body>
</html>