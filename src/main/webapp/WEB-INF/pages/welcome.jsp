<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="signupUrl" value="/signup" htmlEscape="true" />
<spring:url var="devroomUrl" value="/devroom" htmlEscape="true" />
<spring:url var="projectPanelUrl" value="/projectpanel" htmlEscape="true" />

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
	
	<h2>Important Notes</h2>
	<p>This website is still <span style="color:red">under construction</span>. We cannot assure the persistence of your data here. Please use services here only within a evaluation use at this moment. More functionalities are coming soon! We hope that we could announce its first system release before long.</p>
	
	<h2>News</h2>
	<div class="news">
		<h3>26 March, 2015</h3>
		<ul>
			<li><u>'Project Planning' section</u> was added in <a href="${devroomUrl}#project-planning">Developers' Room</a>.</li>
			<li><u>'User Stories' section</u> was added in <a href="${devroomUrl}#user-stories">Developers' Room</a>.</li>
		</ul>
	</div>
	<div class="news">
		<h3>25 March, 2015</h3>
		<ul>
			<li><u>Goal Addition/Update page</u> was changed to be opened in a jQuery UI dialog.</li>
		</ul>
	</div>
	<div class="news">
		<h3>24 March, 2015</h3>
		<ol>
			<li>This <u>'News' section</u> was added.</li>
			<li><u>'Goals' section</u> was added on Project Panel page.</li>
		</ol>
	</div>
	<div class="news">
		<h3>23 March, 2015</h3>
		<ul>
			<li><u>Goal Addition/Update function</u> was added on project update page.</li>
		</ul>
	</div>
	
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
