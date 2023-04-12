package com.example.info3_23_02_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {
    private EditText numberDiasSe;

    Button buttonValorTotalSe;

    Button buttonVoltarPri;

    double num1Se;
    double num2Se = 600;
    TextView textResultSe;
    double resultSe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        numberDiasSe = findViewById(R.id.numberDiasSe);
        buttonValorTotalSe = findViewById(R.id.buttonValorTotalSe);

        buttonValorTotalSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1Se = Double.parseDouble(numberDiasSe.getText().toString());
                textResultSe = findViewById(R.id.textResult);
                resultSe = num1Se *num2Se;
                textResultSe.setText(String.valueOf(resultSe));

            }
        });
        buttonVoltarPri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(SegundaTela.this, LocadoraActivity.class);
                startActivity(in);

            }
        });
    }
}