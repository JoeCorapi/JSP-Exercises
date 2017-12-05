package com.corapi.web.jdbc;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentControllerServlet", urlPatterns = "/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {

    private StudentDbUtil studentDbUtil;

    @Resource(name = "jdbc/web_student_tracker")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        // create out student db util and pass in the conn pool / datasource
        try {
            studentDbUtil = new StudentDbUtil(dataSource);
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //read the "command" parameter
            String theCommand = request.getParameter("command");

            if (theCommand == null) {
                theCommand = "LIST";
            }

            // route to the appropriate method
            switch (theCommand) {

                case "LIST":
                    listStudents(request, response);
                    break;

                case "ADD":
                    addStudent(request, response);
                    break;

                case "LOAD":
                    loadStudent(request, response);
                    break;

                case "UPDATE":
                    updateStudent(request, response);
                    break;

                case "DELETE":
                    deleteStudent(request, response);
                    break;

                default:
                    listStudents(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{

        int id = Integer.parseInt(request.getParameter("studentId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        Student theStudent = new Student(id, firstName, lastName, email);

        studentDbUtil.updateStudent(theStudent);

        listStudents(request,response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{

        studentDbUtil.deleteStudent(request.getParameter("studentId"));

        listStudents(request,response);
    }

    private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String studentId = request.getParameter("studentId");

        Student student = studentDbUtil.getStudent(studentId);

        request.setAttribute("THE_STUDENT", student);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //read student form data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        // create new Student
        Student student = new Student(firstName, lastName, email);

        // add student to the DB
        studentDbUtil.addStudent(student);

        //return to the index
        listStudents(request, response);
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // get students form db util
        List<Student> students = studentDbUtil.getStudents();

        // add students to the request
        request.setAttribute("STUDENT_LIST", students);

        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(request, response);

    }
}
