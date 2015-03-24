<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="logoutUrl" value="/j_spring_security_logout" />
<c:url var="projectUrl" value="/admin/project" />

<html>
<head>
<style>
	table.projects {
		width: 90%;
		border-top: 1px solid #e5eff8;
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
	table.projects tr:nth-child(3n+2) {
		cursor: pointer;
		border-bottom: 1px solid #e5eff8;
	}
	table.projects tr:nth-child(3n+2) td,th {
		background: #f4f9fe;
	}
	table.projects tr:nth-child(3n+0) {
		background: #f9fcfe;
		border-bottom: 1px solid #e5eff8;
	}
	table.projects tr:nth-child(3n+1) {
		border-bottom: 1px solid #888583;
	}
	table.projects tr:nth-child(3n+1) td,th {
		background: #f9fcfe;
	}
	table.projects tr:nth-child(3n+1) td.control {
		background: transparent;
		text-align: right;
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
		$("table.projects tr:nth-child(3n+2)").click(function() {
			document.location = $(this).find("a:first").attr("href");
		});
	});
</script>
</head>
<body>
	<h2>Projects</h2>
	<table class="projects">
		<caption>Projects</caption>
		<tr><td class="control" colspan=2><button onclick="window.location='${projectUrl}'">Add New Project</button></td></tr>
		<c:forEach items="${projects}" var="project">
			<tr><td colspan=2><a href="${projectUrl}?id=${project.id}">${project.name}</a></td></tr>
			<tr><td>Vision</td><td>${project.vision}</td></tr>
			<tr><td>Mission</td><td>${project.mission}</td></tr>
		</c:forEach>
	</table>
	
</body>
</html>
