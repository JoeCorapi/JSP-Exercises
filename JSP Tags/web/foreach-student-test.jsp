<%--
  Created by IntelliJ IDEA.
  User: Ubnik
  Date: 12/1/2017
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, com.corapi.joe.tagdemo.Student" %>

<%--Creating sample data--%>
<%
    List<Student> data = new ArrayList<>();

    data.add(new Student("John", "Doe", false));
    data.add(new Student("Maxwell", "Johnson", false));
    data.add(new Student("Mary", "Public", true));

    pageContext.setAttribute("myStudents", data);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th> First Name</th>
        <th> Last Name</th>
        <th> Gold Customer</th>
    </tr>

    <c:forEach var="tempStudent" items="${myStudents}">
        <tr>
            <td>${tempStudent.firstName}</td>
            <td>${tempStudent.lastName}</td>
            <td>${tempStudent.goldCustomer}</td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
