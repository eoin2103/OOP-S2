package com.assignment.machine;

import java.util.ArrayList;

/*-----------------JAVA MACHINE LEARNING ASSIGNMENT----------------
 * Class Name: Calculate
 * Description: Performs the algorithm used to determine the probability of tonsillitis
 * 				based on the users input in the GUI, Also contains the method that performs
 * 				the self-evaluation
 * Author: Eoin Gallagher
 * IDE: Eclipse
 * Date: 12/4/2019
 * -----------------------------------------------------------------
 */

public class Calculate
{
	//Array list of patients called plist used in the algorithm
	ArrayList<Patient> pList = new ArrayList<Patient>();
	//Array List used for the self evaluation
	ArrayList<Patient> evalList = new ArrayList<Patient>();
	
	// Variables used for the calculations within the algorithm
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
	
	// Variables used to determine the actual return results of the algorithm 
	private float probYes;
	private float probNo;
	private float probTotal;
	private float chanceYes;
	private float chanceNo;
	
	//variables used for for loops
	int i;
	int a;
	int j;
	
	//Variables used for creating patient object
	private String currentTemp;
	private String currentAches;
	private String currentSoreT;
	
	//Variables used in the self-evaluating check on the data
	private float p70;
	private float correct;
	private float accuracy;
	
	
	
	//Constructor
	public Calculate(String currentTemp, String currentAches, String currentSoreT)
	{
		
		this.setCurrentTemp(currentTemp);
		this.setCurrentAches(currentAches);
		this.setCurrentSoreT(currentSoreT);
		
		//Calls fileprocess to to read through dataset.csv file and put the data in an array list called pList
		FileProcess fp = new FileProcess("src\\com\\assignment\\machine\\dataset.csv");
		fp.openFile();
		pList = fp.readFile();
		fp.closefile();
		System.out.println(pList);
		
	}
	public void Total()
	{
		//set all the used variables to zero to avoid calculation errors
		i = 0;
		dataTotal = 0;
		tempYesTotal = 0;
		tempNoTotal = 0;
		acheYesTotal = 0;
		acheNoTotal = 0;
		soreTYesTotal = 0;
		soreTNoTotal = 0;
		tsYesTotal = 0;
		tsNoTotal = 0;
		tempYesTS = 0;
		tempNoTS = 0;
		achesYesTS = 0;
		achesNoTS = 0;
		soreTYesTS = 0;
		soreTNoTS = 0;
		yesTS = 0;
		noTS = 0;
		
		//sets dataTotal to the size of the array list pList
		dataTotal = pList.size();
		
		
		for(i = 0; i < pList.size(); i++)
		{
			
			//if the temperature is equal to currentTemp and tonsillitis is yes increments temp yes total counter
			if(pList.get(i).getTemps().equals(currentTemp) && pList.get(i).getTonsillitis().equals("yes"))
			{
				tempYesTotal++;
			}
			//if the temperature is equal to currentTemp and tonsillitis is no increments temp no total counter
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
			
			//Checks aches is equal to currentAches and tonsillitis is yes increments ache yes total counter
			if(pList.get(i).getAches().equals(currentAches) && pList.get(i).getTonsillitis().equals("yes"))
			{
				acheYesTotal++;
			}
			//Checks aches is equal to currentAches and tonsillitis is no increments ache no total counter
			else if(pList.get(i).getAches().equals(currentAches) && pList.get(i).getTonsillitis().equals("no"))
			{
				acheNoTotal++;
			}
	
			//Checks Sore Throat is equal to currentSoreT and tonsillitis is yes increments soreT yes total counter
			if(pList.get(i).getSoreThroat().equals(currentSoreT) && pList.get(i).getTonsillitis().equals("yes"))
			{
				soreTYesTotal++;
			}
			//Checks Sore Throat is equal to currentSoreT and tonsillitis is no increments soreT no total counter
			else if(pList.get(i).getSoreThroat().equals(currentSoreT) && pList.get(i).getTonsillitis().equals("no"))
			{
				soreTNoTotal++;
			}
			
			
		}
		//divides the above counters by tonsillitis yes or no total or the data total to get probability of each
		tempYesTS = (tempYesTotal/tsYesTotal);
		tempNoTS = (tempNoTotal/tsNoTotal);
		achesYesTS = (acheYesTotal/tsYesTotal);
		achesNoTS = (acheNoTotal/tsNoTotal);
		soreTYesTS = (soreTYesTotal/tsYesTotal);
		soreTNoTS = (soreTNoTotal/tsNoTotal);
		yesTS = (tsYesTotal/dataTotal);
		noTS = (tsNoTotal/dataTotal);
		
		//prints current aches, temp, soret to console
		System.out.println(currentAches);
		System.out.println(currentSoreT);
		System.out.println(currentTemp);
		
	}
	//determines probability percentage
	public float Algorithm()
	{
		//set all the used variables to zero to avoid calculation errors
		probYes = 0;
		probNo = 0;
		probTotal = 0;
		chanceYes = 0;
		chanceNo = 0;
		
		//math round used to round up the float numbers of the probability percentages to make look nicer in message pane on gui
		probYes = (tempYesTS * achesYesTS * soreTYesTS * yesTS);
		probNo = (tempNoTS * achesNoTS * soreTNoTS * noTS);
		probTotal = (probYes + probNo);
		chanceYes = Math.round((probYes/probTotal) * 100);//chance the patient has tonsillitis
		chanceNo = Math.round((probNo/probTotal) * 100);//chance the patient doesn't have tonsillitis
		
		return chanceYes;
		
	}
	
	//To string function returns probability results
	public String toString()
	{
		String results=("Chance You Have Tonsillitis:" + chanceYes +"%"+"\nChance You Don't Have Tonsillitis:" + chanceNo +"%" );
		return results;
			
	}
	
	//Constructor used for self evaluation
	public Calculate() 
	{
		p70 = 0;
		correct = 0;
		accuracy = 0;
		
		//reads csv file in to pList
		FileProcess fp = new FileProcess("src\\com\\assignment\\machine\\dataset.csv");
		fp.openFile();
		pList = fp.readFile();
		fp.closefile();
		System.out.println(pList);
		
		//p70 is set to the size of 70% of the list and is rounded to a whole number
		p70 = (float) (pList.size() * .7);
		p70 = Math.round(p70);
		
		//a = to plist size - 1 because size doesnt take into account the fact that arrays start at 0 rather than 1 same with p70
		//for loop continues until 30% of pList array is removed and inserted in evalList
		for (a = (pList.size() - 1); a > (p70 - 1); a--)
			{
				evalList.add(pList.get(a));
				pList.remove(a);
			}
		
		
	}
	
	//Does the math's involved in the evaluation
	public String evaluateResults()
	{
		
		System.out.println("---------------START OF EVAL---------------");
		System.out.println("evallist size:" +evalList.size());
		//loops through the  evalList checks tonsillitis against the probability of tonsillitis
		for(j = 0; j < evalList.size(); j++)
		{
			
			Calculate c3 = new Calculate(evalList.get(j).getTemps(),evalList.get(j).getAches(),evalList.get(j).getSoreThroat());
			c3.Total();
			c3.Algorithm();
			
			
			if(evalList.get(j).getTonsillitis().equals("yes") && chanceYes > 50 )
			{
		
					System.out.println("\n\n"+c3.toString());
					correct++;
					System.out.println(evalList.get(j).getTonsillitis());
					System.out.println("co:"+correct);
			
			}
			else if(evalList.get(j).getTonsillitis().equals("no") && chanceNo <= 50)
			{
					System.out.println("\n\n"+c3.toString());
					correct++;
					System.out.println(evalList.get(j).getTonsillitis());
					System.out.println("co:"+correct);
			}
			
			accuracy =Math.round((correct/evalList.size()) * 100);

		}
		System.out.println("---------------END OF EVAL---------------");
		
		//String That prints the accuracy of the results in the program
		String result = ("Accuracy of Diagnosis :" + accuracy + "%" );
		return result;
	}
	
	//Getters and Setters
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
	public float getCorrect() {
		return correct;
	}
	public void setCorrect(float correct) {
		this.correct = correct;
	}

}
