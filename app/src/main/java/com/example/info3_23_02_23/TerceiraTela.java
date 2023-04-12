package com.example.info3_23_02_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TerceiraTela extends AppCompatActivity {
    private EditText numberDias;
    Button buttonVoltarSeg;
    Button buttonValorTotal;
    double num1;
    double num2 = 500;
    TextView textResult;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira_tela);

        numberDias = findViewById(R.id.numberDias);
        buttonValorTotal = findViewById(R.id.buttonValorTotal);


        buttonValorTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Double.parseDouble(numberDias.getText().toString());
                textResult = findViewById(R.id.textResult);
                result = num1*num2;
                textResult.setText(String.valueOf(result));

            }
        });
        buttonVoltarSeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(TerceiraTela.this, LocadoraActivity.class);
                startActivity(in);

            }
        });

    }
}