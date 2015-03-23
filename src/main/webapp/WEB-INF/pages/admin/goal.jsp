<%@ page session="true"%>
<%@ page import="javax.persistence.Column" %>
<%@ page import="jp.co.ycode.webapp.domain.ProjectGoal" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url value="/admin/goal" var="goalUrl" htmlEscape="true" />
<jsp:useBean id="aa" class="jp.co.ycode.webapp.util.AnnotationAccessUtilBean" />

<html>
<head>
<style>
	table#goal {
		border-top: 1px solid #888583;
		text-align: left;
		display: float;
	}
	table#goal th, td {
		padding: 10px 10px;
		vertical-align: top;
		border-bottom: 1px solid #888583;
	}
	table#goal th {
		max-width: 100px;
		background-color: #ffffff;
	}
	table#goal td {
		width: 80%;
	}
	td.control {
		text-align: center;
		border-bottom: 0px;
	}
</style>
</head>
<body>
	<form:form modelAttribute="goal" action="${goalUrl}" method="post">
	<table id="goal">
		<tr>
			<th>Goal</th>
			<td>
				<form:input path="goal" size="32" maxlength="<%= aa.getColumnLength(ProjectGoal.class, \"goal\") %>" />
				<form:errors path="goal" cssClass="errors"/>
			</td>
		</tr>
		<tr>
			<td class="control" colspan=2>
				<c:choose>
					<c:when test="${goal.new}">
						<input name="add_goal" type="submit" value="Add Goal" onclick="return confirm('Are you sure you want to add the new goal?')"/>
					</c:when>
					<c:otherwise>
						<input name="update_goal" type="submit" value="Update" onclick="return confirm('Are you sure you want to save the change?')"/>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
	</form:form>
	
	<div id="strategies">
	</div>
</body>
</html>
