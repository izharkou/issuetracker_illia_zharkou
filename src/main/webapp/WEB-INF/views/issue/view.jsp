<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			<spring:message code="title.issueView"></spring:message>
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
					<spring:message code="title.issueView"></spring:message>
				</h1>
			</div>
		</div>
		<div id="content">
			<div class="container">
				<table class="issue-view">
					<tr>
						<td>
							<spring:message code="issueEdit.input.createdDate"></spring:message>
						</td>
						<td>${issue.audit.formattedCreatedDate}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="issueEdit.input.createdBy"></spring:message>
						</td>
						<td>${issue.audit.createdBy.firstName} ${issue.audit.createdBy.lastName}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="issueEdit.input.modifiedDate"></spring:message>
						</td>
						<td>${issue.audit.formattedModifiedDate}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="issueEdit.input.modifiedBy"></spring:message>
						</td>
						<td>${issue.audit.modifiedBy.firstName} ${issue.audit.modifiedBy.lastName}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="issueEdit.input.summary"></spring:message>
						</td>
						<td>${issue.summary}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="issueEdit.input.description"></spring:message>
						</td>
						<td>${issue.description}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="issueEdit.input.status"></spring:message>
						</td>
						<td>${issue.status.name}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="issueEdit.input.resolution"></spring:message>
						</td>
						<td>${issue.resolution.name}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="issueEdit.input.status"></spring:message>
						</td>
						<td>${issue.status.name}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="issueEdit.input.type"></spring:message>
						</td>
						<td>${issue.type.name}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="issueEdit.input.priority"></spring:message>
						</td>
						<td>${issue.priority.name}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="issueEdit.input.project"></spring:message>
						</td>
						<td>${issue.build.project.name}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="issueEdit.input.build"></spring:message>
						</td>
						<td>${issue.build.version}</td>
					</tr>
					<tr>
						<td>
							<spring:message code="issueEdit.input.assignee"></spring:message>
						</td>
						<td>${issue.assignee.firstName} ${issue.assignee.lastName}</td>
					</tr>
				</table>
				<security:authorize access="isAuthenticated()">
					<div class="issue-edit">
						<a class="button" href="<c:url value="/issue/edit/${issue.id}"></c:url>">
							<spring:message code="issueEdit.submit"></spring:message>
						</a>
					</div>
				</security:authorize>
			</div>
		</div>
		<%@ include file="../includes/footer.jsp" %>
	</body>
</html>