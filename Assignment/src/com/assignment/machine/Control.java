package com.assignment.machine;

import java.util.ArrayList;

public class Control 
{
	
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<Patient> pList = new ArrayList<Patient>();
		
		GUI gui1 = new GUI ();
		FileProcess fp = new FileProcess("src\\com\\assignment\\machine\\dataset.csv");
		fp.openFile();
		pList = fp.readFile();
		fp.closefile();
		System.out.println(pList);
	}

}
