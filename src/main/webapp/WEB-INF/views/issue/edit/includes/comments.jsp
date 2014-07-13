<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="content-header top">
	<div class="container">
		<h1>
			<spring:message code="issueEdit.comments"></spring:message>
		</h1>
	</div>
</div>
<div class="container">
	<div class="comments">
		<c:forEach items="${comments}" var="comment">
			<div class="comment">
				<div class="author">
					<a href="<c:url value="/user/${comment.addedBy.id}"></c:url>">
						${comment.addedBy.firstName} ${comment.addedBy.lastName}
					</a>
					<span>
						${comment.formattedAddDate}
					</span>
				</div>
				<p>${comment.comment}</p>
			</div>
		</c:forEach>
	</div>
	<div id="commentAdd" class="edit-form">
		<label for="comment">
			<spring:message code="commentAdd.label"></spring:message>
		</label>
		<textarea id="comment" class="text" name="comment"></textarea>
		<input id="issue" type="hidden" value="${issue.id}" />
		<div class="submit">
			<span class="button">
				<spring:message code="commentAdd.submit"></spring:message>
			</span>
		</div>
	</div>
</div>