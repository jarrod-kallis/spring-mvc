<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
  <h2>A todo exception has occurred</h2>
  <p style="color: red; font-weight: bold">${errorMessage}</p>
  <c:forEach items="${stackTraceLines}" var="stackTrace"
    varStatus="loop">
    <c:if test="${loop.index < 20}">
      <p style="margin: 0">${stackTrace}</p>
    </c:if>
  </c:forEach>
</div>
<%@ include file="common/footer.jspf"%>