<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="goalUrl" value="/admin/goal" />

<html>
<head>
<style>
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
<script type="text/javascript">
	$(document).ready(function() {
		$("table#goals tr:not(:first-child)").click(function() {
			document.location = $(this).find("a:first").attr("href");
		});
	});
</script>
</head>
<body>
	<h2>Goals for ${project.name}</h2>
	<table id="goals">
		<caption>Goals</caption>
		<tr><td class="control" colspan=2><button onclick="javascript: window.location='${goalUrl}?projectid=${project.id}'">Add New Goal</button></td></tr>
		<c:forEach items="${project.goals}" var="goal">
			<tr>
				<td><a href="${goalUrl}?id=${goal.id}">${goal.goal}</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>
