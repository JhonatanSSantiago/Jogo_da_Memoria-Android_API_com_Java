package com.jhonssantiago.jogodamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RespostasActivity extends AppCompatActivity {
    private EditText op1, op2, op3, op4, op5, op6, op7, op8, op9, op10;
    private Button verificar;
    private TextView text;
    private ArrayList<String> ordemCorreta = new ArrayList<>();
    private int pontuação = 0;
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    private LinearLayout lista;
    private String nome, ano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respostas);

        op1 = findViewById(R.id.animal1);
        op2 = findViewById(R.id.animal2);
        op3 = findViewById(R.id.animal3);
        op4 = findViewById(R.id.animal4);
        op5 = findViewById(R.id.animal5);
        op6 = findViewById(R.id.animal6);
        op7 = findViewById(R.id.animal7);
        op8 = findViewById(R.id.animal8);
        op9 = findViewById(R.id.animal9);
        op10 = findViewById(R.id.animal10);
        verificar = findViewById(R.id.verificar);
        text = findViewById(R.id.resultado);
        progressBar = findViewById(R.id.progressbar);
        lista = findViewById(R.id.lista);

        Intent it = getIntent();
        ordemCorreta = it.getStringArrayListExtra("ordemSorteio");
        nome = it.getStringExtra("nome");
        ano = it.getStringExtra("ano");

        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista.setVisibility(View.INVISIBLE);
                verificar.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                new Thread(new Runnable() {
                    public void run() {
                        while (progressStatus <= 100) {
                            progressStatus += 25;
                            handler.post(new Runnable() {
                                public void run() {
                                    progressBar.setProgress(progressStatus);
                                    if(progressStatus==100){
                                        progressBar.setVisibility(View.INVISIBLE);
                                        verificarAcertos();
                                        mostraResultado();
                                        zerar();
                                    }
                                }
                            });
                            try {
                                // Sleep for 200 milliseconds.
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

            }
        });
    }

    private void zerar() {
        pontuação = 0;
        progressStatus = 0;
    }

    private void mostraResultado() {
        text.setText(nome +" vc acertou: "+pontuação+" posições");
        text.setVisibility(View.VISIBLE);
        lista.setVisibility(View.VISIBLE);
        verificar.setVisibility(View.VISIBLE);
    }

    private void verificarAcertos() {
        if(ordemCorreta.get(0).equals(op1.getText().toString().toUpperCase())){
            pontuação += 1;
            op1.setBackgroundColor(Color.GREEN);
        }else{
            op1.setBackgroundColor(Color.RED);
        }
        if(ordemCorreta.get(1).equals(op2.getText().toString().toUpperCase())){
            pontuação += 1;
            op2.setBackgroundColor(Color.GREEN);
        }
        else{
            op2.setBackgroundColor(Color.RED);
        }
        if(ordemCorreta.get(2).equals(op3.getText().toString().toUpperCase())){
            pontuação += 1;
            op3.setBackgroundColor(Color.GREEN);
        }else{
            op3.setBackgroundColor(Color.RED);
        }
        if(ordemCorreta.get(3).equals(op4.getText().toString().toUpperCase())){
            pontuação += 1;
            op4.setBackgroundColor(Color.GREEN);
        }else{
            op4.setBackgroundColor(Color.RED);
        }
        if(ordemCorreta.get(4).equals(op5.getText().toString().toUpperCase())){
            pontuação += 1;
            op5.setBackgroundColor(Color.GREEN);
        }else{
            op5.setBackgroundColor(Color.RED);
        }
        if(ordemCorreta.get(5).equals(op6.getText().toString().toUpperCase())){
            pontuação += 1;
            op6.setBackgroundColor(Color.GREEN);
        }else{
            op6.setBackgroundColor(Color.RED);
        }
        if(ordemCorreta.get(6).equals(op7.getText().toString().toUpperCase())){
            pontuação += 1;
            op7.setBackgroundColor(Color.GREEN);
        }else{
            op7.setBackgroundColor(Color.RED);
        }
        if(ordemCorreta.get(7).equals(op8.getText().toString().toUpperCase())){
            pontuação += 1;
            op8.setBackgroundColor(Color.GREEN);
        }else{
            op8.setBackgroundColor(Color.RED);
        }
        if(ordemCorreta.get(8).equals(op9.getText().toString().toUpperCase())){
            pontuação += 1;
            op9.setBackgroundColor(Color.GREEN);
        }else{
            op9.setBackgroundColor(Color.RED);
        }
        if(ordemCorreta.get(9).equals(op10.getText().toString().toUpperCase())){
            pontuação += 1;
            op10.setBackgroundColor(Color.GREEN);
        }else{
            op10.setBackgroundColor(Color.RED);
        }
    }
}