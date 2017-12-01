<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: Ubnik
  Date: 11/30/2017
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>


<%
    String favLang = request.getParameter("language") ;
    favLang = URLEncoder.encode(favLang, "UTF-8");

    Cookie cookie = new Cookie("favLang", favLang);
    cookie.setMaxAge(60);
    response.addCookie(cookie);
%>

Thanks! We set your favorite language to:  ${param.language}
<br><br>
<a href="cookies-homepage.jsp">Return to the homepage.</a>

</body>
</html>
