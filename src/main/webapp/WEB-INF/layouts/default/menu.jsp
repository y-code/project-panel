<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<ul style="list-style:none;line-height:28px;">
 
    <li class="first">
    <spring:url value="/welcome" var="welcomeUrl" htmlEscape="true" />
        <a href="${welcomeUrl}">Home</a>
    </li>
 
    <li>
    <spring:url value="/admin" var="adminUrl" htmlEscape="true" />
        <a href="${adminUrl}">Administration</a>
    </li>
 
    <li class="last">
    <spring:url value="/devroom" var="devroomUrl" htmlEscape="true" />
        <a href="${devroomUrl}">Developers' Room</a>
    </li>
 
</ul>
