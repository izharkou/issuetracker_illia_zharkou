<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="STATUS_NEW" value="1" />
<c:set var="STATUS_ASSIGNED" value="2" />
<c:set var="STATUS_IN_PROGRESS" value="3" />
<c:set var="STATUS_RESOLVED" value="4" />
<c:set var="STATUS_CLOSED" value="5" />
<c:set var="STATUS_REOPENED" value="6" />
<c:choose>
	<c:when test="${empty issue}">
		<%@ include file="not_found.jsp" %>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${issue.status.id eq STATUS_NEW}">
				<%@ include file="edit/new.jsp" %>
			</c:when>
			<c:when test="${issue.status.id eq STATUS_ASSIGNED or issue.status.id eq STATUS_REOPENED}">
				<%@ include file="edit/assigned_or_reopened.jsp" %>
			</c:when>
			<c:when test="${issue.status.id eq STATUS_IN_PROGRESS or issue.status.id eq STATUS_RESOLVED}">
				<%@ include file="edit/in_progress_or_resolved.jsp" %>
			</c:when>
			<c:when test="${issue.status.id eq STATUS_CLOSED}">
				<%@ include file="edit/closed.jsp" %>
			</c:when>
		</c:choose>
	</c:otherwise>
</c:choose>