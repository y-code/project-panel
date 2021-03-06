<!-- Inspired from http://alistapart.com/d/responsive-web-design/ex/ex-site-FINAL.html -->
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<spring:url var="layoutCssUrl" value="/resources/css/layout-default.css" />
<spring:url var="jqueryUrl" value="/resources/js/jquery-2.1.3.min.js" />
<spring:url var="jqueryUiCssUrl" value="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
<spring:url var="jqueryUiJsUrl" value="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js" />

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Project Panel</title>
	<link type="text/css" rel="stylesheet" href="${layoutCssUrl}" media="screen, projection" />
	<link type="text/css" rel="stylesheet" href="${jqueryUiCssUrl}" media="screen, projection" />
	<script type="text/javascript" src="${jqueryUrl}"></script>
	<script type="text/javascript" src="${jqueryUiJsUrl}"></script>
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
			<div class="section toolbar">
				<c:choose>
					<c:when test="${pageContext.request.userPrincipal.name != null}">
						<h2>User : ${pageContext.request.userPrincipal.name}</h2>
					</c:when>
				</c:choose>
			</div>
			<div class="section main">
				<tiles:insertAttribute name="body" />
			</div>
			<div class="section main">
				<tiles:insertAttribute name="body2" />
			</div>
			<div class="footer">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
	</div>
</body>
</html>
