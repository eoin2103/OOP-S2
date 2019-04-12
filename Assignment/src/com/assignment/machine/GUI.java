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


public class GUI extends JFrame implements ActionListener
{
	
	private String[] temperature = {"hot","normal","cool"};
	private String[] aches = {"yes","no"};
	private String[] soreThroat = {"yes","no"};
	
	private String t2;
	private String a2;
	private String s2;
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();
	
	private JButton submit = new JButton("Submit");
	private JButton evaluate = new JButton("Evaluate Accuracy of results");
	
	private JLabel t = new JLabel();
	private JLabel a = new JLabel();
	private JLabel s = new JLabel();
	
	private ArrayList<Patient> pList = new ArrayList<>();
	
	JComboBox temp = new JComboBox(temperature);
	JComboBox ache = new JComboBox(aches);
	JComboBox soreT = new JComboBox(soreThroat);
	
	public GUI() 
	{
		
		super("Tonsillitis Checker");
		
		t.setText("Temperature: ");
		a.setText("Aches: ");
		s.setText("Sore Throat: ");
		
		panel1.add(t);
		panel1.add(temp);
		
		panel2.add(a);
		panel2.add(ache);
		
		panel3.add(s);
		panel3.add(soreT);
		
		panel4.add(submit);
		
		panel5.add(evaluate);
		
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		
		submit.addActionListener(this);
		temp.addActionListener(this);
		ache.addActionListener(this);
		soreT.addActionListener(this);
		evaluate.addActionListener(this);
		
		setLayout(new GridLayout(5,1));
		setVisible(true);
		setSize(400,300);
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource() == submit)
		{
			t2 = (String) temp.getSelectedItem();
			a2 = (String) ache.getSelectedItem();
			s2 = (String) soreT.getSelectedItem();
			
			Calculate c1 = new Calculate(t2,a2,s2);
			c1.Total();
			c1.Algorithm();
			JOptionPane.showMessageDialog(this,c1.toString());
		}
		else if(e.getSource() == evaluate)
		{
			
			Calculate c2 = new Calculate();
			c2.evaluateResults();
			JOptionPane.showMessageDialog(this,c2.evaluateResults());
			
		}
		
	}

}
