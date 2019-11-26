<html>
<body>
<h2>Hello Gamer!</h2>
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
