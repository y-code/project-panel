<%@ page import="javax.persistence.Column" %>
<%@ page import="jp.co.ycode.webapp.domain.Project" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url value="/admin/project" var="projectUrl" htmlEscape="true" />
<jsp:useBean id="aa" class="jp.co.ycode.webapp.util.AnnotationAccessUtilBean" />

<html>
<head>
<style>
	table.project {
		border-top: 1px solid #888583;
		text-align: left;
		display: float;
	}
	table.project th, td {
		padding: 10px 10px;
		vertical-align: top;
		border-bottom: 1px solid #888583;
	}
	table.project th {
		max-width: 100px;
		background-color: #ffffff;
	}
	table.project td {
		width: 80%;
	}
	td.control {
		text-align: center;
		border-bottom: 0px;
	}
</style>
</head>
<body>
	<form:form modelAttribute="project" action="${projectUrl}" method="post">
	<table class="project">
		<tr>
			<th>Project Name</th>
			<td>
				<form:input path="name" size="32" maxlength="<%= aa.getColumnLength(Project.class, \"name\") %>" />
				<form:errors path="name" cssClass="errors"/>
			</td>
		</tr>
		<tr>
			<th>Vision</th>
			<td>
				<form:textarea path="vision" rows="5" cols="50" maxlength="<%= aa.getColumnLength(Project.class, \"vision\") %>" />
				<form:errors path="vision" cssClass="errors"/>
			</td>
		</tr>
		<tr>
			<th>Mission</th>
			<td>
				<form:textarea path="mission" rows="5" cols="50" maxlength="<%= aa.getColumnLength(Project.class, \"mission\") %>" />
				<form:errors path="mission" cssClass="errors"/>
			</td>
		</tr>
		<tr>
			<td class="control" colspan=2>
				<c:choose>
					<c:when test="${project.new}">
						<input name="add_project" type="submit" value="Add Project" onclick="return confirm('Are you sure you want to add the new project?')"/>
					</c:when>
					<c:otherwise>
						<input name="update_project" type="submit" value="Update" onclick="return confirm('Are you sure you want to save the update?')"/>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
	</form:form>
</body>
</html>
