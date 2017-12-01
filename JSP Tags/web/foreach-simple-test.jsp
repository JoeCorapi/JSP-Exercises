<%--
  Created by IntelliJ IDEA.
  User: Ubnik
  Date: 12/1/2017
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--Creating placeholder data--%>
<%
    String[] cities = {"Mumbai", "Singapore", "Philadelphia"};

    pageContext.setAttribute("myCities", cities);
%>

<html>
<head>
    <title>Using tags</title>
</head>
<body>
    <c:forEach var="tempCity" items="${myCities}">
        ${tempCity} <br>
    </c:forEach>

</body>
</html>
