<%--
  Created by IntelliJ IDEA.
  User: Ubnik
  Date: 11/29/2017
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Scriptlets</title>
</head>
<body>

    <%
        for (int i = 0; i <= 5; i++) {
            out.println("<br/> Practicing scriptlets: " + i);
        }
    %>

</body>
</html>
