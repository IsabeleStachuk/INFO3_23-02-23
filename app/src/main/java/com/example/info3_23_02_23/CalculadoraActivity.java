package com.example.info3_23_02_23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity {
    EditText txtNumero;
    EditText txtNumero2;
    TextView tvResultado;
    Button buttonSoma;
    private double result;
    double num1;
    double num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        txtNumero = findViewById(R.id.txtNumero);
        txtNumero2 = findViewById(R.id.txtNumero2);
        tvResultado = findViewById(R.id.tvResultado);
        buttonSoma = findViewById(R.id.buttonSoma);

        buttonSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Double.parseDouble(txtNumero.getText().toString());
                num2 = Double.parseDouble(txtNumero2.getText().toString());
                tvResultado = findViewById(R.id.tvResultado);
                result = num1*num2;
                tvResultado.setText(String.valueOf(result));

            }
        });

    }
}



