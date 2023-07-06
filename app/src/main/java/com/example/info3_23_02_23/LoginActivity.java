package com.example.info3_23_02_23;

import android.annotation.SuppressLint;
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

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
public class LoginActivity extends AppCompatActivity {

    Button btAddCarro;
    Button btListCarro;
    Button btAtualizarCarro;
    EditText etNomeCarro;
    EditText etPlacaCarro;
    EditText etCodigoCarro;
    ListView lCarro;
    ArrayAdapter carroArrayAdapter;
    AcessoBD acessoBD;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btAddCarro = findViewById(R.id.btAddCarro);
        btListCarro = findViewById(R.id.btListCarro);
        btAtualizarCarro = findViewById(R.id.btAtualizarCarro);
        etNomeCarro = findViewById(R.id.etNomeCarro);
        etPlacaCarro = findViewById(R.id.etPlacaCarro);
        etCodigoCarro = findViewById(R.id.etCodigoCarro);
        lCarro = findViewById(R.id.lCarro);

        acessoBD = new AcessoBD(LoginActivity.this);
        mostrarCarrosNaListView(acessoBD);

        btAddCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui acontece a ação

                //Declaração de um objeto usuário da (nossa) classe Usuário
                Carro carro = null;//null para inicializar

                //Bloco try para "tentar" executar as ações esperadas. O catch é para "remediar" ou "avisar" algo que não foi realizado no bloco try como esperado.
                try {
                    carro = new Carro(-1,
                            etNomeCarro.getText().toString(),
                            etPlacaCarro.getText().toString());
                    boolean sucesso = acessoBD.adicionarCarro(carro);
                    mostrarCarrosNaListView(acessoBD);
                    Toast.makeText(LoginActivity.this, "Sucesso:" + sucesso, Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(LoginActivity.this, "Erro na conversão de uma String para int: Idade não corresponde a número!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(LoginActivity.this, "Erro na criação do usuário!", Toast.LENGTH_LONG).show();
                }
            }


        });

        btListCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui acontece a ação

                   /* //AcessoBD acessoBD = new AcessoBD(MainActivity.this);
                    List<Usuario> todosUsuarios = acessoBD.getListaUsuarios();//Dentro de <> está o tipo de usuário a ser inserido na lista
                    usuarioArrayAdapter = new ArrayAdapter<Usuario>(MainActivity.this, android.R.layout.simple_list_item_1, acessoBD.getListaUsuarios());//Dentro de <> está o tipo de objeto que será adicionado na lista
                    //Para o próximo passo, adicionar no content_main.xml o objeto da pallete que encontra-se em Legacy/ListView. É só arrastar o ListView para a tela. Fazer os ajustes de ancoragem.
                    //Também adicionar a variável aqui em MainActivity e associar ela ao componente com findViewById.
                    lvUsuarios.setAdapter(usuarioArrayAdapter);*/

                mostrarCarrosNaListView(acessoBD);

                Toast.makeText(LoginActivity.this, "Lista de usuários preenchida com sucesso", Toast.LENGTH_SHORT).show();


            }
        });


        /**
         * Evento de click na lista de usuários na intenção de excluir o usuário clicado.
         */
        lCarro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                System.out.println("Captou click na lista!");
                Carro carroClicado = (Carro) parent.getItemAtPosition(position);
                boolean excluiu = acessoBD.excluirUsuario(carroClicado);

                mostrarCarrosNaListView(acessoBD);

                Toast.makeText(LoginActivity.this, "Usuário excluído(" + excluiu + "):" + carroClicado.toString(), Toast.LENGTH_SHORT).show();


            }
        });

        btAtualizarCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui acontece a ação

                //Declaração de um objeto usuário da (nossa) classe Usuário
                Carro carro = null;//null para inicializar

                //Bloco try para "tentar" executar as ações esperadas. O catch é para "remediar" ou "avisar" algo que não foi realizado no bloco try como esperado.
                try {
                    carro = new Carro(Integer.parseInt(etCodigoCarro.getText().toString()), etNomeCarro.getText().toString(), etPlacaCarro.getText().toString());

                    boolean sucesso = acessoBD.atualizarCarro(carro);

                    mostrarCarrosNaListView(acessoBD);
                    Toast.makeText(LoginActivity.this, "Sucesso:" + sucesso, Toast.LENGTH_SHORT).show();

                } catch (NumberFormatException e) {
                    Toast.makeText(LoginActivity.this, "Erro na conversão de uma String para int: Idade não corresponde a número!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(LoginActivity.this, "Erro na criação do usuário!", Toast.LENGTH_LONG).show();
                    carro = new Carro(-1, "erro", "erro");
                }

            }
        });




    }



    private void mostrarCarrosNaListView(AcessoBD acessoBD) {
        carroArrayAdapter = new ArrayAdapter<Carro>(LoginActivity.this,
                android.R.layout.simple_list_item_1, acessoBD.getListCarros());//Dentro de <> está o tipo de objeto que será adicionado na lista
        lCarro.setAdapter(carroArrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}