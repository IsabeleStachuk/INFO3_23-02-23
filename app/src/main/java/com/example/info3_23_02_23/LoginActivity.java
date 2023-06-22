package com.example.info3_23_02_23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btAddUsuario;
    Button btListUsuario;
    Button btAtualizarUsuario;
    EditText etNomeUsuario;
    EditText etSenhaUsuario;
    EditText etCodigoUsuario;
    ListView lUsuario;

    ArrayAdapter usuarioArrayAdapter;

    AcessouserBD acessouserBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }
}