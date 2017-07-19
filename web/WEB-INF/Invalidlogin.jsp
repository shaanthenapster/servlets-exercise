<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: shaan
  Date: 4/7/17
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        response.setContentType("text/html");
        request.getRequestDispatcher("LoginRegister.html").include(request, response);
        session.invalidate();
        out.print("Invalid user");
        out.close();
    %>
</head>
<body>

</body>
</html>
