<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			<spring:message code="title.projectEditId"></spring:message>
		</title>
		<link rel="stylesheet" href="<c:url value="/styles/reset.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/style.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/tipsy.css"></c:url>" type="text/css" />
		<script type="text/javascript" src="<c:url value="/javascripts/jquery-2.1.1.min.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/jquery.tipsy.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/pages/project/editId.js"></c:url>"></script>
	</head>
	<body>
		<%@ include file="../includes/header.jsp" %>
		<div class="content-header">
			<div class="container">
				<h1>
					<spring:message code="title.projectEditId"></spring:message>
				</h1>
			</div>
		</div>
		<div id="content">
			<div class="container">
				<c:choose>
					<c:when test="${empty project}">
						<div class="message error">
							<spring:message code="projectEdit.err404" />
						</div>
					</c:when>
					<c:otherwise>
						<div class="message bottom successful hidden">
							<spring:message code="projectEdit.message.successful"></spring:message>
						</div>
						<div class="message bottom error hidden">
							<spring:message code="projectEdit.message.error"></spring:message>
						</div>
						<div class="edit-form" id="projectEdit">
							<label for="name">
								<spring:message code="projectEdit.input.name"></spring:message>
								<span>*</span>
							</label>
							<spring:message code="projectEdit.error.name" var="errorName"></spring:message>
							<input id="name" class="text" type="text" name="name" original-title="${errorName}" value="${project.name}" />
							
							<label for="description">
								<spring:message code="projectEdit.input.description"></spring:message>
								<span>*</span>
							</label>
							<spring:message code="projectEdit.error.description" var="errorDescription"></spring:message>
							<textarea id="description" class="text" name="description" original-title="${errorDescription}">${project.description}</textarea>
							
							<label for="manager">
								<spring:message code="projectEdit.input.manager"></spring:message>
								<span>*</span>
							</label>
							<select id="manager" name="manager" autocomplete="off">
								<c:forEach items="${managers}" var="manager">
									<option value="${manager.id}" ${manager.id == project.manager.id ? 'selected' : ''}>
										${manager.firstName} ${manager.lastName}
									</option>
								</c:forEach>
							</select>
							
							<label for="build">
								<spring:message code="projectEdit.input.build"></spring:message>
								<span>*</span>
							</label>
							<select id="build" name="build" autocomplete="off">
								<c:forEach items="${project.builds}" var="build">
									<option value="${build.id}" ${build.current ? 'selected' : ''}>
										${build.version}
									</option>
								</c:forEach>
							</select>
							
							<spring:message code="projectEdit.input.newBuild" var="newBuild"></spring:message>
							<span class="input-link" original-title="${newBuild}">
								<spring:message code="projectEdit.input.createBuild"></spring:message>
							</span>
							
							<input id="id" type="hidden" value="${project.id}" />
							<div class="submit">
								<span class="button">
									<spring:message code="projectEdit.submit"></spring:message>
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