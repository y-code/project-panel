<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2>Sign up</h2>
<form:form modelAttribute="user" action="signup" method="post">
<table>
	<tr>
		<td>User Name</td>
		<td><form:input path="name" size="20" maxlength="256" /><form:errors path="name" cssClass="errors"/></td>
	<tr>
	<tr>
		<td>Password</td>
		<td><form:input path="password" size="20" maxlength="256" /><form:errors path="password" cssClass="errors"/></td>
	<tr>
	<tr>
		<td>Email Address</td>
		<td><form:input path="email" size="20" maxlength="256" /><form:errors path="email" cssClass="errors"/></td>
	<tr>
	<tr>
		<td>First Name</td>
		<td><form:input path="firstName" size="20" maxlength="256" /><form:errors path="firstName" cssClass="errors"/></td>
	<tr>
	<tr>
		<td>Last Name</td>
		<td><form:input path="lastName" size="20" maxlength="256" /><form:errors path="lastName" cssClass="errors"/></td>
	<tr>
	<tr>
		<td colspan=2><input name="signup" type="submit" onclick="return confirm('Are you sure you want to sign up in this site?')"/></td>
	<tr>
</table>
</form:form>
