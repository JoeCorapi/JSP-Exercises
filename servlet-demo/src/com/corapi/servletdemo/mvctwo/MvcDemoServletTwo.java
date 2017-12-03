package com.corapi.servletdemo.mvctwo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MvcDemoServletTwo", urlPatterns = "/MvcDemoServletTwo")
public class MvcDemoServletTwo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1: Get the student data from the helper class (model)
        List<Student> students = StudentDataUtil.getStudents();

        //2: add students to request object
        request.setAttribute("student_list", students);

        //3: get request dispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_students_two.jsp");

        //4: forward to JSP
        dispatcher.forward(request, response);



    }
}
