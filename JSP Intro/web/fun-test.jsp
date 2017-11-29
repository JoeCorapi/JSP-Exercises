<%--
  Created by IntelliJ IDEA.
  User: Ubnik
  Date: 11/29/2017
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Importing multiple packages is just a comma delimitted list -->
<%@ page import="com.ubnik.jsp.FunUtils"%>
<html>
<head>
    <title>Fun-test</title>
</head>
<body>
   Let's have some fun:
   <%=
   //com.ubnik.jsp.FunUtils.makeItlower("I'M HAVING A BLAST")
   FunUtils.makeItlower("I'M HAVING A BLAST")
   %>
</body>
</html>
