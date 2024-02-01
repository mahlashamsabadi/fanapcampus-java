<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: ALFA RAYAN
  Date: 1/30/2024
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP_Exercise</title>
</head>
<body>

<form name="form1" method="post", action="submitServlet" target="_blank">
    firstname <input type="text" name="firstname"><br><br>
    lastname <input type="text" name="lastname"><br><br>
    nationalCode <input type="text" name="nationalCode"><br><br>
    <input type = "submit" value = "Submit" />
</form>
</body>
</html>
