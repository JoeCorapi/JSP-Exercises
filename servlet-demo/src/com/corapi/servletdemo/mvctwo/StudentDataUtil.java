package com.corapi.servletdemo.mvctwo;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {

        public static List<Student> getStudents() {

            //create empty list
            List<Student> students = new ArrayList<>();

            //add sample data
            students.add(new Student("Mary", "Do", "mary@gmail.com"));
            students.add(new Student("Joe", "Corapi", "joe@gmail.com"));
            students.add(new Student("John", "Doe", "john@gmail.com"));

            //return the list
            return students;
        }
}
