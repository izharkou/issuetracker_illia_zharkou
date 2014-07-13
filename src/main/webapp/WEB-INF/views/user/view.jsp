<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			<spring:message code="title.userView"></spring:message>
		</title>
		<link rel="stylesheet" href="<c:url value="/styles/reset.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/style.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/tipsy.css"></c:url>" type="text/css" />
		<script type="text/javascript" src="<c:url value="/javascripts/jquery-2.1.1.min.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/jquery.tipsy.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/pages/all.js"></c:url>"></script>
	</head>
	<body>
		<%@ include file="../includes/header.jsp" %>
		<div class="content-header">
			<div class="container">
				<h1>
					<spring:message code="title.userView"></spring:message>
				</h1>
			</div>
		</div>
		<div id="content">
			<div class="container">
				<table class="user-view">
					<tr>
						<td>
							<spring:message code="userAdd.input.firstName"></spring:message>
						</td>
						<td>${user.firstName}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="userAdd.input.lastName"></spring:message>
						</td>
						<td>${user.lastName}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="userAdd.input.email"></spring:message>
						</td>
						<td>${user.email}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="userAdd.input.role"></spring:message>
						</td>
						<td>
							<c:choose>
								<c:when test="${user.role == 'ROLE_USER'}">
									<spring:message code="userAdd.input.role.user"></spring:message>
								</c:when>
								<c:otherwise>
									<spring:message code="userAdd.input.role.admin"></spring:message>
								</c:otherwise>
							</c:choose>
						<td>
					</tr>
				</table>
				<div class="user-edit">
					<a class="button" href="<c:url value="/user/edit/${user.id}"></c:url>">
						<spring:message code="header.links.editProfile"></spring:message>
					</a>
					<a class="button" href="<c:url value="/user/edit/${user.id}/password"></c:url>">
						<spring:message code="header.links.changePasswd"></spring:message>
					</a>
				</div>
			</div>
		</div>
		<%@ include file="../includes/footer.jsp" %>
	</body>
</html>