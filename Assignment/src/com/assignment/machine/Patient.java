package com.assignment.machine;

/*-----------------JAVA MACHINE LEARNING ASSIGNMENT----------------
 * Class Name: Patient
 * Description: used for creating a new patient 
 * Author: Eoin Gallagher
 * IDE: Eclipse
 * Date: 12/4/2019
 * -----------------------------------------------------------------
 */

public class Patient 
{
	//Variables used to instantiate a new patient object
	private String temps;
	private String aches;
	private String soreThroat;
	private String tonsillitis;
	
	//Variables inside a patient object
	public Patient(String temps, String aches, String soreThroat, String tonsillitis)
	{
		this.setTemps(temps);
		this.setAches(aches);
		this.setSoreThroat(soreThroat);
		this.setTonsillitis(tonsillitis);
	}
	
	//displays a patient and their symptoms/info 
	public String toString()
	{
		String summary = ("\ntemperature is:" + " "+temps + "\nAches:" + " "+ aches + "\nSore Throat:" + " "+ soreThroat + "\nPosibility of tonsillitis:" + " "+ tonsillitis + "\n");
		
		return summary;
	}
	
	public String getSoreThroat() {
		return soreThroat;
	}
	public void setSoreThroat(String soreThroat) {
		this.soreThroat = soreThroat;
	}
	public String getTonsillitis() {
		return tonsillitis;
	}
	public void setTonsillitis(String tonsillitis) {
		this.tonsillitis = tonsillitis;
	}
	public String getAches() {
		return aches;
	}
	public void setAches(String aches) {
		this.aches = aches;
	}

	public String getTemps() {
		return temps;
	}

	public void setTemps(String temps) {
		this.temps = temps;
	}

}
