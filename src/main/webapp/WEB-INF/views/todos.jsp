<!-- Import JSP Standard Tag Library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Maven Dependencies -> boostrap-3.3.6.jar -> META-INF -> resources -> webjars -> bootstrap -> etc... -->
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
  rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todos</title>
</head>
<body>
  <div class="container">
    <h1>Todos</h1>
    <table class="table table-striped">
      <caption>Your Todos are</caption>
      <thead>
        <tr>
          <th>Description</th>
          <th>Target Date</th>
          <th>Is Complete?</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${todos}" var="todo">
          <tr>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <c:if test="${todo.done}">
              <td><input type="checkbox" checked /></td>
            </c:if>
            <c:if test="${!todo.done}">
              <td><input type="checkbox" /></td>
            </c:if>
            <td><a class="btn btn-danger" href="/delete-todo?id=${todo.id}">X</a></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <div>
      <a class="btn btn-success" href="/add-todo">Add</a>
    </div>
  </div>

  <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
  <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>