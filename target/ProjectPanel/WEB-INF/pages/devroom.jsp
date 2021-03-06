<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="gitHubImgUrl" value="/resources/image/GitHub-Mark-Light-120px-plus.png" htmlEscape="true" />
<spring:url var="jqueryUrl" value="/resources/js/jquery-2.1.3.min.js" htmlEscape="true" />
<spring:url var="jqueryUiCssUrl" value="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
<spring:url var="jqueryUiJsUrl" value="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js" />

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${jqueryUiCssUrl}" media="screen, projection" />
	<style>
		table.properties {
			width: 90%;
			border-top: 1px solid #888583;
			border-right: 1px solid #e5eff8;
			margin: 1em auto;
			border-collapse: collapse;
		}
		table.properties td {
			color: #678197;
			border-bottom: 1px solid #e5eff8;
			border-left: 1px solid #e5eff8;
			padding: .3em 1em;
			text-align: left;
		}
		table.properties td.last-child {
			border-bottom: 1px solid #888583;
		}
		table.properties tr:nth-child(odd) {
			background: #f4f9fe;
		}
		table.properties tr:nth-child(even) {
			background: #f9fcfe;
		}
		table.properties th {
			background: #ffffff;
			border-bottom: 1px solid #888583;
			border-left: 1px solid #e5eff8;
			padding: .3em 1em;
			text-align: left;
		}
		
		h3 {
		  font-size: 1.2em;
		  text-transform: lowercase;
		  text-align: center;
		  margin: 0.75em 0 1em;
		}
	</style>
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
	<script type="text/javascript" src="${jqueryUrl}"></script>
	<script type="text/javascript" src="${jqueryUiJsUrl}"></script>
</head>
<body>
	<script type="text/javascript">
	//<![CDATA[
	$(document).ready(function() {
		$.get("/projectpanel?id=3", function(data) {
				$("#planning").html($(data).find("#projectpanel").html());
				$.globalEval($(data).find("script").text());
				$("#planning h2").each(function(i) {
					$(this).replaceWith("<h3>" + $(this).html() + "</h3>");
				});
			});
	});
	//]]>
	</script>
	<h2>What is Developers' Room</h2>
	<div>
	This site has been developed basically in order to prove the skills of the developers who have developed this web site. This section will describe how this web site was developed.
	</div>
	
		<h2>Developers</h2>
		<p>
			<table class="properties">
				<tr>
					<td class="last-child">Yasunori Ikeda</td>
					<td class="last-child"><a href="http://nz.linkedin.com/in/yasuikeda/en">Linked in</a></td>
				</tr>
			</table>
		</p>
	
		<h2>Software Development Environment</h2>
		<div>
			<table class="properties">
				<tr>
					<th colspan=2>Computer Language</th>
					<td class="last-child">Java</td>
					<td class="last-child">8</td>
				</tr>
				<tr>
					<th colspan=2>Server Environment</th>
					<td class="last-child">Heroku</td>
					<td class="last-child"></td>
				</tr>
				<tr>
					<th colspan=2>Application Server</th>
					<td class="last-child">Jetty</td>
					<td class="last-child">9.3.0</td>
				</tr>
				<tr>
					<th colspan=2>Database</th>
					<td class="last-child">Postgre SQL</td>
					<td class="last-child">9.3.6</td>
				</tr>
				<tr>
					<th rowspan=11 width=100>Frameworks</th>
					<th rowspan=8 width=100>Application</th>
					<td>Spring MVC</td>
					<td>4.1.5</td>
				</tr>
				<tr>
					<td>Apache Tiles</td>
					<td>3.0.5</td>
				</tr>
				<tr>
					<td>Spring Securit</td>
					<td>3.2.6</td>
				</tr>
				<tr>
					<td>Spring ORM</td>
					<td>4.1.5</td>
				</tr>
				<tr>
					<td>Hibernate</td>
					<td>4.3.8</td>
				</tr>
				<tr>
					<td>jQuery</td>
					<td>2.1.3</td>
				</tr>
				<tr>
					<td>jQuery UI</td>
					<td>1.11.3</td>
				</tr>
				<tr>
					<td class="last-child">CSS3</td>
					<td class="last-child"> </td>
				</tr>
				<tr>
					<th rowspan=3>Testing</th>
					<td>JUnit</td>
					<td>4.1.5</td>
				</tr>
				<tr>
					<td>Cucumber</td>
					<td>1.2.2</td>
				</tr>
				<tr>
					<td class="last-child">Selenium</td>
					<td class="last-child">2.45.0</td>
				</tr>
			
				<tr>
					<th colspan=2>IDE</th>
					<td class="last-child">Eclipse Luna</td>
					<td class="last-child">4.4.1</td>
				</tr>
				<tr>
					<th colspan=2>Build Tool</th>
					<td class="last-child">Maven</td>
					<td class="last-child">3.2.5</td>
				</tr>
			</table>
		</p>
	
		<h2>Source Code</h2>
		<p>
			The source code of this web application is open at GitHub. Please visit <a href="https://github.com/y-code/project-panel">this repository</a>.
		</p>
		<p style="text-align: center">
			<a href="https://github.com/y-code/project-panel"><img src="${gitHubImgUrl}"/></a>
		</p>
		
		<h2>Project Planning</h2>
		<div id="planning"/>
</div>
