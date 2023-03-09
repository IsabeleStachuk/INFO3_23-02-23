package com.example.info3_23_02_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmprestarActivity extends AppCompatActivity {
    Button buttonVoltarE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprestar);

        buttonVoltarE=findViewById(R.id.buttonVoltarE);
        buttonVoltarE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent in = new Intent(EmprestarActivity.this, MainActivity.class);
                startActivity(in);

            }
        });
    }
}