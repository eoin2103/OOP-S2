package com.assignment.machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GUI extends JFrame implements ActionListener
{
	
	private String[] temperature = {"hot","normal","cool"};
	private String[] aches = {"yes","no"};
	private String[] soreThroat = {"yes","no"};
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	private JButton save = new JButton("Submit");
	
	private ArrayList<Patient> pList = new ArrayList<>();
	
	JComboBox temp = new JComboBox(temperature);
	JComboBox ache = new JComboBox(aches);
	JComboBox soreT = new JComboBox(soreThroat);
	
	public GUI() 
	{
		
		panel1.add(temp);
		panel1.add(ache);
		panel1.add(soreT);
		panel1.add(save);
		
		add(panel1);
		
		save.addActionListener(this);
		temp.addActionListener(this);
		ache.addActionListener(this);
		soreT.addActionListener(this);
		
		setVisible(true);
		setSize(400,400);
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource() == save)
		{
			pList.add(new Patient( (String) temp.getSelectedItem(), (String) ache.getSelectedItem(), (String)  soreT.getSelectedItem()));
			JOptionPane.showMessageDialog(this, pList.get(pList.size() - 1));
		}
		
	}
}
