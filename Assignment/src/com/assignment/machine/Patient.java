package com.assignment.machine;

public class Patient 
{
	private String temps;
	private String aches;
	private String soreThroat;
	private String tonsillitis;
	
	public Patient(String temps, String aches, String soreThroat, String tonsillitis)
	{
		this.setTemps(temps);
		this.setAches(aches);
		this.setSoreThroat(soreThroat);
		this.setTonsillitis(tonsillitis);
	}
	
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
