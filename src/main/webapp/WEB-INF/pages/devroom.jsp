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
	
	<p>
	This website has been developed basically in order to prove the skills of the software engineers who have developed this web site.
	This section will detail the development of this web application.
	</p>
	
	<h2>Contents</h2>
	<div>
		<ul style="text-align: center; list-style: none;">
			<li><a href="#developers">Developers</a></li>
			<li><a href="#dev-environment">Software Development Environment</a></li>
			<li><a href="#src-code">Source Code</a></li>
			<li><a href="#project-planning">Project Planning</a></li>
			<li><a href="#req-analysis">Requirements Analysis</a></li>
			<li><a href="#"></a></li>
		</ul>
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

	<a id="dev-environment"></a>
	<h2>Software Development Environment</h2>
	<p>
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

	<a id="src-code"></a>
	<h2>Source Code</h2>
	<p>
		The source code of this web application is open at GitHub. Please visit <a href="https://github.com/y-code/project-panel">this repository</a>.
	</p>
	<p style="text-align: center">
		<a href="https://github.com/y-code/project-panel"><img src="${gitHubImgUrl}"/></a>
	</p>
	
	<a id="project-planning"></a>
	<h2>Project Planning</h2>
	<div id="planning"></div>
	
	<a id="req-analysis"></a>
	<h2>Requirements Analysis</h2>
	<p>
		As a first step of the requirements analysis, I used <i>User Story</i>, which is one of Agile practices.
		The following user stories are categorized according to the goals in Project Planning above. 
	</p>
	<div id="user-stories">
		<h3>Project Planning</h3>
		<ol>
			<li>As a user, I want to tart a project. After this, the user will be a project owner as well as being a project member.</li>
			<li>As a project owner, I want to finalize a project.</li>
			<li>As a project owner, I want to clarify the purpose of the project, which means view and mission of the project.</li>
			<li>As a project owner, I want to set up the goals for it.</li>
			<li>As a project owner, I want to consider strategies for each goal.</li>
			<li>As a project owner, I want to identify action plans for each strategy.</li>
		</ol>
		<h3>Team Management</h3>
		<ol>
			<li>As a project owner, I want to invite someone to my project in order to organize a project team. If the invited person accept it, he will be a project member.</li>
			<li>As a project member, I want to recommend the project manager to invite someone to our project.</li>
			<li>As a project owner, I want to assign a project member to a project manager.</li>
			<li>As a user interested in a project, I want to ask the project owner to participate in it. If the project owner accept the request, he will be a project member of the project.</li>
			<li>As a project owner, I want to make a discussion online among project members.</li>
			<li>As a project owner, I want to notify about a new discussion to each project member.</li>
			<li>As a project member, I want to raise a draft discussion topic, which will be discussed once the project owner adopt it.</li>
			<li>As a project owner, I want to adopt or reject a draft discussion topic raised from the project members.</li>
			<li>As a user, I want to have a page to promote myself.</li>
		</ol>
		<h3>Presentation</h3>
		<ol>
			<li>As a project owner, I want to have a page to promote the project in order to collect supports.</li>
			<li>As a project owner, I want to choose a presentation template for the promotion page.</li>
			<li>As a project manager, I want to have a page to report the project progress to encourage the project members.</li>
		</ol>
		<h3>Task Management</h3>
		<ol>
			<li>As a project manager, I want to create a product backlog item.</li>
			<li>As a project manager, I want to prioritize the items in the project backlog.</li>
			<li>As a project manager, I want to define project backlog items for a sprint. They will be sprint backlog items.</li>
			<li>As a project manager, I want to discuss about the items included in a sprint before the sprint starts.</li>
			<li>As a project manager, I want to start a sprint.</li>
			<li>As a project manager, I want to finalize a sprint.</li>
			<li>As a project member, I want to refer the state of each project member.</li>
			<li>As a project member, I want to leave messages for a sprint backlog items, which are shared among the project members.</li>
			<li>As a project manager, I want to discuss about a finalized sprint among the project members.</li>
		</ol>
		<h3>Business Concern</h3>
		<ol>
			<li>As a user, I want to be able to upgrade my account in this website by paying quarterly charge for the services. After the upgrade, a user will be a premium user.</li>
			<li>As a premium user, I want to pay the charge on the website online.</li>
			<li>As a user, the number of project I can make is limited to 2.</li>
			<li>As a user, the number of project member in a project is limited to 3.</li>
			<li>As a user, the number of product backlog item in a project is limited to 20.</li>
			<li>As a user, the number of discussion in a project is limited to 3.</li>
			<li>As a user, I can have any users as project member in owning projects.</li>
			<li>As a user, I cannot choose a presentation template for an owning project.</li>
			<li>As a premium user, the number of project I can make is limited to 10.</li>
			<li>As a premium user, the number of project member in a project is not limited.</li>
			<li>As a premium user, the number of product backlog item in a project is not limited.</li>
			<li>As a premium user, the number of discussion in a project is not limited.</li>
			<li>As a premium user, I can only have premium users as project member in owning projects.</li>
			<li>As a premium user, I can choose a presentation template for an owning project from a variety of selections.</li>
		</ol>
	</div>
	
</body>
</html>
