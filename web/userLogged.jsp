<%--
  Created by IntelliJ IDEA.
  User: shaan
  Date: 29/6/17
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="Servlets.Bean" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="Servlets.DbClass" %>
<%@ page import="Servlets.Crud" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title> User Logged Successfully </title>
</head>
<body>
<div style="background-color: aqua;height: 50px">
   BLOG
    <a href="/logout" class="btn pull-right">Logout</a>
</div>
   <form action="/blog" method="post">
       <textarea rows="2" cols="20" name="blog" style="resize: none">
</textarea>
    <input type="submit">
<table border="1" width="90%">
    <tr><th>BLOG ID</th><th> BLOG</th></tr>
<%
try{
    ResultSet rs = null;
            Connection con = DbClass.conn();
            Integer uid = (Integer) request.getSession().getAttribute("uid");
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM blogtable WHERE uid = ? ");
            pstm.setInt(1, uid);
            rs = pstm.executeQuery();

            while (rs.next()) {
                %>
            <tr>
    <td>
       <%=rs.getInt(1)%>
    </td>
    <td>
        <%=rs.getString(2)%>
    </td>
</tr>
    <%
        }
        }
            catch(Exception e){
                e.printStackTrace();
            }
%>
    </table>
</form>
</body>
</html>
