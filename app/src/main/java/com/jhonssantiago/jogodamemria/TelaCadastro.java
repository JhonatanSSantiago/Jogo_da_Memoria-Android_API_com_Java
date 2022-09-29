package com.jhonssantiago.jogodamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaCadastro extends AppCompatActivity {
    private EditText nomeUsuario, anoNascimentoUsuario;
    private Button buttonIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        nomeUsuario = findViewById(R.id.nomeUsuario);
        anoNascimentoUsuario = findViewById(R.id.anoNascimentoUsuario);
        buttonIniciar = findViewById(R.id.buttonIniciar);

        buttonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), JogoActivity.class);
                it.putExtra("nome", nomeUsuario.getText().toString());
                it.putExtra("ano", anoNascimentoUsuario.getText().toString());
                startActivity(it);
            }
        });
    }
}