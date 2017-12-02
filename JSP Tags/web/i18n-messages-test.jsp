<%--
  Created by IntelliJ IDEA.
  User: Ubnik
  Date: 12/2/2017
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="theLocale" value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}" scope="session"/>

<fmt:setLocale value="${theLocale}"/>

<fmt:setBundle basename="com.corapi.joe.i18n.resources.mylabels"/>

<html>
<head>
    <title>Welcome to the training Portal</title>
</head>

<body>

<a href="i18n-messages-test.jsp?theLocale=en_US">English (US)</a>
|
<a href="i18n-messages-test.jsp?theLocale=es_ES">Español (ES)</a>
|
<a href="i18n-messages-test.jsp?theLocale=it_IT">Deutsche (DE)</a>
|
<a href="i18n-messages-test.jsp?theLocale=de_DE">Italiano (IT)</a>

<hr>
<br>

<fmt:message key="label.greeting"/> <br> <br>

<fmt:message key="label.firstname"/> Joe <br>

<fmt:message key="label.lastname"/> Corapi <br>

<fmt:message key="label.welcome"/>

</body>

</html>
