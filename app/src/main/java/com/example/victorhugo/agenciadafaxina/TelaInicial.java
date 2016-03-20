package com.example.victorhugo.agenciadafaxina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
    }

    public void proxima_tela(View v){
        Intent proximaTela = new Intent(this,TelaPrincipal.class);
        proximaTela.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(proximaTela);
    }
}
