<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			<spring:message code="title.passwdEditId"></spring:message>
		</title>
		<link rel="stylesheet" href="<c:url value="/styles/reset.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/style.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/tipsy.css"></c:url>" type="text/css" />
		<script type="text/javascript" src="<c:url value="/javascripts/jquery-2.1.1.min.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/jquery.tipsy.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/pages/user/editIdPasswd.js"></c:url>"></script>
	</head>
	<body>
		<%@ include file="../includes/header.jsp" %>
		<div class="content-header">
			<div class="container">
				<h1>
					<spring:message code="title.passwdEditId"></spring:message>
				</h1>
			</div>
		</div>
		<div id="content">
			<div class="container">
				<div class="message bottom successful hidden">
					<spring:message code="passwdEditId.message.successful"></spring:message>
				</div>
				<div class="message bottom error hidden">
					<spring:message code="passwdEditId.message.error"></spring:message>
				</div>
				<div class="edit-form" id="passwdEdit">
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
					<input id="id" type="hidden" value="${user.id}" />
					<div class="submit">
						<span class="button">
							<spring:message code="passwdEdit.submit"></spring:message>
						</span>
						<div class="loading hidden"></div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="../includes/footer.jsp" %>
	</body>
</html>