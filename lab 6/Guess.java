package lcom.lab6.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;

import java.util.Random;

import javax.swing.JOptionPane;

/*
 * Class Name: Random
 * Description: Window that displays guessing game
 * Author: Eoin Gallagher
 * Date: 6/3/2019
 */

public class Guess extends JFrame implements ActionListener
{
	//attributes
		private JButton genRand;
		private JButton submit;
		private JLabel guessLabel;
		private JTextField guessTextField;
		private JPanel panel1;
		private JPanel panel2;
		private JPanel panel3;
		private int randNum;
		private String entry;
		private int guessNum;
		private boolean generated = false;
		private boolean exCaught;
		private int guesses = 0;
		
	//constructor
		public Guess(String title)
		{
			super(title);
			
			setLayout(new BorderLayout());
			
			panel1 = new JPanel();
			panel1.setSize(500,500);
			
			
			genRand = new JButton("Generate Random Number");
			genRand.addActionListener(this);
			panel1.add(genRand);
			
			
			
			add(panel1, BorderLayout.NORTH);
			
			panel2 = new JPanel();
			panel2.setSize(500,500);
			
			guessLabel = new JLabel("Guess:");
			guessTextField = new JTextField("guess here");
			panel2.add(guessLabel);
			panel2.add(guessTextField);
			
			
			add(panel2, BorderLayout.CENTER);
			
			submit = new JButton("Check Your Guess");
			panel3 = new JPanel();
			panel3.setSize(500,500);
			panel3.add(submit);
			submit.addActionListener(this);
			add(panel3, BorderLayout.SOUTH);
			
			setSize(400,400);
			setVisible(true);
		}
		
		

		public void actionPerformed(ActionEvent event)
		{
			Random rand = new Random();
			
			
			
			
			
			
			
			if(event.getSource() == genRand)//button1 was pressed
			{
				randNum = rand.nextInt(100);
				generated = true;
				
				System.out.println(randNum);
			}
			else if(event.getSource() == submit)//button2 was pressed
			{
				exCaught = false;
				if(generated == false)
				{
					JOptionPane.showMessageDialog(null, "generate a number first");
				}
				else
				{
					//read in from text field and display window with contents
					try
					{
						entry = guessTextField.getText();
						guessNum = Integer.parseInt(entry);
					}
					catch(java.lang.NumberFormatException e)	
					{
						JOptionPane.showMessageDialog(null, "Number must be between 0 and 100");
						exCaught = true;
						
					}
					
					
					if(exCaught == false)
					{
						if((guessNum == randNum))
						{
							JOptionPane.showMessageDialog(null, "You're Correct!\n\nYou got it in: " + guesses + " guesses.");
						}
						else if((guessNum > randNum))
						{
							JOptionPane.showMessageDialog(null, "Too High,Try Again");
						}
						else if((guessNum < randNum))
						{
							JOptionPane.showMessageDialog(null, "Too Low, Try Again");
						}
						guesses++;
					}
					
					System.out.println(entry);
				}
				
			}
		}

}

