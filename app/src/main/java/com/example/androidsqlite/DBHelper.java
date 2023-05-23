package com.example.androidsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper{

    private  static final String TABLE_NAME = "ALUNOS";

    private  static final String _ID = "id";
    private  static final String NOME = "nome";
    private  static final String CURSO = "curso";

    private  static final String CREATE_TABLE = "CREATE TABLE "
            + TABLE_NAME + " ( " +_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NOME + " TEXT NOT NULL, " + CURSO + " TEXT );" ;


    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public long save(String nome, String curso){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOME, nome);
        values.put(CURSO, curso);


        long insert = sqLiteDatabase.insert(TABLE_NAME, null, values);
        sqLiteDatabase.close();
        return insert;
    }

}
