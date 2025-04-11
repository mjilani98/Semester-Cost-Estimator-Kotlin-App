package com.example.hw5q5

import android.widget.CheckBox

class TuitionCalculator
{
    private var numberOfCredit: Int     //number of credit
    private var academicStatus: Int     //academic status
    private var stateStatus: Int        //state status
    private var dorm: CheckBox          //dorm
    private var parking: CheckBox       //parking
    private var dining: CheckBox        //dining

    //public constructor
    constructor(numberOfCredit: Int,academicStatus: Int,stateStatus: Int, dorm: CheckBox, parking: CheckBox, dining: CheckBox)
    {
        this.numberOfCredit = numberOfCredit
        this.academicStatus = academicStatus
        this.stateStatus = stateStatus
        this.dorm = dorm
        this.parking = parking
        this.dining = dining
    }

    //method calculate the total cost
    public fun getTotalCost() : Int
    {
        var totalCost : Int // variable of the total cost of tuition

        var creditRate : Int //variable of the credit rate per credit

        var inState : Boolean //variable determines if student is in state or not

        //determine the academic status
        creditRate = 0
        if(academicStatus == R.id.radioBtnNonDegree)
        {
            creditRate = 300
        }
        else if (academicStatus == R.id.radioBtnUnderGraduate )
        {
            creditRate = 500
        }
        else if(academicStatus == R.id.radioBtnGraduate)
        {
            creditRate = 800
        }

        //determine the state status
        //determine the state status
        if(stateStatus == R.id.radioBtnInState)
        {
            inState = true
        }
        else
        {
            inState = false
        }

        //calculate the tuition
        if(inState == true) // if the student is in-state student
        {
            totalCost = numberOfCredit * creditRate
        }
        else  // if the student is out-state student
        {
            totalCost = 2 * (numberOfCredit * creditRate)
        }

        //check if the student added Dorm , parking , or dining. And add them to the cost
        if(dorm.isChecked()) //check dorm
            totalCost += 5000
        if(dining.isChecked())//check dining
            totalCost += 2000
        if(parking.isChecked())//check parking
            totalCost += 1000

        //return the total cost
        return totalCost
    }

}