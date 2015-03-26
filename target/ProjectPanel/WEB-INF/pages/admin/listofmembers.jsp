<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="memberUrl" value="/admin/member" />
<spring:url var="jqueryUrl" value="/resources/js/jquery-2.1.3.min.js" htmlEscape="true" />
<spring:url var="jqueryUiCssUrl" value="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
<spring:url var="jqueryUiJsUrl" value="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js" />

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${jqueryUiCssUrl}" media="screen, projection" />
	<style>
		#members {
			width: 90%;
			border-top: 1px solid #e5eff8;
			border-right: 1px solid #e5eff8;
			margin: 1em auto;
			border-collapse: collapse;
		}
		#members table {
			width: 100%;
		}
		#members td {
			width: 100%;
			color: #678197;
			border-left: 1px solid #e5eff8;
			padding: .3em 1em;
			text-align: left;
		}
		#members tr {
			cursor: pointer;
			border-bottom: 1px solid #888583;
			background: #f9fcfe;
		}
		#members tr td.control {
			background: transparent;
			text-align: right;
		}
		#members th {
			background: #ffffff;
			border-bottom: 1px solid #e5eff8;
			border-left: 1px solid #e5eff8;
			padding: .3em 1em;
			text-align: left;
		}
	</style>
	<script type="text/javascript" src="${jqueryUrl}"></script>
	<script type="text/javascript" src="${jqueryUiJsUrl}"></script>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#members tr:not(:first-child)").click(function() {
				document.location = $(this).find("a:first").attr("href");
			});
		});
		
		var openDialog = function(memberId) {
			$("#member").dialog({
				autoOpen: false,
				resizable: false,
				width: "90%",
				modal: true,
				show: {
					effect: "blind",
					duration: 1000
				},
				hide: {
					effect: "blind",
					duration: 1000
				}
			});
			$("#member").dialog("open");
			
			var url = "${memberUrl}";
			if (memberId >= 0)
				url += "?id=" + memberId;
			else
				url += "?projectid=${project.id}";
			
			$.get(url, function(data) {
				$("#member").html($(data).find("#member").html());
				$.globalEval($(data).find("script").text());
				$("#member form").submit(function(event) {
					// It is required to customize the serialized form values
					// because jQuery.serialize method does not include 'submit' type of INPUT tag.
					var data = $(this).serialize();
					var $submitInput = $(this).find("input[type='submit']");
					data += "&" + $submitInput.attr("name") + "=" + $submitInput.val();
					
					event.preventDefault();
					$.ajax({
						type: "POST",
						url: $(this).attr("action"),
						data: data
					})
						.success(function(data) {
							$.get("${listOfmembersUrl}?id=${project.id}", function(data) {
								$("#members").html($(data).find("#members").html());
								$.globalEval($(data).find("script").text());
							});
							$('#member').dialog("close");
						})
						.fail(function(event) {
							var str;
							for (e in event)
								str = e + " : " + event[e] + "\n";
							$("#member").html(str).css("color", "red");
						});
				});
			});
		};
	</script>
	<h2>members for ${project.name}</h2>
	<div id="members">
		<table>
			<caption>members</caption>
			<tr><td class="control" colspan=2><button onclick="javascript: openDialog(-1);">Add New member</button></td></tr>
			<c:forEach items="${project.members}" var="member">
				<tr>
					<td><a href="javascript: openDialog(${member.id});">${member.member}</a></td>
				</tr>
			</c:forEach>
		</table>
	
		<div id="member" style="width: 100%;"></div>
		
	</div>
	
</body>
</html>
