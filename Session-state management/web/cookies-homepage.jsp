<%--
  Created by IntelliJ IDEA.
  User: Ubnik
  Date: 11/30/2017
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Language Information Center </title>
</head>
<body>

<%
    String favLang = "Java";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie temp : cookies) {
            if (temp.getName().equals("favLang")) {
                favLang = temp.getValue();
            }
        }
    }
%>

<h1> Training Portal </h1>

<h2>New Books for <%=favLang%> </h2>

<ul>
    <li>Blah Blah Blah</li>
    <li>Blah Blah Blah</li>
</ul>

<h2>Latest News reports for <%=favLang%> </h2>

<ul>
    <li>Blah Blah Blah</li>
    <li>Blah Blah Blah</li>
</ul>

<h2>Hot Jobs for <%=favLang%> </h2>

<ul>
    <li>Blah Blah Blah</li>
    <li>Blah Blah Blah</li>
</ul>

<hr>
<a href="language-selection.html"> Personalize this page </a>
</body>
</html>
