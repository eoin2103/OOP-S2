package com.assignment.machine;

import java.util.ArrayList;

public class Calculate
{
	ArrayList<Patient> pList = new ArrayList<Patient>();
	ArrayList<Patient> evalList = new ArrayList<Patient>();
	
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
	
	private float p70;
	private float correct;
	private float incorrect;
	private float total;
	private float accuracy;
	
	
	
	//Constructor
	public Calculate(String currentTemp, String currentAches, String currentSoreT)
	{
		
		this.setCurrentTemp(currentTemp);
		this.setCurrentAches(currentAches);
		this.setCurrentSoreT(currentSoreT);
		
		FileProcess fp = new FileProcess("src\\com\\assignment\\machine\\dataset.csv");
		fp.openFile();
		pList = fp.readFile();
		fp.closefile();
		System.out.println(pList);
		
	}
	public void Total()
	{
	
		dataTotal = pList.size();
		tempYesTotal = 0;
		tempNoTotal = 0;
		acheYesTotal = 0;
		acheNoTotal = 0;
		soreTYesTotal = 0;
		soreTNoTotal = 0;
		
		
		for(i = 0; i < pList.size(); i++)
		{
			
			
			if(pList.get(i).getTemps().equals(currentTemp) && pList.get(i).getTonsillitis().equals("yes"))
			{
				tempYesTotal++;
			}
			else if(pList.get(i).getTemps().equals(currentTemp) && pList.get(i).getTonsillitis().equals("no"))
			{
				tempNoTotal++;
			}
			
			//Gets total of yes and no for tonsillitis
			if(pList.get(i).getTonsillitis().equals("yes"))
			{
				tsYesTotal++;
			}
			else
			{
				tsNoTotal++;
			}
			
			//Checks aches probability
			if(pList.get(i).getAches().equals(currentAches) && pList.get(i).getTonsillitis().equals("yes"))
			{
				acheYesTotal++;
			}
			else if(pList.get(i).getAches().equals(currentAches) && pList.get(i).getTonsillitis().equals("no"))
			{
				acheNoTotal++;
			}
	
			
			if(pList.get(i).getSoreThroat().equals(currentSoreT) && pList.get(i).getTonsillitis().equals("yes"))
			{
				soreTYesTotal++;
			}
			else if(pList.get(i).getSoreThroat().equals(currentSoreT) && pList.get(i).getTonsillitis().equals("no"))
			{
				soreTNoTotal++;
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
		
		System.out.println(currentAches);
		System.out.println(currentSoreT);
		System.out.println(currentTemp);
		
	}
	public void Algorithm()
	{
		
		probYes = 0;
		probNo = 0;
		probTotal = 0;
		chanceYes = 0;
		chanceNo = 0;
		
		probYes = (tempYesTS * achesYesTS * soreTYesTS * yesTS);
		probNo = (tempNoTS * achesNoTS * soreTNoTS * noTS);
		probTotal = (probYes + probNo);
		chanceYes = (probYes/probTotal);
		chanceNo = (probNo/probTotal);
		
	}
	
	public String toString()
	{
		String results=("Chance You Have Tonsillitis:" + chanceYes +"%"+"\nChance You Don't Have Tonsillitis:" + chanceNo +"%" );
		return results;
			
	}
	
	public Calculate() 
	{
		FileProcess fp = new FileProcess("src\\com\\assignment\\machine\\dataset.csv");
		fp.openFile();
		pList = fp.readFile();
		fp.closefile();
		System.out.println(pList);
		
		p70 = (float) (pList.size() * .7);
		p70 = Math.round(p70);
		
		for (int i = (pList.size() - 1); i > (p70 - 1); i--)
			{
				evalList.add(pList.get(i));
				pList.remove(i);
			}
		
		
	}
	
	public String evaluateResults()
	{
		for(int i = 0; i < evalList.size(); i++)
		{
			
			currentTemp = evalList.get(i).getTemps();
			currentAches = evalList.get(i).getAches();
			currentSoreT = evalList.get(i).getSoreThroat();
			
			Calculate c3 = new Calculate(currentTemp,currentAches,currentSoreT);
			c3.Total();
			c3.Algorithm();
			
			if(evalList.get(i).getTonsillitis().equals("yes"))
			{
				if(chanceYes > 50)
				{
					correct++;
				}
				else if(chanceYes <= 50)
				{
					incorrect++;
				}
			}
			else if(evalList.get(i).getTonsillitis().equals("no"))
			{
				if(chanceNo > 50)
				{
					correct++;
				}
				else if(chanceNo <= 50)
				{
					incorrect++;
				}
			}
			
			total = correct + incorrect;
			accuracy = (correct/total) * 100;
			
		}
		String result = ("Accuracy of Diagnosis :" + accuracy + "%");
		return result;
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
		return soreTNoTotal;
	}
	public void setSoreTNoTotal(float soreTNoTotal) {
		this.soreTNoTotal = soreTNoTotal;
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
	public float getP70() {
		return p70;
	}
	public void setP70(float p70) {
		this.p70 = p70;
	}
	public float getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}
	public float getIncorrect() {
		return incorrect;
	}
	public void setIncorrect(float incorrect) {
		this.incorrect = incorrect;
	}
	public float getCorrect() {
		return correct;
	}
	public void setCorrect(float correct) {
		this.correct = correct;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}

}
