<!-- Command Bean Tag -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
  rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Todo</title>
</head>
<body>
  <div class="container">
    <h1>Add a Todo</h1>
    <form:form method="post" commandName="todo">
      <fieldset class="form-group">
        <form:label path="description">Description</form:label>
        <form:input path="description" type="text" class="form-control"
          required="required" />
        <form:errors path="description" cssClass="text-error" />
      </fieldset>
      <button class="btn btn-success" type="submit">Add</button>
    </form:form>
  </div>

  <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
  <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>