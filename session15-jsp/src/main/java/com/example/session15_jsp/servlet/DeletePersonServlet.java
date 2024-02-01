package com.example.session15_jsp.servlet;

import com.example.session15_jsp.model.Person;
import com.example.session15_jsp.model.PersonData;
import com.example.session15_jsp.exception.PersonNotFoundException;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeletePersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int personToBeDeletedId = Integer.parseInt(request.getParameter("id"));
        Person personToBeDeleted=null;
        try {
            personToBeDeleted = PersonData.findByID(personToBeDeletedId);
            PersonData.getPeople().remove(personToBeDeleted);
            response.sendRedirect("showPerson");

        } catch (PersonNotFoundException e) {
            request.setAttribute("error_message", "deletion failed because " +e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }

    }
}
