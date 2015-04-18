<%--
  Created by IntelliJ IDEA.
  User: yuri
  Date: 18.04.2015
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="login.title"/></title>
    <link rel="stylesheet" href="/resources/css/main.css"/>
</head>
<body>
    <form:form commandName="user" method="post">

        <table>
            <tr>
                <th colspan="4">
                    <spring:message code="login.messageWelcome"/>
                </th>
            </tr>
            <tr>
                <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
                <th colspan="4">
                    <spring:message code="login.messageStart"/>
                </th>
            </tr>
            <tr>
                <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
                <td><spring:message code="form.login"/></td>
                <td colspan="2"><form:input path="email"/></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
            <tr>
                <td><spring:message code="form.password"/></td>
                <td colspan="2"><form:password path="password"/></td>
                <td><form:errors path="password" cssClass="error"/></td>
            </tr>
            <tr>
                <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2"><a href="/registration.html"><spring:message code="login.linkRegistration"/></a></td>
                <td><input type="submit" value=<spring:message code="login.enter"/>></td>
            </tr>
        </table>

    </form:form>
</body>
</html>
