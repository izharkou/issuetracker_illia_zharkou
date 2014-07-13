<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div id="header">
	<div class="container">
		<a href="<c:url value="/"></c:url>" class="logo">
			<img src="<c:url value="/images/issuetracker-logo2.png"></c:url>">
		</a>
		<div class="buttons">
			<security:authorize access="isAuthenticated()">
				<a class="button" href="<c:url value="/issue/add"></c:url>">
					<spring:message code="header.issue.submit"></spring:message>
				</a>
			</security:authorize>
			<a class="button" href="<c:url value="/issue/search"></c:url>">
				<spring:message code="header.issue.search"></spring:message>
			</a>
		</div>
		<security:authorize access="isAnonymous()">
			<div class="user">
				<form id="login" method="post" action="<c:url value="/j_spring_security_check"></c:url>">
					<spring:message code="header.login.email" var="email"></spring:message>
					<spring:message code="header.login.error.email" var="errorEmail"></spring:message>
					<input id="email" class="text" type="text" name="j_username" placeholder="${email}" original-title="${errorEmail}" />
					<spring:message code="header.login.passwd" var="passwd"></spring:message>
					<spring:message code="header.login.error.passwd" var="errorPasswd"></spring:message>
					<input id="passwd" class="text" type="password" name="j_password" placeholder="${passwd}" original-title="${errorPasswd}" />
					<spring:message code="header.login.submit" var="submit"></spring:message>
					<input class="button" type="submit" value="${submit}" />
				</form>
			</div>
		</security:authorize>
		<security:authorize access="isAuthenticated()">
			<c:set var="userName">
				<security:authentication property="principal.fullName" />
			</c:set>
			<ul class="user-menu">
				<li>
					<spring:message code="header.welcome" 
						arguments="${userName}" htmlEscape="false"></spring:message>
				</li>
				<li><a href="<c:url value="/user/edit"></c:url>">
					<spring:message code="header.links.editProfile"></spring:message>
				</a></li>
				<li><a href="<c:url value="/user/edit/password"></c:url>">
					<spring:message code="header.links.changePasswd"></spring:message>
				</a></li>
				<li><a href="<c:url value="/j_spring_security_logout"></c:url>">
					<spring:message code="header.links.logout"></spring:message>
				</a></li>
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li class="admin">
						<spring:message code="header.links.admin"></spring:message>
						<ul class="admin-menu">
							<li><a href="<c:url value="/project/list/1"></c:url>">
								<spring:message code="header.admin.projects"></spring:message>
							</a></li>
							<li><a href="<c:url value="/status/list"></c:url>">
								<spring:message code="header.admin.statuses"></spring:message>
							</a></li>
							<li><a href="<c:url value="/resolution/list"></c:url>">
								<spring:message code="header.admin.resolutions"></spring:message>
							</a></li>
							<li><a href="<c:url value="/priority/list"></c:url>">
								<spring:message code="header.admin.priorities"></spring:message>
							</a></li>
							<li><a href="<c:url value="/type/list"></c:url>">
								<spring:message code="header.admin.types"></spring:message>
							</a></li>
							<li class="separator"></li>
							<li><a href="<c:url value="/project/add"></c:url>">
								<spring:message code="header.admin.addProject"></spring:message>
							</a></li>
							<li><a href="<c:url value="/resolution/add"></c:url>">
								<spring:message code="header.admin.addResolution"></spring:message>
							</a></li>
							<li><a href="<c:url value="/priority/add"></c:url>">
								<spring:message code="header.admin.addPriority"></spring:message>
							</a></li>
							<li><a href="<c:url value="/type/add"></c:url>">
								<spring:message code="header.admin.addType"></spring:message>
							</a></li>
							<li><a href="<c:url value="/user/add"></c:url>">
								<spring:message code="header.admin.addUser"></spring:message>
							</a></li>
							<li class="separator"></li>
							<li><a href="<c:url value="/user/search"></c:url>">
								<spring:message code="header.admin.searchUser"></spring:message>
							</a></li>
						</ul>
					</li>
				</security:authorize>
			</ul>
		</security:authorize>
	</div>
</div>