package com.example.info3_23_02_23;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AcessoBD extends SQLiteOpenHelper {

    protected static final String TABELA_CARRO = "TABELA_CARRO";
    protected static final String CARRO_ID = "ID";
    protected static final String CARRO_NOME = "CARRO_NOME";
    protected static final String CARRO_PLACA = "CARRO_PLACA";


    public AcessoBD(@Nullable Context context) {
        super(context, "ClienteBD", null, 1);
    }

    //É chamado na primeira vez que o banco de Dados(BD) é acessado.
    //Usado também para a criação do banco de dados
    @Override
    public void onCreate(SQLiteDatabase db) {
        String statement = "CREATE TABLE " + TABELA_CARRO +
                " (" + CARRO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CARRO_NOME + " TEXT, " + CARRO_PLACA + " INT)";


        //"CREATE TABLE TABELA_USUARIO(USUARIO_ID INTEGER PRIMARY KEY AUTOINCREMENT, USUARIO_NOME TEXT, USUARIO_IDADE INT)";
        db.execSQL(statement);
    }

    //Atualiza a versão do BD.
    //Permite que usuários antigos e novos usem a aplicação mesmo com o BD sofrendo manutenção
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //INSERT INTO tabela_usuario(id, nome, idade) values (1,"Ronan", 30)
    //Para adicionar um usuário
    public boolean adicionarCarro(Carro carro) {
        //getWritableDatabase() permite a gravação em um banco de dados
        SQLiteDatabase db = this.getWritableDatabase();

        //ContentValues é uma classe que permite armazenar dados agrupados aos pares. Exemplo contentValues.put("nome", value); contentValues.getString("name"). É uma associative array em PHP ou hashmap em outras linguagens.
        ContentValues contentValues = new ContentValues();
        contentValues.put(CARRO_NOME, carro.getNomeCarro());//coluna nome e valor
        contentValues.put(CARRO_PLACA, carro.getPlacaCarro());//coluna idade e valor
        //Por quê não tem o ID aqui? Porque o ID é tem incremento automático (AUTOINCREMENT). Veja a linha "CREATE TABLE..." dentro do método onCreate.

        //nullColumnHack é null quando deseja-se adicionar uma linha não nula. Quando intencionalmente deseja inserir uma linha vazia, é necessário informar o valor de uma coluna da tabela usada. No caso da tabela usuário, pode ser nome ou idade.
        long inserirSucedido = db.insert(TABELA_CARRO, null, contentValues);
        db.close();//Sempre fechar o banco de dados após uso.

        //-1 indica que nenhuma linha foi inserida na referida tabela
        return inserirSucedido != -1;


    }


    //Para adicionar um usuário
    public boolean atualizarCarro(Carro carro) {
        SQLiteDatabase db = this.getWritableDatabase(); //getWritableDatabase() permite a gravação em um banco de dados

        ContentValues contentValues = new ContentValues();//ContentValues é uma classe que permite armazenar dados agrupados aos pares. Exemplo contentValues.put("nome", value); contentValues.getString("name"). É uma associative array em PHP ou hashmap em outras linguagens.
        contentValues.put(CARRO_NOME, carro.getNomeCarro());
        contentValues.put(CARRO_PLACA, carro.getPlacaCarro());
        contentValues.put(CARRO_ID, carro.getIdCarro());
        //Por quê não tem o ID aqui? Porque o ID é tem incremento automático (AUTOINCREMENT). Veja a linha "CREATE TABLE..." dentro do método onCreate.

        long atualizarSucedido = db.update(TABELA_CARRO, contentValues, CARRO_ID + "=" + carro.getIdCarro(), null);//nullColumnHack é null quando deseja-se adicionar uma linha não nula. Quando intencionalmente deseja inserir uma linha vazia, é necessário informar o valor de uma coluna da tabela usada. No caso da tabela usuário, pode ser nome ou idade.
        db.close();//Sempre fechar o banco de dados após uso.

        //-1 indica que nenhuma linha foi inserida na referida tabela
        return atualizarSucedido != -1;


    }


    /**
     * Método para retornar a lista de usuarios completa.
     * Cria uma lista (listaUsuarios) vazia para preenchimento com as tuplas resultantes da consulta no banco de dados.
     *
     * @return List de objetos Usuario
     */
    public List<Carro> getListaUsuarios() {//Para importar List, pode ser usado o atalho com Alt+Enter (para escolher a ação) ou Shift+Alt+Enter (para pegar o pacote sugerido pela ferramenta Android Studio). Tem que ser do pacote "java.util.List"

        List<Carro> listaCarro = new ArrayList<>();

        //String queryStatement = "SELECT * FROM TABELA_USUARIO";
        String queryStatement = "SELECT * FROM " + TABELA_CARRO;//Considere a linha acima para visualizar a sentença como ela é na prática.

        SQLiteDatabase db = this.getReadableDatabase();//Readable para operações de Select. Fechar após uso.

        //O retorno Cursor serve para receber o resultado do banco e navegar entre os resultados. Fechar após uso.
        //selectionArgs é usado para preencher os parâmetros da SQL para os campus da cláusula WHERE
        try (Cursor cursor = db.rawQuery(queryStatement, null)) {
            //Exemplo com selectionArgs ->
            // rawQuery("SELECT ID, USUARIO_NOME, USUARIO_IDADE FROM TABELA_USUARIO WHERE id = ? AND USUARIO_NOME = ? AND USUARIO_IDADE = ?", new String[] {"1", "David", "2"});
            //rawQuery("SELECT ID, USUARIO_NOME, USUARIO_IDADE FROM TABELA_USUARIO WHERE id = 1 AND USUARIO_NOME = David AND USUARIO_IDADE = 2",null);

            if (cursor.moveToFirst()) {//moveToFirst retorna true no caso de haver registro(s( proveniente(s) da consulta. Posiciona cursor no primeiro resultado
                //do/while Percorrer o cursor para instanciar objetos da classe Usuario.
                do {
                    int carroCod = cursor.getInt(0);//A primeira coluna da tabela usuário é código
                    String carroNome = cursor.getString(1);
                    int carroPlaca = cursor.getInt(2);
                    //int usuarioIdade = cursor.getInt(cursor.getColumnIndex("idade"));
                    //String dataNascimentoUsuario = cursor.getString(3);
                    //Não há cursor.getBoolean. Precisa converter um int para boolean. Pode ser feito com cast, SE/ENTÃO ou operador ternário

                    Carro carro = new Carro(carroCod, carroNome, carroPlaca);//Sempre confira a ordem do construtor
                    listaCarro.add(carro);//Adiciona o objeto usuário a lista.
                } while (cursor.moveToNext());//Enquanto houver um próximo registro (moveToNext)
            } else {
                //A lista está vazia por falta de registro no banco de dados.
            }

            //fechar cursor e base de dados. Com isso, permite que outras pessoas/processos possam utilizar.

            cursor.close();
        }
        db.close();//Fechar o banco de dados para liberar memória e permitir que outros processos assumam a prioridade de consulta de maneira mais rápida

        return listaCarro; //retorna a lista com os usuários encontrados no banco de dados
    }


    /**
     * Método para encontrar um usuário no banco de dados e excluí-lo.
     *
     * @param carro
     * @return true no caso do usuário ser encontrado e excluído
     */
    public boolean excluirUsuario(Carro carro) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString =
                "DELETE FROM " + TABELA_CARRO + " WHERE " + CARRO_ID + " = " + carro.getIdCarro();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }

    }
}