<%--
  Created by IntelliJ IDEA.
  User: Ubnik
  Date: 11/29/2017
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>testing built in objects</title>
</head>

<body>

<h3> JSP Built-In Objects</h3>

Request user agent: <%= request.getHeader("User-Agent")%>

<br><br>

Request language: <%= request.getLocale()%>
</body>

</html>
