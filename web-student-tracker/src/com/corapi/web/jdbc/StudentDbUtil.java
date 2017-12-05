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

        List<Student> students= new ArrayList<>();

        String sql = "select * from student order by last_name";

        try (
                Connection myConnection = dataSource.getConnection();
                Statement myStmt = myConnection.createStatement();
                ResultSet myRs = myStmt.executeQuery(sql);
        ) {
            while(myRs.next()) {

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
                +   "(first_name, last_name, email)"
                + "values (?, ?, ?)";

        try(
                Connection myConnection = dataSource.getConnection();
                PreparedStatement statement = myConnection.prepareStatement(sql);
                ) {

            statement.setString(1,student.getFirstName());
            statement.setString(2,student.getLastName());
            statement.setString(3,student.getEmail());

            statement.execute();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
