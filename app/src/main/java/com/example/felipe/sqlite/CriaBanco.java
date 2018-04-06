package com.example.felipe.sqlite;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CriaBanco extends SQLiteOpenHelper {

    private static final String nomeBD = "banco_bd";
    private static final int versaoBD = 1;

    public CriaBanco(Context ctx){
        super(ctx,nomeBD,null,versaoBD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE notas(_id integer primary key autoincrement,titulo text not null, conteudo text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE notas");
        onCreate(sqLiteDatabase);
    }
}