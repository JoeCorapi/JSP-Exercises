<%--
  Created by IntelliJ IDEA.
  User: Ubnik
  Date: 12/1/2017
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
    <title>testing function tags</title>
</head>

<body>

    <c:set var="data" value="tagsAreFun"/>

    Length of the string <b>${data}</b>: ${fn:length(data)}
    <br><br>
    Uppercase version of the string <b>${data}</b>: ${fn:toUpperCase(data)}
    <br><br>
    The string <b>${data}</b> starts with <b>tag</b>? ${fn:startsWith(data,"tag")}

</body>

</html>
