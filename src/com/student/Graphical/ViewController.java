package com.student.Graphical;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.student.Student;
/** ViewController class has methods for controlling the view/user interface.
 * 
 */
public class ViewController {
	UI ui;
	Student std;
	ArrayList<Student> stdArrayList;
	private ArrayList<Student> studentArrayList;
	final static String filename = "output.out";

	/** Gets the userInterface object. Copies into an object
	 * then controls the userInterface, manipulates or retrieves
	 * data with its custom methods.
	 */
	public ViewController(UI userInterface) {
		ui = userInterface;
	}

	/** Shows main screen panels and hides the other ones */
	public void setMainScreen() {
		ui.titleNamePanel.setVisible(true);
		ui.buttonPanel.setVisible(true);
		ui.inputPanel.setVisible(false);
		ui.deserializedPanel.setVisible(false);
	}

	/** Shows input screen panels and hides the other ones */
	public void setInputScreen() {
		ui.titleNamePanel.setVisible(false);
		ui.buttonPanel.setVisible(false);
		ui.inputPanel.setVisible(true);
		ui.deserializedPanel.setVisible(false);
		stdArrayList = new ArrayList<Student>();
	}

	/** Shows deserialized screen panels */
	public void setDeserializedScreen() {
		readFile();
	}

	/** Gets inputs from input fields that are located in UI class
	 * Passess them to a constructor which 
	 */
	public void createStudent() {
		std = new Student(Integer.parseInt(ui.studentID.getText()), ui.firstName.getText(), ui.lastName.getText(),
				ui.courses.getText());
		stdArrayList.add(std);
		ui.studentID.setText("");
		ui.firstName.setText("");
		ui.lastName.setText("");
		ui.courses.setText("");
	}

	/** Serializes and writes into a file */
	public void writeFile() {
		try {

			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(stdArrayList);
			out.close();
			file.close();

			// pops up a dialog box informs the process is done
			JOptionPane.showMessageDialog(null, "Object has been serialized");
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}
	/** reads the written file and displays it to the user with a dialog box. */
	public void readFile() {
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
					JOptionPane.showMessageDialog(null,
							counter + ". Student" + "\nStudent ID: " + student.getStdId() + "\nFirst Name: "
									+ student.getFirstName() + "\nLast Name: " + student.getLastName() + "\nLast Name: "
									+ student.getLastName() + "\nCourses: " + student.getCourses());
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
