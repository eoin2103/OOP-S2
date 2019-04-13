package com.assignment.machine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

/*-----------------JAVA MACHINE LEARNING ASSIGNMENT----------------
 * Class Name: File Process
 * Description: the is class opens and scans through a file and uses
 * 				the data gathered to make and array list of patients
 * Author: Eoin Gallagher
 * IDE: Eclipse
 * Date: 12/4/2019
 * -----------------------------------------------------------------
 */

public class FileProcess {
	 
	//Variables used to scan through the dataset file to compare the user entered info against
	private String fileName;
	private Scanner fileScanner;
	private File text;
	//Creates and array list of patient objects
	private ArrayList<Patient> pList = new ArrayList<Patient>();
	
	//constructor
	public FileProcess(String fileName)
	{
		//Sets the name of the file to be scanned
		this.setFileName(fileName);
	}
	
	//opens the file
	public void openFile()
	{
			setText(new File(getFileName()));
	}
	
	//reads through file
	public ArrayList<Patient> readFile()
	{
		try
		{
			//sets the scanner to use the set file
			setFileScanner(new Scanner(getText()));
			
			//Scans through while the file has another line of text
			while(getFileScanner().hasNextLine())
			{
				//takes each line of text into a string
				String line = getFileScanner().nextLine();
				//creates and array of words by spliting each line read in with commas between each word
				String[] word = line.split(",");
				//Stores a patient in pList created with the words from the split line
				pList.add(new Patient(word[0],word[1],word[2],word[3]));
			}
			
		}
		//if the file cant be found then the below error message will displayed
		catch(FileNotFoundException e)
		{
			System.out.println("!Scanner Error!:" + e.getMessage());
		}
		return pList;
	}
	
	//closes the file
	public void closefile()
	{
		getFileScanner().close();
	}
	
	
	//Getters and Setters
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Scanner getFileScanner() {
		return fileScanner;
	}

	public void setFileScanner(Scanner fileScanner) {
		this.fileScanner = fileScanner;
	}

	public File getText() {
		return text;
	}

	public void setText(File text) {
		this.text = text;
	}

}
//\src\com\assignment\machine -Dataset file path