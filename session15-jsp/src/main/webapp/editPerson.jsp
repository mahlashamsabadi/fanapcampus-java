<%@ page import="com.example.session15_jsp.model.Person" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ALFA RAYAN
  Date: 2/1/2024
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP_Exercise</title>
</head>
<body>
<form name="form1" method="post", action="editPerson" target="_blank">
    <% Person person= (Person) request.getAttribute("person");%>
    firstname <input type="text" name="firstname" value="<%=person.getFirstname()%>"><br><br>
    lastname <input type="text" name="lastname"  value="<%=person.getLastname()%>"><br><br>
    nationalCode <input type="text" name="nationalCode" value="<%=person.getNationalCode()%>"><br><br>
    <input type="hidden" value="<%=person.getId()%>" name="personId"/>
    <input type = "submit" value = "update person" />
</form>

</body>
</html>
