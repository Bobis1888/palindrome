<%@ page import="java.util.ArrayList" %>
<%@ page import="core.Gamer" %>
<html>
<body>
<h2>Hello Gamer!</h2>
<jsp:include page="links.jsp"/>
<form action="/game">
    Palindrome: <input type="text" name="palindrome">
    <input type="submit" value="go">
    Points :
    <%
        out.print(request.getAttribute("points"));
    %>
</form>
</body>
</html>
