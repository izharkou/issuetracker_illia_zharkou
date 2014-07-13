<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			<spring:message code="title.userAdd"></spring:message>
		</title>
		<link rel="stylesheet" href="<c:url value="/styles/reset.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/style.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/tipsy.css"></c:url>" type="text/css" />
		<script type="text/javascript" src="<c:url value="/javascripts/jquery-2.1.1.min.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/jquery.tipsy.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/pages/user/add.js"></c:url>"></script>
	</head>
	<body>
		<%@ include file="../includes/header.jsp" %>
		<div class="content-header">
			<div class="container">
				<h1>
					<spring:message code="title.userAdd"></spring:message>
				</h1>
			</div>
		</div>
		<div id="content">
			<div class="container">
				<div class="message bottom successful hidden">
					<spring:message code="userAdd.message.successful"></spring:message>
				</div>
				<div class="message bottom error hidden">
					<spring:message code="userAdd.message.error"></spring:message>
				</div>
				<div class="edit-form" id="userAdd">
					<label for="firstName">
						<spring:message code="userAdd.input.firstName"></spring:message>
						<span>*</span>
					</label>
					<spring:message code="userAdd.error.firstName" var="errorFirstName"></spring:message>
					<input id="firstName" class="text" type="text" name="firstName" original-title="${errorFirstName}" />
					<label for="lastName">
						<spring:message code="userAdd.input.lastName"></spring:message>
						<span>*</span>
					</label>
					<spring:message code="userAdd.error.firstName" var="errorLastName"></spring:message>
					<input id="lastName" class="text" type="text" name="lastName" original-title="${errorLastName}" />
					<label for="email">
						<spring:message code="userAdd.input.email"></spring:message>
						<span>*</span>
					</label>
					<spring:message code="userAdd.error.email" var="errorEmail"></spring:message>
					<input id="email" class="text" type="text" name="email" original-title="${errorEmail}" />
					<label for="role">
						<spring:message code="userAdd.input.role"></spring:message>
						<span>*</span>
					</label>
					<select name="role">
						<option value="ROLE_USER" selected="selected">
							<spring:message code="userAdd.input.role.user"></spring:message>
						</option>
						<option value="ROLE_ADMIN">
							<spring:message code="userAdd.input.role.admin"></spring:message>
						</option>
					</select>
					<label for="password">
						<spring:message code="userAdd.input.password"></spring:message>
						<span>*</span>
					</label>
					<spring:message code="userAdd.error.password" var="errorPassword"></spring:message>
					<input id="password" class="text" type="password" name="password" original-title="${errorPassword}" />
					<label for="password_repeat">
						<spring:message code="userAdd.input.repeatPassword"></spring:message>
						<span>*</span>
					</label>
					<spring:message code="userAdd.error.repeatPassword" var="errorRepeatPassword"></spring:message>
					<input id="password_repeat" class="text" type="password" name="password_repeat" original-title="${errorRepeatPassword}" />
					<div class="submit">
						<span class="button">
							<spring:message code="userAdd.submit"></spring:message>
						</span>
						<div class="loading hidden"></div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="../includes/footer.jsp" %>
	</body>
</html>