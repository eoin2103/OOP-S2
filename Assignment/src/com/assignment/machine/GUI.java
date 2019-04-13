package com.assignment.machine;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*-----------------JAVA MACHINE LEARNING ASSIGNMENT----------------
 * Class Name: GUI
 * Description: Adds and displays labels buttons panels and drop down menus on the GUI,
 * 				also has action listeners for button presses and menu interaction which 
 * 				call on other classes or display results. calls on the algorithm within 
 * 				the Calculate class with an action listener.
 * Author: Eoin Gallagher
 * IDE: Eclipse
 * Date: 12/4/2019
 * -----------------------------------------------------------------
 */


public class GUI extends JFrame implements ActionListener
{
	//Strings that are used for the options within the JComboBox
	private String[] temperature = {"hot","normal","cool"};
	private String[] aches = {"yes","no"};
	private String[] soreThroat = {"yes","no"};
	
	//Strings used for taking in the selected items in the combo boxes
	private String t2;
	private String a2;
	private String s2;
	
	//Panels are used for each button and drop down menu
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();
	
	//two buttons one to submit user symptoms and one to evaluate the results
	private JButton submit = new JButton("Submit");
	private JButton evaluate = new JButton("Evaluate Accuracy of results");
	
	//Labels used to label each drop down menu with what they correspond to
	private JLabel t = new JLabel();
	private JLabel a = new JLabel();
	private JLabel s = new JLabel();
	
	//Array List of Patient objects called pList
	private ArrayList<Patient> pList = new ArrayList<>();
	
	//Creates new Jcombobox objects for each of the symptoms that must be read in from the patients
	JComboBox temp = new JComboBox(temperature);
	JComboBox ache = new JComboBox(aches);
	JComboBox soreT = new JComboBox(soreThroat);
	
	//Constructor
	public GUI() 
	{
		
		//Sets title on the GUI
		super("Tonsillitis Checker");
		
		//sets the text the labels will display
		t.setText("Temperature: ");
		a.setText("Aches: ");
		s.setText("Sore Throat: ");
		
		//adds a label and combobox to panel1
		panel1.add(t);
		panel1.add(temp);
		
		//adds a label and combobox to panel2
		panel2.add(a);
		panel2.add(ache);
		
		//adds a label and combobox to panel3
		panel3.add(s);
		panel3.add(soreT);
		
		//adds a submit button for the symptoms to panel 4
		panel4.add(submit);
		
		//adds a evaluate button to check result accuracy to panel 5
		panel5.add(evaluate);
		
		//Adds the panels to the GUI
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		
		//Sets actionlistenrs for the comboboxes and for the buttons
		submit.addActionListener(this);
		temp.addActionListener(this);
		ache.addActionListener(this);
		soreT.addActionListener(this);
		evaluate.addActionListener(this);
		
		//sets the layout of the panels to a grid with 5 rows and 1 column
		setLayout(new GridLayout(5,1));
		//Sets the gui to display when created
		setVisible(true);
		//Sets the size of the screen displayed
		setSize(400,300);
		
	}
	
	//Decides what happens when the buttons or comboboxes are interacted with
	public void actionPerformed(ActionEvent e) 
	{
		
		//If the user clicks submit
		if(e.getSource() == submit)
		{
			//takes in info from each combobox to the 3 variables
			t2 = (String) temp.getSelectedItem();
			a2 = (String) ache.getSelectedItem();
			s2 = (String) soreT.getSelectedItem();
			
			//passes through the info from the combo boxes that is then checked against the info in the csv file to get the probabilty of tonsillitis
			Calculate c1 = new Calculate(t2,a2,s2);
			c1.Total();
			c1.Algorithm();
			//Shows a pop up menu with the results on it
			JOptionPane.showMessageDialog(this,c1.toString());
		}
		//else if the user interacts with the evaluate button
		else if(e.getSource() == evaluate)
		{
			//calls the evaluation method inside the Calculate class
			Calculate c2 = new Calculate();
			
			//Display the results accuracy on a pop up panel
			JOptionPane.showMessageDialog(this,c2.evaluateResults());
			
		}
		
	}

}
