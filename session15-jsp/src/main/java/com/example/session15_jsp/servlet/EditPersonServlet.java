package com.example.session15_jsp.servlet;

import com.example.session15_jsp.exception.PersonValidationException;
import com.example.session15_jsp.model.Person;
import com.example.session15_jsp.model.PersonData;
import com.example.session15_jsp.exception.PersonNotFoundException;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EditPersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int editedPersonId = Integer.parseInt(request.getParameter("id"));
        Person editedPerson = null;
        try {
            editedPerson = PersonData.findByID(editedPersonId);
            request.setAttribute("person", editedPerson);
            request.getRequestDispatcher("/editPerson.jsp").forward(request, response);
        } catch (PersonNotFoundException e) {
            request.setAttribute("error_message", "edition failed because " +e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int personId = Integer.parseInt(request.getParameter("personId"));
        Person person = null;
        try {
            person = PersonData.findByID(personId);
            person.setFirstname(request.getParameter("firstname"));
            person.setLastname(request.getParameter("lastname"));
            person.setNationalCode(request.getParameter("nationalCode"));
            response.sendRedirect("showPerson");
        } catch (PersonValidationException | PersonNotFoundException e) {
            request.setAttribute("error_message", "edition failed because "+ e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }


    }
}

