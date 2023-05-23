package com.example.androidsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.androidsqlite.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;

    private static final String DB_NAME = "Alunos.DB";

    private static final int DB_VERSION = 1;

    private static DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding  = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        dbHelper = new DBHelper(this,DB_NAME, null, DB_VERSION);

        mainBinding.saveBTN.setOnClickListener(
                v ->{
                    gravar();
                }
        );
    }

    private void gravar() {

       if (dbHelper.save(
                mainBinding.nomeED.getText().toString(),
                mainBinding.cursoED.getText().toString()
        ) != -1) {
           Toast.makeText(this, "Sucesso", Toast.LENGTH_SHORT).show();
       } else {
           Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
       }
    }
}