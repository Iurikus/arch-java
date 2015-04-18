<%--
  Created by IntelliJ IDEA.
  User: yuri
  Date: 13.04.2015
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="registration.title"/></title>
    <link rel="stylesheet" href="/resources/css/main.css"/>
</head>
<body>
<form:form commandName="user" method="post">
    <table>
        <tr><th colspan="3"><spring:message code="registration.title"/></th></tr>
        <tr>
            <td colspan="3">&nbsp;</td>
        </tr>
        <tr>
            <td><spring:message code="form.login"/></td>
            <td><form:input path="email"/></td>
            <td><form:errors path="email" cssClass="error"/></td>
        </tr>
        <tr>
            <td><spring:message code="form.password"/></td>
            <td><form:password path="password"/></td>
            <td><form:errors path="password" cssClass="error"/></td>
        </tr>
        <tr>
            <td><spring:message code="registration.password2"/></td>
            <td><form:password path="password2"/></td>
            <td><form:errors path="password2" cssClass="error"/></td>
        </tr>
        <tr>
            <td colspan="3">&nbsp;</td>
        </tr>
        <tr>
            <td><a href="/login.html"><spring:message code="registration.enter"/></a> </td>
            <td><input type="submit" value=<spring:message code="registration.save"/>></td>
        </tr>
    </table>
</form:form>
</body>
</html>
