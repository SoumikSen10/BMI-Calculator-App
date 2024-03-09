package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity<edtWeight> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btn;
        TextView txtview;
        LinearLayout llmain;

        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtWeight=findViewById(R.id.edtWeight);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        btn=findViewById(R.id.btn);
        txtview=findViewById(R.id.txtview);
        llmain=findViewById(R.id.llmain);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int wt=Integer.parseInt(edtWeight.getText().toString());
                int ht_ft=Integer.parseInt(edtHeightFt.getText().toString());
                int ht_in=Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn=ht_ft*12+ht_in;
                double totalCm=totalIn*2.53; //converting inches to cm
                double totalM=totalCm/100; //converting cm to m
                //height to be used in formula needs to be in M

                double bmi=wt/(Math.pow(totalM,2));

                if(bmi>25)
                {
                     txtview.setText("You are overweight!");
                     llmain.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else if(bmi<18)
                {
                    txtview.setText("You are underweight!");
                    llmain.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else
                {
                    txtview.setText("You are perfectly healthy!");
                    llmain.setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
        });

    }


}