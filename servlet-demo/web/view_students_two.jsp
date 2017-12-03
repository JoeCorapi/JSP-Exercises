<%--
  Created by IntelliJ IDEA.
  User: Ubnik
  Date: 12/3/2017
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Student Directory</title>
</head>

<body>
<h2> Student Table Demo</h2>
<hr>
<br>
<table border="1">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
    </tr>
<c:forEach var="tempStudent" items="${student_list}">
    <tr>
        <td>${tempStudent.firstName}</td>
        <td>${tempStudent.lastName}</td>
        <td>${tempStudent.email}</td>
    </tr>
</c:forEach>
</table>
</body>
