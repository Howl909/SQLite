package com.example.felipe.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

public class BancoController {

    private SQLiteDatabase bd;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String inserir(String titulo, String corpo){
        ContentValues valores;
        long resultado;

        bd = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("titulo", titulo);
        valores.put("conteudo", corpo);

        resultado = bd.insert("notas", null, valores);
        bd.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {"_id","titulo","conteudo"};
        bd = banco.getReadableDatabase();
        cursor = bd.query("notas", campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        bd.close();
        return cursor;
    }


}
