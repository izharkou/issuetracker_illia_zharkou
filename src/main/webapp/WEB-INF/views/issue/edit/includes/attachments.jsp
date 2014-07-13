<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="content-header top">
	<div class="container">
		<h1>
			<spring:message code="issueEdit.attachments"></spring:message>
		</h1>
	</div>
</div>
<div class="container">
	<c:if test="${fn:length(attachments) > 0}">
		<div class="results-table bottom">
			<table>
				<thead>
					<tr>
						<td>
							<spring:message code="issueEdit.attachments.filename"></spring:message>
						</td>
						<td>
							<spring:message code="issueEdit.attachments.addedBy"></spring:message>
						</td>
						<td>
							<spring:message code="issueEdit.attachments.addDate"></spring:message>
						</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${attachments}" var="attachment">
						<tr>
							<td>
								<a href="<c:url value="/issue/download?id=${attachment.issue.id}&filename=${attachment.filename}"></c:url>">
									${attachment.filename}
								</a>
							</td>
							<td>
								<a href="<c:url value="/user/${attachment.addedBy.id}"></c:url>">
									${attachment.addedBy.firstName} ${attachment.addedBy.lastName}
								</a>
							</td>
							<td>${attachment.formattedAddDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	<form action="<c:url value="/issue/attachment?id=${issue.id}"></c:url>" enctype="multipart/form-data" method="post">
		<input type="file" name="file"><br>
		<spring:message code="issueEdit.attachments.submit" var="submit"></spring:message>
		<br>
		<input class="button" type="submit" value="${submit}">
	</form>
</div>