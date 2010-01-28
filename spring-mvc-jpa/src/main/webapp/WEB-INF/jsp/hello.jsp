<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
<h1><fmt:message key="heading" /></h1>
<p><fmt:message key="greeting" /> <c:out value="${model.now}" /></p>
<h3>Urunler</h3>
<ul>
<c:forEach items="${model.products}" var="prod">
	<li>
	<c:out value="${prod.description}" />
	<i>: $<c:out value="${prod.price}" /></i>
	</li>
	
</c:forEach>
</ul>
<br>
<a href="<c:url value="priceincrease.htm"/>">Zam yap..</a>
<br>
</body>
</html>