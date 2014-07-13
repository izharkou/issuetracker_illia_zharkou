<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			<spring:message code="title.issueSearch"></spring:message>
		</title>
		<link rel="stylesheet" href="<c:url value="/styles/reset.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/style.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/tipsy.css"></c:url>" type="text/css" />
		<script type="text/javascript" src="<c:url value="/javascripts/jquery-2.1.1.min.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/jquery.tipsy.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/pages/issue/search.js"></c:url>"></script>
	</head>
	<body>
		<%@ include file="../includes/header.jsp" %>
		<div class="content-header">
			<div class="container">
				<h1>
					<spring:message code="title.issueSearch"></spring:message>
				</h1>
			</div>
		</div>
		<div id="content">
			<div class="container">
				<div class="message bottom error hidden">
					<spring:message code="dashboard.err404"></spring:message>
				</div>
				<div class="edit-form" id="issueSearch">
					<label for="summary">
						<spring:message code="issueEdit.input.summary"></spring:message>
					</label>
					<input id="summary" class="text" type="text" name="summary" />
					<label for="description">
						<spring:message code="issueEdit.input.description"></spring:message>
					</label>
					<textarea id="description" class="text" name="description"></textarea>
					<label for="status">
						<spring:message code="issueEdit.input.status"></spring:message>
					</label>
					<select id="status" name="status" autocomplete="off">
						<option value="-1" selected="selected"></option>
						<c:forEach items="${statuses}" var="status">
							<option value="${status.id}">${status.name}</option>
						</c:forEach>
					</select>
					<label for="resolution">
						<spring:message code="issueEdit.input.resolution"></spring:message>
						<span class="hidden">*</span>
					</label>
					<select id="resolution" name="resolution" autocomplete="off">
						<option value="-1" selected="selected"></option>
						<c:forEach items="${resolutions}" var="resolution">
							<option value="${resolution.id}">${resolution.name}</option>
						</c:forEach>
					</select>
					<label for="type">
						<spring:message code="issueEdit.input.type"></spring:message>
					</label>
					<select id="type" name="type" autocomplete="off">
						<option value="-1" selected="selected"></option>
						<c:forEach items="${types}" var="type">
							<option value="${type.id}">${type.name}</option>
						</c:forEach>
					</select>
					<label for="priority">
						<spring:message code="issueEdit.input.priority"></spring:message>
					</label>
					<select id="priority" name="priority" autocomplete="off">
						<option value="-1" selected="selected"></option>
						<c:forEach items="${priorities}" var="priority">
							<option value="${priority.id}">${priority.name}</option>
						</c:forEach>
					</select>
					<label for="project">
						<spring:message code="issueEdit.input.project"></spring:message>
					</label>
					<select id="project" name="project" autocomplete="off">
						<option value="-1" selected="selected"></option>
						<c:forEach items="${projects}" var="project">
							<option value="${project.id}">${project.name}</option>
						</c:forEach>
					</select>
					<label for="build">
						<spring:message code="issueEdit.input.build"></spring:message>
					</label>
					<select id="build" name="build" autocomplete="off">
						<option value="-1" selected="selected"></option>
					</select>
					<label for="assignee">
						<spring:message code="issueEdit.input.assignee"></spring:message>
					</label>
					<select id="assignee" name="assignee" autocomplete="off">
						<option value="-1" selected="selected"></option>
						<c:forEach items="${users}" var="user">
							<option value="${user.id}">${user.firstName} ${user.lastName}</option>
						</c:forEach>
					</select>
					<div class="submit">
						<span class="button">
							<spring:message code="issueSearch.submit"></spring:message>
						</span>
						<div class="loading hidden"></div>
					</div>
				</div>
				<div id="results" class="results-table top hidden">
					<table>
						<thead>
							<tr>
								<td>
									<spring:message code="dashboard.table.id"></spring:message>
								</td>
								<td>
									<spring:message code="dashboard.table.priority"></spring:message>
								</td>
								<td>
									<spring:message code="dashboard.table.assignee"></spring:message>
								</td>
								<td>
									<spring:message code="dashboard.table.type"></spring:message>
								</td>
								<td>
									<spring:message code="dashboard.table.status"></spring:message>
								</td>
								<td>
									<spring:message code="dashboard.table.summary"></spring:message>
								</td>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
			</div>
		</div>
		<%@ include file="../includes/footer.jsp" %>
	</body>
</html>