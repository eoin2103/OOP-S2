			README
---------------------------------------------------------------------
AUTHOR:C17400202- Eoin Gallagher
DATE: 12/04/2019
ASSIGNMENT:5. Machine learning model, using Naive Bayes
---------------------------------------------------------------------
-------------------------BRIEF---------------------------------------
This assignment useS a machine learning algorithm called Naive Bayes. 
A simple dataset was provided showing previous cases of whether patients had 
tonsillitis or not (based on assessing temperature, aches and pains and sore 
throat). Using java, the assignment trains a model using the dataset provided. 
A GUI, allows for patient symptoms to be entered in, and the prediction model 
gives the probability of whether they have tonsillitis or not. The program
is also able to elf evaluate itself.

The program when ran will prompt a GUI window where the user is greeted by three
labeled drop down menus and two buttons one will submit the users entered symptoms
and the other will check the accuracy of the results. clicking on the the JcomboBox
will show a list of set options for each symptom input. Once the data is entered in
the combobox and the user clicks the submit button the will trigger a pop up screen 
which will display the probability that the user has tonsillitis and that the user
doesnt have tonsillitis based on the dataset recieved in the brief.
------------------------LINKS---------------------------------------
VIDEO- https://youtu.be/Tui5PUZ0VLg
GITHUB-https://github.com/eoin2103/OOP-S2
---------------------------------------------------------------------
-----------------------LIST OF CLASSES-------------------------------
CONTROL- 
Instantiates a new GUI which is displayed upon running

GUI- 
adds panels labels buttons and comboboxes to the gui includes actionlisteners that 
wait for user interaction with buttons if user presses submit the symptoms in the 
comboboxes are recorded and are checked for possibilty of tonsillitis, if evaluate 
is pressed the accuracy of the diagnosis is checked

CALCULATE-
Calculate class is used to check the probability of tonsillitis using the training dataset
and also contains a method used for the self evaluation

FILEPROCESS-
Fileprocess scans through a file line by line each line is read into a string which then
has its words seperated by commas (csv format) the words are then read into to an array 
which is then used to fill the array list pList

PATIENT- Used to instantiate new patient objects throughout the code
------------------------------------------------------------------------
