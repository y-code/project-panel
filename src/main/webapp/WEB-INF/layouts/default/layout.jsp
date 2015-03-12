<!-- Inspired from http://alistapart.com/d/responsive-web-design/ex/ex-site-FINAL.html -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Project Panel</title>
	<spring:url value="/resources/css/layout-default.css" var="layoutCssUrl" htmlEscape="true" />
	<link type="text/css" rel="stylesheet" href="${layoutCssUrl}" media="screen, projection">
</head>
<body>
	<div id="page">
		<div class="inner">
			<div class="mast">
				<div id="logo">
					<tiles:insertAttribute name="header" />
				</div>
				<div class="nav">
					<tiles:insertAttribute name="menu" />
				</div>
			</div>
			<div class="section intro">
				This is an intro.
			</div>
			<div class="section main">
				<tiles:insertAttribute name="body" />
			</div>
			<div class="footer">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
	</div>
</body>
</html>
