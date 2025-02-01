package com.example.mybmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editwt,edithtF,edithtI;
        Button btnCalculate;
        TextView result;
        LinearLayout main;

        editwt=findViewById(R.id.editwt);
        edithtF=findViewById(R.id.edithtF);
        edithtI=findViewById(R.id.edithtI);
        btnCalculate=findViewById(R.id.btnCalculate);
        result=findViewById(R.id.result);
        main=findViewById(R.id.main);

        btnCalculate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int wt=Integer.parseInt(editwt.getText().toString());
                int htF=Integer.parseInt(edithtF.getText().toString());
                int htI=Integer.parseInt(edithtI.getText().toString());

                int totalIn=htF*12+htI;
                double totalCm=totalIn*2.53;
                double totalM=totalCm/100;

                double bmi=wt/(Math.pow(totalM,2));
                if(bmi>30){
                    result.setText("OBESE");
                    main.setBackgroundColor(getResources().getColor(R.color.colorObese));
                }
                else if (bmi>=25 && bmi<30) {
                    result.setText("OVER WEIGHT");
                    main.setBackgroundColor(getResources().getColor(R.color.colorOW));
                }
                else if (bmi>=18.5 && bmi<25) {
                    result.setText("NORMAL WEIGHT");
                    main.setBackgroundColor(getResources().getColor(R.color.colorNW));
                }
                else if (bmi<18.5) {
                    result.setText("UNDER WEIGHT");
                    main.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }

            }
        });

    }
}