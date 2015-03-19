<%@ page import="javax.persistence.Column" %>
<%@ page import="jp.co.ycode.webapp.domain.Project" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<style>
	table.project {
		width: 100%;
		border-top: 1px solid #888583;
		text-align: left;
		display: float;
	}
	table.project th, td {
		padding: 15px 10px;
	}
	table.project tr {
		border-bottom: 1px solid #888583;
	}
	table.project th {
		background-color: #ffffff;
		width:100px;
	}
	table.members {
		width: 100%;
		border-top: 1px solid #888583;
		text-align: left;
		display: float;
	}
	table.members th, td {
		padding: 15px 10px;
	}
	table.members tr {
		border-bottom: 1px solid #888583;
	}
	table.members th {
		background-color: #ffffff;
	}
</style>
</head>
<body>
	<h2>${project.name}</h2>
	<p>
		<table class="project">
			<tr>
				<th>Vision</th>
				<td>
					${project.vision}
				</td>
			</tr>
			<tr>
				<th>Mission</th>
				<td>
					${project.mission}
				</td>
			</tr>
		</table>
	</p>
	<h2>Project Members</h2>
	<p>
		<table class="members">
			<tr><th>Member Name</th><th>Member Type</th></tr>
			<c:forEach items="${project.members}" var="member">
				<tr>
					<td>${member.user.name}</td>
					<td>
						<c:choose>
							<c:when test="${member.projectOwner}">OWNER</c:when>
							<c:otherwise>GENERAL</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
	</p>
</body>
</html>
