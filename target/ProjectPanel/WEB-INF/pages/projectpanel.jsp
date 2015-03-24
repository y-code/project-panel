<%@ page import="javax.persistence.Column" %>
<%@ page import="jp.co.ycode.webapp.domain.Project" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<style>
	th, td {
		padding: 15px 10px;
	}
	
	#project table {
		width: 90%;
		margin: 0px auto;
		border-top: 1px solid #888583;
		text-align: left;
		display: float;
	}
	#project table tr {
		border-bottom: 1px solid #888583;
	}
	#project table th {
		background-color: #ffffff;
		width:100px;
	}
	
	#goals table {
		width: 90%;
		margin: 0px auto;
		border-top: 1px solid #888583;
	}
	#goals table tr {
		border-bottom: 1px solid #888583;
	}
	#goals table th {
		background-color: #ffffff;
	}
	
	#members table {
		width: 90%;
		margin: 0px auto;
		border-top: 1px solid #888583;
		text-align: left;
		display: float;
	}
	#members table tr {
		border-bottom: 1px solid #888583;
	}
	#members table th {
		background-color: #ffffff;
	}
</style>
</head>
<body>
	<div id="project">
		<h2>${project.name}</h2>
		<table>
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
	</div>
	<div id="goals">
		<h2>Goals</h2>
		<table>
			<c:forEach items="${project.goals}" var="goal">
				<tr>
					<td>${goal.goal}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="members">
		<h2>Project Members</h2>
		<table>
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
	</div>
</body>
</html>
