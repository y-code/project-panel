<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/signup" var="signupUrl" htmlEscape="true" />
<spring:url value="/projectpanel" var="projectPanelUrl" htmlEscape="true" />

<html>
<head>
<style>
	table.projects {
		width: 90%;
		border-top: 1px solid #888583;
		border-right: 1px solid #e5eff8;
		margin: 1em auto;
		border-collapse: collapse;
	}
	table.projects td {
		color: #678197;
		border-left: 1px solid #e5eff8;
		padding: .3em 1em;
		text-align: left;
	}
	table.projects tr:nth-child(3n+1) {
		background: #f4f9fe;
		cursor: pointer;
		border-bottom: 1px solid #e5eff8;
	}
	table.projects tr:nth-child(3n+2) {
		background: #f9fcfe;
		border-bottom: 1px solid #e5eff8;
	}
	table.projects tr:nth-child(3n+0) {
		background: #f9fcfe;
		border-bottom: 1px solid #888583;
	}
	table.projects th {
		background: #ffffff;
		border-bottom: 1px solid #e5eff8;
		border-left: 1px solid #e5eff8;
		padding: .3em 1em;
		text-align: left;
	}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("table.projects tr:nth-child(3n+1)").click(function() {
			document.location = $(this).find("a:first").attr("href");
		});
	});
</script>
</head>
</head>
<body>
	<h2>About this site</h2>
	<p>Do you have something to get? Do you have something to achieve? <a href="${signupUrl}">Come and join us!</a></p>
	<p>Regardless of your gender or age, it is never an easy task to achieve something great. Have you done something for it? Do you know what to do next? This web site can support you to achieve your wills!</p>
	<p>The services here will let you focus on your aim even in your life full of temptations. Don't waste precious time in your life. You can sharpen up you and your life using this achievement system here.</p>
	<p>But don't forget that your enthusiasm is the power source of this system.</p>
	<h2>Active Projects</h2>
	<div>The followings are the projects currently active on this site. Are there something interesting? Click on it and get on the project!</div>
	<table class="projects">
		<caption>Projects</caption>
		<c:forEach items="${projects}" var="project">
			<tr><td colspan=2><a href="${projectPanelUrl}?id=${project.id}">${project.name}</a></td></tr>
			<tr><td>Vision</td><td>${project.vision}</td></tr>
			<tr><td>Mission</td><td>${project.mission}</td></tr>
		</c:forEach>
	</table>
</body>
</html>
