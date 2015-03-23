<%@ page import="javax.persistence.Column" %>
<%@ page import="jp.co.ycode.webapp.domain.Project" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url var="projectUrl" value="/admin/project" htmlEscape="true" />
<spring:url var="listOfGoalsUrl" value="/admin/listofgoals" htmlEscape="true" />
<spring:url var="jqueryUrl" value="/resources/js/jquery-2.1.3.min.js" htmlEscape="true" />
<spring:url var="jqueryUiCssUrl" value="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
<spring:url var="jqueryUiJsUrl" value="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js" />
<jsp:useBean id="aa" class="jp.co.ycode.webapp.util.AnnotationAccessUtilBean" />

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${jqueryUiCssUrl}" media="screen, projection" />
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
		
		table#goals {
			width: 90%;
			border-top: 1px solid #e5eff8;
			border-right: 1px solid #e5eff8;
			margin: 1em auto;
			border-collapse: collapse;
		}
		table#goals td {
			color: #678197;
			border-left: 1px solid #e5eff8;
			padding: .3em 1em;
			text-align: left;
		}
		table#goals tr {
			cursor: pointer;
			border-bottom: 1px solid #888583;
			background: #f9fcfe;
		}
		table#goals tr td.control {
			cursor: default;
			background: transparent;
			text-align: right;
		}
		table#goals th {
			background: #ffffff;
			border-bottom: 1px solid #e5eff8;
			border-left: 1px solid #e5eff8;
			padding: .3em 1em;
			text-align: left;
		}
	</style>
	<script type="text/javascript" src="${jqueryUrl}"></script>
	<script type="text/javascript" src="${jqueryUiJsUrl}"></script>
	<script type="text/javascript">
		
	</script>
</head>
<body>
	<script type="text/javascript">
		<c:if test="${!project.new}">
		$(document).ready(function() {
			var listPage = $.get("${listOfGoalsUrl}?id=${project.id}", function(data) {
				$("#goals").html($(data).find("table#goals"));
				$.globalEval($(data).find("script").html());
			});
		});
		</c:if>
	</script>
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
	<div id="goals" style="width: 100%;"></div>
</body>
</html>
