package com.example.info3_23_02_23;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class AcessouserBD extends SQLiteOpenHelper {

    protected static final String TABELA_USUARIO = "TABELA_USUARIO";
    protected static final String USUARIO_ID = "ID";
    protected static final String USUARIO_NOME = "USUARIO_NOME";
    protected static final String USUARIO_SENHA = "USUARIO_SENHA";


    public AcessouserBD(@Nullable Context context) {
        super(context, "ClienteBD", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String statement = "CREATE TABLE " + TABELA_USUARIO +
                " (" + USUARIO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USUARIO_NOME + " TEXT, " + USUARIO_SENHA + " INT)";


        db.execSQL(statement);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean adicionarUsuario(Usuario usuario) {
        //getWritableDatabase() permite a gravação em um banco de dados
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put(USUARIO_NOME, usuario.getNomeUsuario());
        contentValues.put(USUARIO_SENHA, usuario.getSenhaUsuario());

        long inserirSucedido = db.insert(TABELA_USUARIO, null, contentValues);
        db.close();

        //-1 indica que nenhuma linha foi inserida na referida tabela
        return inserirSucedido != -1;


    }


    //Para adicionar um usuário
    public boolean atualizarUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase(); //getWritableDatabase() permite a gravação em um banco de dados

        ContentValues contentValues = new ContentValues();//ContentValues é uma classe que permite armazenar dados agrupados aos pares. Exemplo contentValues.put("nome", value); contentValues.getString("name"). É uma associative array em PHP ou hashmap em outras linguagens.
        contentValues.put(USUARIO_NOME, usuario.getNomeUsuario());
        contentValues.put(USUARIO_SENHA, usuario.getSenhaUsuario());
        contentValues.put(USUARIO_ID, usuario.getIdUsuario());


        long atualizarSucedido = db.update(TABELA_USUARIO, contentValues, USUARIO_ID + "=" + usuario.getIdUsuario(), null);//nullColumnHack é null quando deseja-se adicionar uma linha não nula. Quando intencionalmente deseja inserir uma linha vazia, é necessário informar o valor de uma coluna da tabela usada. No caso da tabela usuário, pode ser nome ou idade.
        db.close();//Sempre fechar o banco de dados após uso.

        //-1 indica que nenhuma linha foi inserida na referida tabela
        return atualizarSucedido != -1;


    }



    public List<Usuario> getListaUsuarios() {

        List<Usuario> listaUsuarios = new ArrayList<>();

        //String queryStatement = "SELECT * FROM TABELA_USUARIO";
        String queryStatement = "SELECT * FROM " + TABELA_USUARIO;//Considere a linha acima para visualizar a sentença como ela é na prática.

        SQLiteDatabase db = this.getReadableDatabase();//Readable para operações de Select. Fechar após uso.


        try (Cursor cursor = db.rawQuery(queryStatement, null)) {


            if (cursor.moveToFirst()) {//moveToFirst retorna true no caso de haver registro(s( proveniente(s) da consulta. Posiciona cursor no primeiro resultado
                //do/while Percorrer o cursor para instanciar objetos da classe Usuario.
                do {
                    int usuarioCod = cursor.getInt(0);//A primeira coluna da tabela usuário é código
                    String usuarioNome = cursor.getString(1);
                    int usuarioIdade = cursor.getInt(2);


                    Usuario usuario = new Usuario(usuarioCod, usuarioNome, usuarioIdade);//Sempre confira a ordem do construtor
                    listaUsuarios.add(usuario);//Adiciona o objeto usuário a lista.
                } while (cursor.moveToNext());//Enquanto houver um próximo registro (moveToNext)
            } else {

            }


        }
        db.close();

        return listaUsuarios;
    }

    public boolean excluirUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString =
                "DELETE FROM " + TABELA_USUARIO + " WHERE " + USUARIO_ID + " = " + usuario.getIdUsuario();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }

    }
}
