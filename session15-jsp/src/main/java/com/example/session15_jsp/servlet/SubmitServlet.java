package com.example.session15_jsp.servlet;

import com.example.session15_jsp.exception.PersonValidationException;
import com.example.session15_jsp.model.Person;
import com.example.session15_jsp.model.PersonData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SubmitServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String nationalCode = req.getParameter("nationalCode");
        Person person = null;
        try {
            person = new Person(firstname,lastname,nationalCode);
            PersonData.getPeople().add(person);
            resp.sendRedirect("showPerson");
        } catch (PersonValidationException e) {
            req.setAttribute("error_message","submission failed because "+e.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }

    }
}
