package com.example.info3_23_02_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LocadoraActivity extends AppCompatActivity {
    Button alugarKwid;
    Button alugarBYD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locadora);

        alugarKwid = findViewById(R.id.alugarKwid);
        alugarKwid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(LocadoraActivity.this, TerceiraTela.class);
                startActivity(in);

            }
        });
        alugarBYD = findViewById(R.id.alugarBYD);
        alugarBYD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(LocadoraActivity.this, SegundaTela.class);
                startActivity(in);

            }
        });
    }
}