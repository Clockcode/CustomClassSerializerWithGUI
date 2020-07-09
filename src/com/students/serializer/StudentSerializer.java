package com.students.serializer;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.student.Student;

public class StudentSerializer {
    private static ArrayList<Student> studentArrayList;
    private static int stdID;
    private static String firstName;
    private static String lastName;
    private static ArrayList<String> courses;
    private static Scanner sc;
    final static String filename = "output.out";

    public static void main(String[] args) {
        studentArrayList = new ArrayList<Student>();
        System.out.println("Enter students!");
        addStudents();

        try {
            // Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(studentArrayList);
            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }

    /**
     * Adds student to arraylist. First sets the field in the class and creates a
     * nameless object that gets added in the arraylist
     */
    public static void addStudents() {
        boolean isMore = true;
        sc = new Scanner(System.in);
        while (isMore == true) {
            setStudentID();
            setName();
            setCourses();
            studentArrayList.add(new Student(stdID, firstName, lastName, courses));
            isMore = isMore(isMore);
        }
        sc.close();
    }

    /**
     * Gets string input of space seperated courses then adds each course into
     * arraylsit
     */
    public static void setCourses() {
        courses = new ArrayList<String>();
        String stringCourses;
        System.out.println("Enter Student Courses (Seperated by space)");
        stringCourses = sc.nextLine();

        for (String course : stringCourses.split(" ")) {
            if (!course.isEmpty()) {
                courses.add(course);
            }
        }

    }

    /**
     * checks if the user wants to add a new student. Returns true if user wants to
     * go on the loop. Unless choice is 'y' or 'n' it will wait for the right input.
     */
    public static boolean isMore(boolean isMore) {
        boolean done = false;
        char choice;
        System.out.println("Want to add another one? (y/n)");
        do {
            choice = sc.next().charAt(0);
            sc.nextLine();
            if (choice == 'y' || choice == 'Y') {
                isMore = true;
                done = true;
            } else if (choice == 'n' || choice == 'N') {
                isMore = false;
                done = true;
            } else {
                System.out.println("Only y or n");
            }
        } while (done == false);
        return isMore;
    }

    /**
     * sets student id by getting a string and parse it intu an integer. It has an
     * input checker and loops until the input is number only.
     */
    public static void setStudentID() {
        boolean isTrue = true;
        do {
            System.out.println("Enter Student ID");
            try {
                isTrue = true;
                stdID = Integer.parseInt(sc.nextLine());
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Student ID has to be an integer!");
                isTrue = false;
            }
        } while (isTrue == false);

    }

    /**
     * sets firstname and lastname as it checks if all of the elements of the string
     * is alphabetical. Loops for both firstname and lastname until user inputs an
     * appropriate input.
     */
    public static void setName() {
        String str;
        boolean done = false;
        while (!done) {
            System.out.println("Enter Student Firstname");
            str = sc.nextLine();
            if (isStringOnlyAlphabet(str)) {
                firstName = str;
                done = true;
            } else {
                System.out.println("First Name has to be alphabetical!");
            }
        }
        done = false;
        while (!done) {
            System.out.println("Enter Student Lastname");
            str = sc.nextLine();
            if (isStringOnlyAlphabet(str)) {
                lastName = str;
                done = true;
            } else {
                System.out.println("Last Name has to be alphabetical!");
            }
        }

    }

    /** Checks if passed string is consists of only alphabetical characters. */
    public static boolean isStringOnlyAlphabet(String str) {
        return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")));
    }
}