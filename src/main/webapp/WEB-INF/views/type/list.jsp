<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			<spring:message code="title.types"></spring:message>
		</title>
		<link rel="stylesheet" href="<c:url value="/styles/reset.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/style.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/tipsy.css"></c:url>" type="text/css" />
		<script type="text/javascript" src="<c:url value="/javascripts/jquery-2.1.1.min.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/jquery.tipsy.js"></c:url>"></script>
	</head>
	<body>
		<%@ include file="../includes/header.jsp" %>
		<div class="content-header">
			<div class="container">
				<h1>
					<spring:message code="title.types"></spring:message>
				</h1>
			</div>
		</div>
		<div id="content">
			<div class="container">
				<div class="results-table">
					<table>
						<thead>
							<tr>
								<td>
									<spring:message code="types.table.name"></spring:message>
								</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${types}" var="type">
								<tr>
									<td>
										<a href="<c:url value="/type/edit/${type.id}"></c:url>">${type.name}</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<%@ include file="../includes/footer.jsp" %>
	</body>
</html>