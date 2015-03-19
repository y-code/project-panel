<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:choose>
	<c:when test="${pageContext.request.userPrincipal.name != null}">
		<c:url var="logoutUrl" value="/j_spring_security_logout" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" 
				name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		
		<script>
			function formSubmitLogout() {
				document.getElementById("logoutForm").submit();
			}
		</script>
	</c:when>
</c:choose>

<ul style="list-style:none;line-height:28px;">

	<li class="first">
		<spring:url value="/welcome" var="welcomeUrl" htmlEscape="true" />
		<a href="${welcomeUrl}">Home</a>
	</li>

	<li>
		<spring:url value="/admin" var="adminUrl" htmlEscape="true" />
		<a href="${adminUrl}">Administration</a>
	</li>

	<li>
		<spring:url value="/devroom" var="devroomUrl" htmlEscape="true" />
		<a href="${devroomUrl}">Developers' Room</a>
	</li>

	<c:choose>
		<c:when test="${pageContext.request.userPrincipal.name != null}">
			<li class="last">
				<a href="javascript:formSubmitLogout()">Log out</a>
			</li>
		</c:when>
		<c:otherwise>
			<c:url var="loginUrl" value="/login" />
			<li class="last">
				<a href="${loginUrl}">Log in</a>
			</li>
		</c:otherwise>
	</c:choose>

</ul>
