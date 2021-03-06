package com.corapi.web.jdbc;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

    //Define datasource/connecetion pool for Resource Injection
    @Resource(name="jdbc/web_student_tracker")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Set up printwriter
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

        //get connection to the database
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;


        try {
            myConn = dataSource.getConnection();

            //create SQL statements
            String sql = "select * from student";
            myStmt = myConn.createStatement();

            //execute sql query
            myRs = myStmt.executeQuery(sql);

            //process the result set
            while(myRs.next()) {
                String email = myRs.getString("email");
                out.println(email);
            }

        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }


    }
}
