<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="f" uri="http://training.by/math/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			<spring:message code="dashboard.latestIssues"></spring:message>
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
					<spring:message code="dashboard.latestIssues"></spring:message>
				</h1>
			</div>
		</div>
		<div id="content">
			<div class="container">
				<c:choose>
					<c:when test="${fn:length(issues.content) == 0}">
						<div class="message info">
							<spring:message code="dashboard.err404"></spring:message>
						</div>
					</c:when>
					<c:otherwise>
						<div class="results-table">
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
								<tbody>
									<c:forEach items="${issues.content}" var="issue">
										<tr>
											<td>
												<security:authorize access="isAnonymous()">
													<a href="<c:url value="/issue/${issue.id}"></c:url>">${issue.id}</a>
												</security:authorize>
												<security:authorize access="isAuthenticated()">
													<a href="<c:url value="/issue/edit/${issue.id}"></c:url>">${issue.id}</a>
												</security:authorize>
											</td>
											<td class="bold ${issue.priority.name}">${issue.priority.name}</td>
											<td>
												<c:choose>
													<c:when test="${not empty issue.assignee}">
														${issue.assignee.firstName} ${issue.assignee.lastName}
													</c:when>
													<c:otherwise>
														-/-
													</c:otherwise>
												</c:choose>
											</td>
											<td>${issue.type.name}</td>
											<td>${issue.status.name}</td>
											<td>${issue.shortSummary}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<c:set var="currentIndex" value="${issues.number + 1}" />
						<c:set var="beginIndex" value="${f:max(1, currentIndex - 5)}" />
						<c:set var="endIndex" value="${f:min(beginIndex + 10, issues.totalPages)}" />
						<c:url var="firstUrl" value="/issue/list/1" />
						<c:url var="lastUrl" value="/issue/list/${issues.totalPages}" />
						<c:url var="prevUrl" value="/issue/list/${currentIndex - 1}" />
						<c:url var="nextUrl" value="/issue/list/${currentIndex + 1}" />
						<div class="pagination">
						    <ul>
						        <c:choose>
						            <c:when test="${currentIndex == 1}">
						                <li><span class="button disabled">&lt;&lt;</span></li>
						                <li><span class="button disabled">&lt;</span></li>
						            </c:when>
						            <c:otherwise>
						                <li><a class="button" href="${firstUrl}">&lt;&lt;</a></li>
						                <li><a class="button" href="${prevUrl}">&lt;</a></li>
						            </c:otherwise>
						        </c:choose>
						        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
						            <c:url var="pageUrl" value="/issue/list/${i}" />
						            <c:choose>
						                <c:when test="${i == currentIndex}">
						                    <li><a class="button green" href="${pageUrl}"><c:out value="${i}" /></a></li>
						                </c:when>
						                <c:otherwise>
						                    <li><a class="button" href="${pageUrl}"><c:out value="${i}" /></a></li>
						                </c:otherwise>
						            </c:choose>
						        </c:forEach>
						        <c:choose>
						            <c:when test="${currentIndex == issues.totalPages}">
						                <li><span class="button disabled">&gt;</span></li>
						                <li><span class="button disabled">&gt;&gt;</span></li>
						            </c:when>
						            <c:otherwise>
						                <li><a class="button" href="${nextUrl}">&gt;</a></li>
						                <li><a class="button" href="${lastUrl}">&gt;&gt;</a></li>
						            </c:otherwise>
						        </c:choose>
						    </ul>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<%@ include file="../includes/footer.jsp" %>
	</body>
</html>