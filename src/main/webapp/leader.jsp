<%@ page import="core.Gamer" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: bobis1888
  Date: 12/1/19
  Time: 1:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Leader Boards</title>
</head>
<body>
<jsp:include page="links.jsp"/>
    <%
        ArrayList<Gamer> gamers = (ArrayList<Gamer>) request.getAttribute("gamers");
        for (Gamer gamer : gamers) {
            out.print("<br>");
            out.print(gamer);
        }
    %>
</body>
</html>
