package com.example.hw5q5

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    }

    //methods reads the inputs from the interface and calculate the total cost using the model
    fun calculate(view: View)
    {
        //get the number of credit
        var edtTxtNumberOfcredit : EditText = findViewById(R.id.inputNumCredit)
        var strNumberOfcredit : String =  edtTxtNumberOfcredit.getText().toString()
        var numberOfCredit : Int
        try {
            numberOfCredit = strNumberOfcredit.toInt()
        }
        catch (e : NumberFormatException)
        {
            numberOfCredit =0
        }

        //get the academic status
        var academicStatusGroup : RadioGroup = findViewById(R.id.academicStatusRadioGroup)
        var academicStatus : Int = academicStatusGroup.checkedRadioButtonId

        //get the state status
        var stateStatusGroup : RadioGroup = findViewById(R.id.stateStatusRadioGroup)
        var stateStatus : Int = stateStatusGroup.checkedRadioButtonId

        //get the optional boxes

        //get the dormitory check box
        var dormBox : CheckBox = findViewById(R.id.chkBoxDromitory)

        //get the parking checkbox
        var parkingBox : CheckBox = findViewById(R.id.chkBoxParking)

        //get the dining check box
        var diningBox : CheckBox = findViewById(R.id.chkBoxDining)

        //create a model and pass parameters
        var tuitionCalculator =  TuitionCalculator(numberOfCredit,academicStatus,stateStatus,dormBox,parkingBox,diningBox)

        //access the output text view
        var outputView : TextView = findViewById(R.id.txtViewCost)
        outputView.setText(""+tuitionCalculator.getTotalCost())
    }
}