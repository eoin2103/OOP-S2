package com.assignment.machine;

import java.util.ArrayList;

public class Calculate
{
	ArrayList<Patient> pList = new ArrayList<Patient>();
	
	private float tempYesTotal;
	private float tempNoTotal;
	private float acheYesTotal;
	private float acheNoTotal;
	private float soreTYesTotal;
	private float soreTNoTotal;
	private float tsYesTotal;
	private float tsNoTotal;
	private float dataTotal;
	
	private float tempYesTS;
	private float tempNoTS;
	private float achesYesTS;
	private float achesNoTS;
	private float soreTYesTS;
	private float soreTNoTS;
	private float yesTS;
	private float noTS;
	
	private float probYes;
	private float probNo;
	private float probTotal;
	private float chanceYes;
	private float chanceNo;
	
	int i;
	
	Patient currentP;
	private String currentTemp;
	private String currentAches;
	private String currentSoreT;
	
	//Constructor
	public Calculate()
	{
		FileProcess fp = new FileProcess("src\\com\\assignment\\machine\\dataset.csv");
		fp.openFile();
		pList = fp.readFile();
		fp.closefile();
		System.out.println(pList);
	}
	public void Total()
	{
		for(i = 0; i < pList.size(); i++)
		{
			if()
			{
				dataTotal++;
			}
			if()
			{
				tempYesTotal++;
			}
			else
			{
				tempNoTotal++;
			}
			if()
			{
				tsYesTotal++;
			}
			else
			{
				tsNoTotal++;
			}
			if()
			{
				acheYesTotal++;
			}
			else
			{
				acheNoTotal++;
			}
			if()
			{
				soreTYesTotal++;
			}
			else
			{
				soreTNoTotal++;
			}
			if()
			{
				tsYesTotal++;
			}
			else
			{
				tsNoTotal++;
			}
			
			
		}
		tempYesTS = (tempYesTotal/tsYesTotal);
		tempNoTS = (tempNoTotal/tsNoTotal);
		achesYesTS = (acheYesTotal/tsYesTotal);
		achesNoTS = (acheNoTotal/tsNoTotal);
		soreTYesTS = (soreTYesTotal/tsYesTotal);
		soreTNoTS = (soreTNoTotal/tsNoTotal);
		yesTS = (tsYesTotal/dataTotal);
		noTS = (tsNoTotal/dataTotal);
		
	}
	public void Algorithm()
	{
		probYes = (tempYesTS * achesYesTS * soreTYesTS * yesTS);
		probNo = (tempNoTS * achesNoTS * soreTNoTS * noTS);
		probTotal = (probYes + probNo);
		chanceYes = (probYes/probTotal);
		chanceNo = (probNo/probTotal);
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

	public float getYesTS() {
		return yesTS;
	}

	public void setYesTS(float yesTS) {
		this.yesTS = yesTS;
	}

	public float getNoTS() {
		return noTS;
	}

	public void setNoTS(float noTS) {
		this.noTS = noTS;
	}
	private float getProbYes() {
		return probYes;
	}
	private void setProbYes(float probYes) {
		this.probYes = probYes;
	}
	public float getProbNo() {
		return probNo;
	}
	public void setProbNo(float probNo) {
		this.probNo = probNo;
	}
	public float getProbTotal() {
		return probTotal;
	}
	public void setProbTotal(float probTotal) {
		this.probTotal = probTotal;
	}
	public float getTempYesTotal() {
		return tempYesTotal;
	}
	public void setTempYesTotal(float tempYesTotal) {
		this.tempYesTotal = tempYesTotal;
	}
	public float getTempNoTotal() {
		return tempNoTotal;
	}
	public void setTempNoTotal(float tempNoTotal) {
		this.tempNoTotal = tempNoTotal;
	}
	public float getAcheYesTotal() {
		return acheYesTotal;
	}
	public void setAcheYesTotal(float acheYesTotal) {
		this.acheYesTotal = acheYesTotal;
	}
	public float getAcheNoTotal() {
		return acheNoTotal;
	}
	public void setAcheNoTotal(float acheNoTotal) {
		this.acheNoTotal = acheNoTotal;
	}
	public float getSoreTYesTotal() {
		return soreTYesTotal;
	}
	public void setSoreTYesTotal(float soreTYesTotal) {
		this.soreTYesTotal = soreTYesTotal;
	}
	public float getSoreTNoTotal() {
		return SoreTNoTotal;
	}
	public void setSoreTNoTotal(float soreTNoTotal) {
		SoreTNoTotal = soreTNoTotal;
	}
	public float getTsYesTotal() {
		return tsYesTotal;
	}
	public void setTsYesTotal(float tsYesTotal) {
		this.tsYesTotal = tsYesTotal;
	}
	public float getTsNoTotal() {
		return tsNoTotal;
	}
	public void setTsNoTotal(float tsNoTotal) {
		this.tsNoTotal = tsNoTotal;
	}
	public float getDataTotal() {
		return dataTotal;
	}
	public void setDataTotal(float dataTotal) {
		this.dataTotal = dataTotal;
	}

}
