<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 17.02.2019
  Time: 0:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Why are you here?</title>
</head>
<body>
<center>
    <%
        String msg= request.getParameter("msg");
    %>
    <%=msg%>
</center>
</body>
</html>
