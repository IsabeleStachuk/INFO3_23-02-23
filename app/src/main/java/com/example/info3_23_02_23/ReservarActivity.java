package com.example.info3_23_02_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReservarActivity extends AppCompatActivity {
    Button buttonVoltarR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar);

        buttonVoltarR=findViewById(R.id.buttonVoltarR);
        buttonVoltarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent in = new Intent(ReservarActivity.this, MainActivity.class);
                startActivity(in);

            }
        });
    }
}