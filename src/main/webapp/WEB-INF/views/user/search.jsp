<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			<spring:message code="title.userSearch"></spring:message>
		</title>
		<link rel="stylesheet" href="<c:url value="/styles/reset.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/style.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/tipsy.css"></c:url>" type="text/css" />
		<script type="text/javascript" src="<c:url value="/javascripts/jquery-2.1.1.min.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/jquery.tipsy.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/pages/user/search.js"></c:url>"></script>
	</head>
	<body>
		<%@ include file="../includes/header.jsp" %>
		<div class="content-header">
			<div class="container">
				<h1>
					<spring:message code="title.userSearch"></spring:message>
				</h1>
			</div>
		</div>
		<div id="content">
			<div class="container">
				<div class="message bottom error hidden">
					<spring:message code="userSearch.err404"></spring:message>
				</div>
				<div class="edit-form" id="userSearch">
					<label for="firstName">
						<spring:message code="userAdd.input.firstName"></spring:message>
					</label>
					<input id="firstName" class="text" type="text" name="firstName" />
					<label for="lastName">
						<spring:message code="userAdd.input.lastName"></spring:message>
					</label>
					<input id="lastName" class="text" type="text" name="lastName" />
					<label for="email">
						<spring:message code="userAdd.input.email"></spring:message>
					</label>
					<input id="email" class="text" type="text" name="email" />
					<label for="role">
						<spring:message code="userAdd.input.role"></spring:message>
					</label>
					<select id="role" name="role" autocomplete="off">
						<option value="" selected="selected">
							<spring:message code="userAdd.input.role.any"></spring:message>
						</option>
						<option value="ROLE_USER">
							<spring:message code="userAdd.input.role.user"></spring:message>
						</option>
						<option value="ROLE_ADMIN">
							<spring:message code="userAdd.input.role.admin"></spring:message>
						</option>
					</select>
					<div class="submit">
						<span class="button">
							<spring:message code="userSearch.submit"></spring:message>
						</span>
						<div class="loading hidden"></div>
					</div>
				</div>
				<div id="results" class="results-table top hidden">
					<table>
						<thead>
							<tr>
								<td>
									<spring:message code="userSearch.table.id"></spring:message>
								</td>
								<td>
									<spring:message code="userSearch.table.firstName"></spring:message>
								</td>
								<td>
									<spring:message code="userSearch.table.lastName"></spring:message>
								</td>
								<td>
									<spring:message code="userSearch.table.email"></spring:message>
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