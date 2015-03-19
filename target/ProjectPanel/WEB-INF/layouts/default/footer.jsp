<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<html>
<body>
	<c:choose>
		<c:when test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name}
			</h2>
		</c:when>
	</c:choose>

	<p/>
	<h2>
		<a href="http://nz.linkedin.com/in/yasuikeda/en">&copy; 2015 Yas Ikeda</a>
	</h2>
</body>
</html>
