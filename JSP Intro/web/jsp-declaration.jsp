<%--
  Created by IntelliJ IDEA.
  User: Ubnik
  Date: 11/29/2017
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> JSP Declarations </title>
</head>
<body>

<%!
    String makeItLower(String data) {
        return data.toLowerCase();
    }
%>

Lower case "HeLLo WorlD": <%= makeItLower("HeLLo WorlD")%>

</body>
</html>
