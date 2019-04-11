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
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	
	private JButton save = new JButton("Submit");
	
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
		
		panel4.add(save);
		
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		
		save.addActionListener(this);
		temp.addActionListener(this);
		ache.addActionListener(this);
		soreT.addActionListener(this);
		
		setLayout(new GridLayout(4,1));
		setVisible(true);
		setSize(400,300);
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource() == save)
		{
			pList.add(new Patient( (String) temp.getSelectedItem(), (String) ache.getSelectedItem(), (String)  soreT.getSelectedItem(),null));
			JOptionPane.showMessageDialog(this, pList.get(pList.size() - 1));
		}
		
	}
}
