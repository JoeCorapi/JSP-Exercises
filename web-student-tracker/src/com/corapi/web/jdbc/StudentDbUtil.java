package com.corapi.web.jdbc;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDbUtil {

    private DataSource dataSource;

    public StudentDbUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<Student> getStudents() throws Exception {

        List<Student> students = new ArrayList<>();

        String sql = "select * from student order by last_name";

        try (
                Connection myConnection = dataSource.getConnection();
                Statement myStmt = myConnection.createStatement();
                ResultSet myRs = myStmt.executeQuery(sql);
        ) {
            while (myRs.next()) {

                //retrieve data from result set row using column label or index
                int id = myRs.getInt("id");
                String firstName = myRs.getString("first_name");
                String lastName = myRs.getString("last_name");
                String email = myRs.getString("email");

                //create student object
                Student tempStudent = new Student(id, firstName, lastName, email);

                //add to list
                students.add(tempStudent);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return students;
    }

    public void addStudent(Student student) throws Exception {

        String sql = "INSERT INTO student "
                + "(first_name, last_name, email)"
                + "values (?, ?, ?)";

        try (
                Connection myConnection = dataSource.getConnection();
                PreparedStatement statement = myConnection.prepareStatement(sql);
        ) {

            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getEmail());

            statement.execute();
        }
    }

    public Student getStudent(String studentID) throws Exception {

        Student student = null;
        int theID = Integer.parseInt(studentID);
        String sql = "SELECT * FROM student WHERE id=?";

        ResultSet myRs = null;
        try (
                Connection myConnection = dataSource.getConnection();
                PreparedStatement statement = myConnection.prepareStatement(sql);
        ) {

            statement.setInt(1, theID);
            myRs = statement.executeQuery();

            if (myRs.next()) {
                String firstName = myRs.getString("first_name");
                String lastName = myRs.getString("last_name");
                String email = myRs.getString("email");

                student = new Student(theID, firstName, lastName, email);
            } else {
                throw new Exception("Could not find student id: " + theID);
            }

        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }

        return student;
    }

    public void updateStudent(Student theStudent) throws Exception {
        String sql = "UPDATE student "
                + "SET first_name=?, last_name=?, email=? "
                + " WHERE id =?";

        try (
                Connection myConnection = dataSource.getConnection();
                PreparedStatement statement = myConnection.prepareStatement(sql);
        ) {
            statement.setString(1, theStudent.getFirstName());
            statement.setString(2, theStudent.getLastName());
            statement.setString(3, theStudent.getEmail());
            statement.setInt(4, theStudent.getId());

            statement.execute();
        }
    }

    public void deleteStudent(String studentId) throws Exception {
        String sql = "DELETE FROM student WHERE id =?";
        int ID = Integer.parseInt(studentId);

        try (
                Connection myConnection = dataSource.getConnection();
                PreparedStatement statement = myConnection.prepareStatement(sql);
        ) {
            statement.setInt(1, ID);
            statement.execute();
        }
    }
}
