<%--
  Created by IntelliJ IDEA.
  User: yuri
  Date: 18.04.2015
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="balance.title"/></title>
    <link rel="stylesheet" href="/resources/css/main.css"/>
</head>
<body>
<spring:message code="balance.messageCurrent"/><br/>
<c:out value="${balance.amount}" /><br/>
<a href="/logout.html"><spring:message code="form.exit"/></a>
</body>
</html>
