package com.student.Graphical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/** Graphical User Interface class that connects User Interface and ViewController
 * classes. Also has a nested class called ChoiceHandler which determines 
 * methods to execute.
 */
public class GUI {
	ChoiceHandler cHandler = new ChoiceHandler();
	UI ui = new UI();
	ViewController ViewController = new ViewController(ui);

	public static void main(String[] args) {
		new GUI();
	}

	public GUI() {

		ui.createUI(cHandler);
		ViewController.setMainScreen();
	}
	/** Choice Handler class implementing ActionListener class.
	 * Getting passed an event which then by the value executes
	 * appropriate ViewController method.
	 */
	public class ChoiceHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String yourChoice = event.getActionCommand();
			switch (yourChoice) {
				case "Serialize":
					ViewController.setInputScreen();
					break;
				case "Deserialize":
					ViewController.setDeserializedScreen();
					break;
				case "Continue":
					ViewController.createStudent();
					break;
				case "Stop":
					ViewController.writeFile();
					ViewController.setMainScreen();
					break;
				default:
					break;
			}
		}
	}
}
