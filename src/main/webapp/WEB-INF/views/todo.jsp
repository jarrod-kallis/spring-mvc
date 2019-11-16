<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
  <c:set var="todo" value="${todo}" />
  <c:if test="${todo.id == 0}">
    <h1><spring:message code="add-a-todo"/></h1>
  </c:if>
  <c:if test="${todo.id > 0}">
    <h1><spring:message code="update-a-todo"/></h1>
  </c:if>
  <form:form method="post" commandName="todo">
    <fieldset class="form-group">
      <form:label path="description"><spring:message code="description"/></form:label>
      <form:input path="description" type="text" class="form-control"
        required="required" />
      <form:errors path="description" cssClass="text-error" />
    </fieldset>
    <fieldset class="form-group">
      <form:label path="targetDate"><spring:message code="target-date"/></form:label>
      <form:input id="targetDate" path="targetDate" type="text"
        class="form-control" required="required" />
      <form:errors path="targetDate" cssClass="text-error" />
    </fieldset>
    <button class="btn btn-success" type="submit">
      <c:if test="${todo.id == 0}">Add</c:if>
      <c:if test="${todo.id > 0}">Update</c:if>
    </button>
  </form:form>
</div>
<%@ include file="common/external-scripts.jspf"%>
<script>
	$('#targetDate').datepicker({
		format : 'dd/mm/yyyy'
	});
</script>
<%@ include file="common/footer.jspf"%>