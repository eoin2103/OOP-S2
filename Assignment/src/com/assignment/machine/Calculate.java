package com.assignment.machine;

import java.util.ArrayList;

public class Calculate
{
	ArrayList<Patient> pList = new ArrayList<Patient>();
	
	private float tempYesTS;
	private float tempNoTS;
	private float achesYesTS;
	private float achesNoTS;
	private float soreTYesTS;
	private float soreTNoTS;
	private float chanceYes;
	private float chanceNo;
	
	private String currentTemp;
	private String currentAches;
	private String currentSoreT;
	
	public Calculate()
	{
		
	}

	public float getTempYesTS() {
		return tempYesTS;
	}

	public void setTempYesTS(float tempYesTS) {
		this.tempYesTS = tempYesTS;
	}

	public float getTempNoTS() {
		return tempNoTS;
	}

	public void setTempNoTS(float tempNoTS) {
		this.tempNoTS = tempNoTS;
	}

	public float getAchesYesTS() {
		return achesYesTS;
	}

	public void setAchesYesTS(float achesYesTS) {
		this.achesYesTS = achesYesTS;
	}

	public float getAchesNoTS() {
		return achesNoTS;
	}

	public void setAchesNoTS(float achesNoTS) {
		this.achesNoTS = achesNoTS;
	}

	public float getSoreTYesTS() {
		return soreTYesTS;
	}

	public void setSoreTYesTS(float soreTYesTS) {
		this.soreTYesTS = soreTYesTS;
	}

	public float getSoreTNoTS() {
		return soreTNoTS;
	}

	public void setSoreTNoTS(float soreTNoTS) {
		this.soreTNoTS = soreTNoTS;
	}

	public float getChanceYes() {
		return chanceYes;
	}

	public void setChanceYes(float chanceYes) {
		this.chanceYes = chanceYes;
	}

	public float getChanceNo() {
		return chanceNo;
	}

	public void setChanceNo(float chanceNo) {
		this.chanceNo = chanceNo;
	}

	public String getCurrentTemp() {
		return currentTemp;
	}

	public void setCurrentTemp(String currentTemp) {
		this.currentTemp = currentTemp;
	}

	public String getCurrentAches() {
		return currentAches;
	}

	public void setCurrentAches(String currentAches) {
		this.currentAches = currentAches;
	}

	public String getCurrentSoreT() {
		return currentSoreT;
	}

	public void setCurrentSoreT(String currentSoreT) {
		this.currentSoreT = currentSoreT;
	}

}
