<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			<spring:message code="title.issueAdd"></spring:message>
		</title>
		<link rel="stylesheet" href="<c:url value="/styles/reset.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/style.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/tipsy.css"></c:url>" type="text/css" />
		<script type="text/javascript" src="<c:url value="/javascripts/jquery-2.1.1.min.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/jquery.tipsy.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/pages/issue/add.js"></c:url>"></script>
	</head>
	<body>
		<%@ include file="../includes/header.jsp" %>
		<div class="content-header">
			<div class="container">
				<h1>
					<spring:message code="title.issueAdd"></spring:message>
				</h1>
			</div>
		</div>
		<div id="content">
			<div class="container">
				<div class="message bottom successful hidden">
					<spring:message code="issueAdd.message.successful"></spring:message>
				</div>
				<div class="message bottom error hidden">
					<spring:message code="issueAdd.message.error"></spring:message>
				</div>
				<div class="edit-form" id="issueAdd">
					<label for="summary">
						<spring:message code="issueEdit.input.summary"></spring:message>
						<span>*</span>
					</label>
					<spring:message code="issueEdit.error.summary" var="errorSummary"></spring:message>
					<input id="summary" class="text" type="text" name="summary" original-title="${errorSummary}" value="${issue.summary}" />
					<label for="description">
						<spring:message code="issueEdit.input.description"></spring:message>
						<span>*</span>
					</label>
					<spring:message code="issueEdit.error.description" var="errorDescription"></spring:message>
					<textarea id="description" class="text" name="description" original-title="${errorDescription}">${issue.description}</textarea>
					<label for="status">
						<spring:message code="issueEdit.input.status"></spring:message>
						<span>*</span>
					</label>
					<select id="status" name="status" autocomplete="off">
						<c:forEach items="${statuses}" var="status">
							<c:if test="${status.id eq '1' or status.id eq '2'}">
								<option value="${status.id}">
									${status.name}
								</option>
							</c:if>
						</c:forEach>
					</select>
					<label for="type">
						<spring:message code="issueEdit.input.type"></spring:message>
						<span>*</span>
					</label>
					<select id="type" name="type" autocomplete="off">
						<c:forEach items="${types}" var="type">
							<option value="${type.id}">
								${type.name}
							</option>
						</c:forEach>
					</select>
					<label for="priority">
						<spring:message code="issueEdit.input.priority"></spring:message>
						<span>*</span>
					</label>
					<select id="priority" name="priority" autocomplete="off">
						<c:forEach items="${priorities}" var="priority">
							<option value="${priority.id}">
								${priority.name}
							</option>
						</c:forEach>
					</select>
					<label for="project">
						<spring:message code="issueEdit.input.project"></spring:message>
						<span>*</span>
					</label>
					<select id="project" name="project" autocomplete="off">
						<c:forEach items="${projects}" var="project">
							<option value="${project.id}">
								${project.name}
							</option>
						</c:forEach>
					</select>
					<label for="build">
						<spring:message code="issueEdit.input.build"></spring:message>
						<span>*</span>
					</label>
					<select id="build" name="build" autocomplete="off">
						<c:forEach items="${projects[0].builds}" var="build">
							<option value="${build.id}">
								${build.version}
							</option>
						</c:forEach>
					</select>
					<label for="assignee">
						<spring:message code="issueEdit.input.assignee"></spring:message>
						<span class="hidden">*</span>
					</label>
					<spring:message code="issueEdit.error.assignee" var="errorAssignee"></spring:message>
					<select id="assignee" name="assignee" autocomplete="off" disabled="disabled" original-title="${errorAssignee}">
						<option value="-1" selected="selected"></option>
						<c:forEach items="${users}" var="user">
							<option value="${user.id}">
								${user.firstName} ${user.lastName}
							</option>
						</c:forEach>
					</select>
					<div class="submit">
						<span class="button">
							<spring:message code="issueAdd.submit"></spring:message>
						</span>
						<div class="loading hidden"></div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="../includes/footer.jsp" %>
	</body>
</html>