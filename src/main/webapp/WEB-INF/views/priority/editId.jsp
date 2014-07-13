<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			<spring:message code="title.priorityEditId"></spring:message>
		</title>
		<link rel="stylesheet" href="<c:url value="/styles/reset.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/style.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/tipsy.css"></c:url>" type="text/css" />
		<script type="text/javascript" src="<c:url value="/javascripts/jquery-2.1.1.min.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/jquery.tipsy.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/pages/priority/editId.js"></c:url>"></script>
	</head>
	<body>
		<%@ include file="../includes/header.jsp" %>
		<div class="content-header">
			<div class="container">
				<h1>
					<spring:message code="title.priorityEditId"></spring:message>
				</h1>
			</div>
		</div>
		<div id="content">
			<div class="container">
				<c:choose>
					<c:when test="${empty priority}">
						<div class="message error">
							<spring:message code="priorityEdit.err404" />
						</div>
					</c:when>
					<c:otherwise>
						<div class="message bottom successful hidden">
							<spring:message code="priorityEdit.message.successful"></spring:message>
						</div>
						<div class="message bottom error hidden">
							<spring:message code="priorityEdit.message.error"></spring:message>
						</div>
						<div class="edit-form" id="priorityEdit">
							<label for="name">
								<spring:message code="priorityEdit.input.name"></spring:message>
								<span>*</span>
							</label>
							<spring:message code="priorityEdit.error.name" var="errorName"></spring:message>
							<input id="name" class="text" type="text" name="name" original-title="${errorName}" value="${priority.name}" />
							<input id="id" type="hidden" value="${priority.id}" />
							<div class="submit">
								<span class="button">
									<spring:message code="priorityEdit.submit"></spring:message>
								</span>
								<div class="loading hidden"></div>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<%@ include file="../includes/footer.jsp" %>
	</body>
</html>