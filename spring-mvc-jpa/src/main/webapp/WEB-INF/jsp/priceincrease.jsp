<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title><fmt:message key="title" /></title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
<h1><fmt:message key="priceincrease.heading" /></h1>
<form:form method="post" commandName="priceIncrease">
	<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
		cellpadding="5">
		<tr>
			<td align="right" width="20%">Zam orani (%):</td>
			<td width="20%"><form:input path="percentage" /></td>
			<td width="60%"><form:errors path="percentage" cssClass="error" />
			</td>
		</tr>
	</table>
	<br>
	<input type="submit" align="center" value="Zam Yap">
</form:form>
<a href="<c:url value="hello.htm"/>">Geri</a>
</body>
</html>