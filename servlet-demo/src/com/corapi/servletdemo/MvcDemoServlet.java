package com.corapi.servletdemo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MvcDemoServlet", urlPatterns = "/MvcDemoServlet")
public class MvcDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Step 0: Add Data
        String[] students = {"Susan", "Joe", "John", "Chad"};
        request.setAttribute("student_list", students);

        //Step 1: Add request dispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view_students.jsp");

        //Step 3: Forward request to JSP
        dispatcher.forward(request, response);

    }
}
