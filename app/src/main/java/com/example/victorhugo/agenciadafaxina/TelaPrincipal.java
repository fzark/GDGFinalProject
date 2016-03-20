package com.example.victorhugo.agenciadafaxina;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Date;

public class TelaPrincipal extends AppCompatActivity {

    CheckBox dom, seg, ter, qua, qui, sex, sab;
    EditText email;
    TimePicker inicio, fim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        dom = (CheckBox) findViewById(R.id.dom_dia);
        seg = (CheckBox) findViewById(R.id.seg_dia);
        ter = (CheckBox) findViewById(R.id.ter_dia);
        qua = (CheckBox) findViewById(R.id.qua_dia);
        qui = (CheckBox) findViewById(R.id.qui_dia);
        sex = (CheckBox) findViewById(R.id.sex_dia);
        sab = (CheckBox) findViewById(R.id.sab_dia);

        inicio = (TimePicker) findViewById(R.id.time_inicial);
        fim = (TimePicker) findViewById(R.id.time_final);
        email = (EditText) findViewById(R.id.email);
    }

    public void reset(View v) {
        dom.setChecked(false);
        seg.setChecked(false);
        ter.setChecked(false);
        qua.setChecked(false);
        qui.setChecked(false);
        sex.setChecked(false);
        sab.setChecked(false);
        email.setText("");
    }

    public void agendar(View v) {
        int diferenca = (inicio.getHour() * 60 + inicio.getMinute()) - (fim.getHour() * 60 + fim.getMinute());

        if (!(dom.isChecked() || seg.isChecked() || ter.isChecked() || qua.isChecked() || qui.isChecked() || sex.isChecked() || sab.isChecked())) {
            Toast.makeText(getApplicationContext(), "Marque pelo menos um dia da semana!", Toast.LENGTH_SHORT).show();
        } else if (diferenca == 0 || diferenca < 60) {
            Toast.makeText(getApplicationContext(), "Insira horário válido!", Toast.LENGTH_SHORT).show();
        } else if (email.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Insira um email válido!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Agendado com Sucesso!", Toast.LENGTH_SHORT).show();
        }
    }
}
