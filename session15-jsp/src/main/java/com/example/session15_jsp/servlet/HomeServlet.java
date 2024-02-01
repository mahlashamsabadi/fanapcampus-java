package com.example.session15_jsp.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("showPerson");
    }
}