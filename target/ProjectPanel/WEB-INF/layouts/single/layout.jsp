<!-- Inspired from http://alistapart.com/d/responsive-web-design/ex/ex-site-FINAL.html -->
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<spring:url var="layoutCssUrl" value="/resources/css/layout-default.css" htmlEscape="true" />
<spring:url var="jqueryUrl" value="/resources/js/jquery-2.1.3.min.js" htmlEscape="true" />

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Project Panel</title>
	<link type="text/css" rel="stylesheet" href="${layoutCssUrl}" media="screen, projection" />
	<script src="${jqueryUrl}"></script>
</head>
<body>
	<div id="page">
		<div class="inner">
			<div class="section main">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
</body>
</html>
