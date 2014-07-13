<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			<spring:message code="title.projectAdd"></spring:message>
		</title>
		<link rel="stylesheet" href="<c:url value="/styles/reset.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/style.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/tipsy.css"></c:url>" type="text/css" />
		<script type="text/javascript" src="<c:url value="/javascripts/jquery-2.1.1.min.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/jquery.tipsy.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/pages/project/add.js"></c:url>"></script>
	</head>
	<body>
		<%@ include file="../includes/header.jsp" %>
		<div class="content-header">
			<div class="container">
				<h1>
					<spring:message code="title.projectAdd"></spring:message>
				</h1>
			</div>
		</div>
		<div id="content">
			<div class="container">
				<div class="message bottom successful hidden">
					<spring:message code="projectAdd.message.successful"></spring:message>
				</div>
				<div class="message bottom error hidden">
					<spring:message code="projectAdd.message.error"></spring:message>
				</div>
				<div class="edit-form" id="projectAdd">
					<label for="name">
						<spring:message code="projectEdit.input.name"></spring:message>
						<span>*</span>
					</label>
					<spring:message code="projectEdit.error.name" var="errorName"></spring:message>
					<input id="name" class="text" type="text" name="name" original-title="${errorName}" />
					
					<label for="description">
						<spring:message code="projectEdit.input.description"></spring:message>
						<span>*</span>
					</label>
					<spring:message code="projectEdit.error.description" var="errorDescription"></spring:message>
					<textarea id="description" class="text" name="description" original-title="${errorDescription}"></textarea>
					
					<label for="manager">
						<spring:message code="projectEdit.input.manager"></spring:message>
						<span>*</span>
					</label>
					<select id="manager" name="manager" autocomplete="off">
						<c:forEach items="${managers}" var="manager">
							<option value="${manager.id}">
								${manager.firstName} ${manager.lastName}
							</option>
						</c:forEach>
					</select>
					
					<label for="build">
						<spring:message code="projectEdit.input.build"></spring:message>
						<span>*</span>
					</label>
					<spring:message code="projectEdit.error.build" var="errorBuild"></spring:message>
					<input id="build" type="text" class="text" name="build" original-title="${errorBuild}" />
					
					<div class="submit">
						<span class="button">
							<spring:message code="projectAdd.submit"></spring:message>
						</span>
						<div class="loading hidden"></div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="../includes/footer.jsp" %>
	</body>
</html>