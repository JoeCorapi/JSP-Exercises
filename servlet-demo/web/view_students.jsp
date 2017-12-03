<%--
  Created by IntelliJ IDEA.
  User: Ubnik
  Date: 12/3/2017
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Student Directory</title>
</head>

<body>
    <c:forEach var="tempStudent" items="${student_list}">
        ${tempStudent}<br>
    </c:forEach>
</body>
</html>
