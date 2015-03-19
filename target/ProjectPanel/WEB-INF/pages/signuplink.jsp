<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<h2>Sign up</h2>
	<div>
		<spring:url value="/signup" var="signupUrl" htmlEscape="true" />
		If you have not signed up on this site, please <a href="${signupUrl}">sign up here</a>.
	</div>
