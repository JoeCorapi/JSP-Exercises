<%--
  Created by IntelliJ IDEA.
  User: Ubnik
  Date: 11/30/2017
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>

<html>

<body>

<%-- Create HTML form--%>
<form action="todo-demo.jsp">
    Add new item: <input type="text" name="theItem">

    <input type="submit" value="Submit">
</form>

<%-- Add new item(s) to the "To Do" list --%>

<%
    List<String> items = (List<String>) session.getAttribute("myToDoList");

    if (items == null) {
        items = new ArrayList<>();
        session.setAttribute("myToDoList", items);
    }

    String theItem = request.getParameter("theItem");
    if (theItem != null && !theItem.trim().equals("")) {
        items.add(theItem);
    }
 %>
<hr>
<b>To Do List Items:</b> <br>
<ol>
<%
    for (String temp: items) {
        out.println("<li>" + temp + "</li>");
    }
%>
</ol>
</body>
</html>
