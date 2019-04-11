package com.assignment.machine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class FileProcess {
	
	private String fileName;
	private Scanner fileScanner;
	private File text;
	private PrintWriter writing;
	private ArrayList<Patient> pList = new ArrayList<Patient>();
	
	//constructor
	public FileProcess(String fileName)
	{
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
			setFileScanner(new Scanner(getText()));
			while(getFileScanner().hasNextLine())
			{
				String line = getFileScanner().nextLine();
				String[] word = line.split(",");
				pList.add(new Patient(word[0],word[1],word[2],word[3]));
			}
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("!Scanner Error!:" + e.getMessage());
		}
		return pList;
	}
	
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

	public PrintWriter getWriting() {
		return writing;
	}

	public void setWriting(PrintWriter writing) {
		this.writing = writing;
	}

}
//\src\com\assignment\machine -Dataset file path