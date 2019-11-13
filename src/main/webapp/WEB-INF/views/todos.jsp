<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
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
          <td><a href="/update-todo?id=${todo.id}">${todo.description}</a></td>
          <td><fmt:formatDate pattern="dd/MM/yyyy"
              value="${todo.targetDate}" /></td>
          <c:if test="${todo.done}">
            <td><input type="checkbox" checked /></td>
          </c:if>
          <c:if test="${!todo.done}">
            <td><input type="checkbox" /></td>
          </c:if>
          <td><a class="btn btn-danger"
            href="/delete-todo?id=${todo.id}">X</a></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <div>
    <a class="btn btn-success" href="/add-todo">Add</a>
  </div>
</div>
<%@ include file="common/external-scripts.jspf"%>
<%@ include file="common/footer.jspf"%>