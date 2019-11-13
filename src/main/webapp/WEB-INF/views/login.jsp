<%@page import="java.util.Date"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%
	Date date = new Date();
%>
<!-- My name is ${name} and my password is ${password} -->
<div class="container">
  <div>
    Current date is
    <%=date%>
  </div>
  <p>
    <font color="red">${errorMessage}</font>
  </p>
  <form action="/login" method="POST">
    <fieldset class="form-group">
      <label>Name</label> <input name="name" type="text"
        class="form-control" required="required" />
    </fieldset>
    <fieldset class="form-group">
      <label>Password</label> <input name="password" type="password"
        class="form-control" required="required" />
    </fieldset>
    <button class="btn btn-primary" type="submit">Login</button>
  </form>
</div>
<%@ include file="common/footer.jspf"%>