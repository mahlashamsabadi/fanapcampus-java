package com.example.session15_jsp.servlet;

import com.example.session15_jsp.model.PersonData;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ShowPersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("people", PersonData.getPeople());
        request.getRequestDispatcher("showPerson.jsp").forward(request,response);
    }

}
