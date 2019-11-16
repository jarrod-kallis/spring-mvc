<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
  <h1>Todos</h1>
  <table class="table table-striped">
    <caption><spring:message code="your-todos-are"/></caption>
    <thead>
      <tr>
        <th><spring:message code="description"/></th>
        <th><spring:message code="target-date"/></th>
        <th><spring:message code="is-complete"/></th>
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
            <td><input type="checkbox" checked disabled="disabled"/></td>
          </c:if>
          <c:if test="${!todo.done}">
            <td><input type="checkbox" disabled="disabled"/></td>
          </c:if>
          <td><a class="btn btn-danger"
            href="/delete-todo?id=${todo.id}">X</a></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <div>
    <a class="btn btn-success" href="/add-todo"><spring:message code="add"/></a>
  </div>
</div>
<%@ include file="common/external-scripts.jspf"%>
<%@ include file="common/footer.jspf"%>