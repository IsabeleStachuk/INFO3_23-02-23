package com.example.info3_23_02_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AjudaActivity extends AppCompatActivity {
    Button buttonVoltarA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda);

        buttonVoltarA=findViewById(R.id.buttonVoltarA);
        buttonVoltarA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent in = new Intent(AjudaActivity.this, MainActivity.class);
                startActivity(in);

            }
        });
    }
}