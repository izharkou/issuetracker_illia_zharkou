<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://training.by/math/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			<spring:message code="title.projects"></spring:message>
		</title>
		<link rel="stylesheet" href="<c:url value="/styles/reset.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/style.css"></c:url>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/styles/tipsy.css"></c:url>" type="text/css" />
		<script type="text/javascript" src="<c:url value="/javascripts/jquery-2.1.1.min.js"></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/jquery.tipsy.js"></c:url>"></script>
	</head>
	<body>
		<%@ include file="../includes/header.jsp" %>
		<div class="content-header">
			<div class="container">
				<h1>
					<spring:message code="title.projects"></spring:message>
				</h1>
			</div>
		</div>
		<div id="content">
			<div class="container">
				<c:choose>
					<c:when test="${empty projects.content}">
						<div class="message error">
							<spring:message code="projectEdit.err404"></spring:message>
						</div>
					</c:when>
					<c:otherwise>
						<div class="results-table">
							<table>
								<thead>
									<tr>
										<td>
											<spring:message code="projects.table.name"></spring:message>
										</td>
										<td>
											<spring:message code="projects.table.description"></spring:message>
										</td>
										<td>
											<spring:message code="projects.table.manager"></spring:message>
										</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${projects.content}" var="project">
										<tr>
											<td>
												<a href="<c:url value="/project/edit/${project.id}"></c:url>">${project.name}</a>
											</td>
											<td>${project.shortDescription}</td>
											<td>
												<a href="<c:url value="/user/${project.manager.id}"></c:url>">${project.manager.firstName} ${project.manager.lastName}</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<c:set var="currentIndex" value="${projects.number + 1}" />
						<c:set var="beginIndex" value="${f:max(1, currentIndex - 5)}" />
						<c:set var="endIndex" value="${f:min(beginIndex + 10, projects.totalPages)}" />
						<c:url var="firstUrl" value="/project/list/1" />
						<c:url var="lastUrl" value="/project/list/${projects.totalPages}" />
						<c:url var="prevUrl" value="/project/list/${currentIndex - 1}" />
						<c:url var="nextUrl" value="/project/list/${currentIndex + 1}" />
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
						            <c:url var="pageUrl" value="/project/list/${i}" />
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
						            <c:when test="${currentIndex == projects.totalPages}">
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