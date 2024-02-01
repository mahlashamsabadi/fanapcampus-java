<%--
  Created by IntelliJ IDEA.
  User: ALFA RAYAN
  Date: 2/1/2024
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP_Exercise</title>
</head>
<body>
<%String error_message = (String) request.getAttribute("error_message");%>
<p>"<%=error_message%>"</p>
<a href="showPerson">back</a>
</body>
</html>
