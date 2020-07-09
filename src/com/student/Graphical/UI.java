package com.student.Graphical;

import java.awt.Color;
import java.awt.Font;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.student.Graphical.GUI.ChoiceHandler;

public class UI {

	JFrame window;
	JPanel titleNamePanel, buttonPanel, inputPanel, deserializedPanel;
	JLabel title, studentIDLabel, firstNameLabel, lastNameLabel, coursesLabel;
	JButton serialButton, deserialButton, continueButton, stopButton;
	JTextField studentID, firstName, lastName, courses;
	JTextArea textArea;
	PrintStream printStream;
	Font titleFont =  new Font("Times New Roman", Font.PLAIN, 45);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 16);
	
	public void createUI(ChoiceHandler cHandler) {
		
		// **Window**
		window = new JFrame();
		window.setTitle("Serializer/Deserializer");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.gray);
		window.setLayout(null);		
		
		// ***Main Screen***
		
		// *Title Panel*
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600 ,600);
		titleNamePanel.setBackground(Color.gray);
		// title
		title = new JLabel("Choose Your Option");
		title.setForeground(Color.white);
		title.setFont(titleFont);
		titleNamePanel.add(title);
		
		// *Button Panel*
		buttonPanel = new JPanel();
		buttonPanel.setBounds(300, 400, 200, 100);
		buttonPanel.setBackground(Color.gray);
		// serialButton
		serialButton =  new JButton("Serialize");
		serialButton.setBackground(Color.white);
		serialButton.setForeground(Color.black);
		serialButton.setFont(normalFont);
		serialButton.setFocusPainted(false);
		serialButton.addActionListener(cHandler);
		serialButton.setActionCommand("Serialize");
		// deserialButton
		deserialButton =  new JButton("Deserialize");
		deserialButton.setBackground(Color.white);
		deserialButton.setForeground(Color.black);
		deserialButton.setFont(normalFont);
		deserialButton.setFocusPainted(false);
		deserialButton.addActionListener(cHandler);
		deserialButton.setActionCommand("Deserialize");
		buttonPanel.add(serialButton);
		buttonPanel.add(deserialButton);


		// ***Input Panel***

		inputPanel = new JPanel();
		inputPanel.setBounds(50, 50, 700, 500);
		inputPanel.setBackground(Color.gray);

		// *Text Fields*

		studentID = new JTextField(10);
		firstName = new JTextField(20);
		lastName = new JTextField(20);
		courses = new JTextField(20);
		
		// *Labels*

		studentIDLabel = new JLabel("Student ID");
		firstNameLabel = new JLabel("First Name");
		lastNameLabel = new JLabel("Last Name");
		coursesLabel = new JLabel("Courses");

		// *Buttons*

		continueButton = new JButton("Continue");
		continueButton.setBackground(Color.green);
		continueButton.setForeground(Color.white);
		continueButton.setFont(normalFont);
		continueButton.setFocusPainted(false);
		continueButton.addActionListener(cHandler);
		continueButton.setActionCommand("Continue");

		stopButton = new JButton("Stop");
		stopButton.setBackground(Color.red);
		stopButton.setForeground(Color.white);
		stopButton.setFont(normalFont);
		stopButton.setFocusPainted(false);
		stopButton.addActionListener(cHandler);
		stopButton.setActionCommand("Stop");

		inputPanel.add(studentIDLabel);
		inputPanel.add(studentID);
		inputPanel.add(firstNameLabel);
		inputPanel.add(firstName);
		inputPanel.add(lastNameLabel);
		inputPanel.add(lastName);
		inputPanel.add(coursesLabel);
		inputPanel.add(courses);
		inputPanel.add(continueButton);
		inputPanel.add(stopButton);
		
		// ***DeserializedPane***

		deserializedPanel = new JPanel();
		deserializedPanel.setBounds(100, 100, 600, 400);
		deserializedPanel.setBackground(Color.gray);

		window.add(buttonPanel);
		window.add(titleNamePanel);
		window.add(inputPanel);
		window.setVisible(true);
	}

}
