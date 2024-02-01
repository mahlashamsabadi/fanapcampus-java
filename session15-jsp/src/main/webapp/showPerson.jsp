<%@ page import="com.example.session15_jsp.model.Person" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ALFA RAYAN
  Date: 1/30/2024
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP_Exercise</title>
</head>
<body>
<h3>People list:</h3>
<table>
    <tr>
        <th>firstname</th>
        <th>lastname</th>
        <th>nationalCode</th>
    </tr>
    <% ArrayList<Person> personList = (ArrayList<Person>) request.getAttribute("people");
        for (Person person: personList) {%>
    <tr>

        <td>
            <input type="text" value="<%=person.getFirstname()%>">
        </td>
        <td>
            <input type="text" value="<%=person.getLastname()%>">
        </td>
        <td>
            <input type="text" value="<%=person.getNationalCode()%>">
        </td>
        <td>
            <a href="<%=application.getContextPath()%>/editPerson?id=<%=person.getId()%>">edit</a>
        </td>
        <td>
            <a href="<%=application.getContextPath()%>/deletePerson?id=<%=person.getId()%>">delete</a>
            <%}%>
        </td>
    </tr>
</table>
<a href="submit.jsp">sign up</a>
</body>
</html>
