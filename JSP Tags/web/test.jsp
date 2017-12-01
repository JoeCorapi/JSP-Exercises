<%--
  Created by IntelliJ IDEA.
  User: Ubnik
  Date: 12/1/2017
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title> Testing JSTL Libs</title>
</head>
<body>

<c:set var="stuff" value="<%= new java.util.Date() %>"/>
Time on the server is ${stuff}

</body>
</html>
