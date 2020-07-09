package com.students.deserializer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.student.Student;

public class StudentDeserializer {
    final static String filename = "output.out";
    private static List<Student> studentArrayList;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        studentArrayList = new ArrayList<Student>();

        try {
            int counter = 1;
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            // casts the returned Object from readobject method to Student ArrayList.
            // It loops until there is no more Students left.
            while ((studentArrayList = (ArrayList<Student>) in.readObject()) != null) {
                for (Student student : studentArrayList) {
                    System.out.println(counter + ". Student");
                    System.out.println("~~~~~~~~~~~~~~~~~~");
                    System.out.println(" Student ID: " + student.getStdId());
                    System.out.println(" First Name: " + student.getFirstName());
                    System.out.println(" Last Name: " + student.getLastName());
                    System.out.println(" Courses: " + student.getCourses());
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    counter++;
                }
            }
            in.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }

}