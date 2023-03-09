package com.example.info3_23_02_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonCadastroCli;
    Button buttonConsultar;
    Button buttonEmprestar;
    Button buttonComprar;
    Button buttonReservar;
    Button buttonAjuda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCadastroCli=findViewById(R.id.buttonCadastroCli);
        buttonCadastroCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent in = new Intent(MainActivity.this, TelaActivity.class);
                startActivity(in);

            }
        });

        buttonConsultar=findViewById(R.id.buttonConsultar);
        buttonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent in = new Intent(MainActivity.this, ConsultarActivity.class);
                startActivity(in);

            }
        });

        buttonEmprestar=findViewById(R.id.buttonEmprestar);
        buttonEmprestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent in = new Intent(MainActivity.this, EmprestarActivity.class);
                startActivity(in);

            }
        });

        buttonComprar=findViewById(R.id.buttonComprar);
        buttonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent in = new Intent(MainActivity.this, ComprarActivity.class);
                startActivity(in);

            }
        });

        buttonReservar=findViewById(R.id.buttonReservar);
        buttonReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent in = new Intent(MainActivity.this, ReservarActivity.class);
                startActivity(in);

            }
        });

        buttonAjuda=findViewById(R.id.buttonAjuda);
        buttonAjuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent in = new Intent(MainActivity.this, AjudaActivity.class);
                startActivity(in);

            }
        });

    }
}