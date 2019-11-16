<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
  <spring:message code="welcome" />
  <b>${name}</b> <br />
  <spring:message code="now-you-can" />
  <a href="/todos"><spring:message code="manage-your-todos" /></a>
</div>
<%@ include file="common/footer.jspf"%>