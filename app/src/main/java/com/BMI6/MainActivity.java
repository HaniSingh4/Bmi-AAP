package com.BMI6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.BMI6.R.id;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btnCalculate;
        TextView textResult;
        LinearLayout llMain;
        edtWeight =findViewById(R.id.edtWeight);
        edtHeightFt=findViewById(R.id.edtHeight);
        edtHeightIn=findViewById(R.id.edtHeight2t);
        btnCalculate=findViewById(R.id.btnCalculate);
        textResult=findViewById(R.id.text);
        llMain= findViewById(id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt=Integer.parseInt(edtWeight.getText().toString());
               int ft= Integer.parseInt(edtHeightFt.getText().toString());
            int in=Integer.parseInt(edtHeightIn.getText().toString());
            int totalIn=ft*12+in;
            double totalCm=totalIn*2.53;
            double totalM =totalCm/100;
            double bmi=wt/(totalM*totalM);
            if(bmi>25)
            {
                textResult.setText("You're Overweight");
                llMain.setBackgroundColor(getResources().getColor(R.color.colorOw));
            }
            else if(bmi<18){
                textResult.setText("You're Underweight");
                llMain.setBackgroundColor(getResources().getColor(R.color.colorUw));
            }
            else {
                textResult.setText("You're Healthy ");
                llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
            }

            }
        });

    }
}