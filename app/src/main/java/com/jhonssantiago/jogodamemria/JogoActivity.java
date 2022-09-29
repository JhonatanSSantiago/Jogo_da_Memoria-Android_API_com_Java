package com.jhonssantiago.jogodamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class JogoActivity extends AppCompatActivity {
    private ListView listView;
    private TextView animalQtd;
    private ArrayList<Animal> arrayAnimais = new ArrayList<>();
    private ArrayList<String> lista_nome_animais;
    private ArrayList<Animal> animal = new ArrayList<>();
    private ArrayList<Animal> arrayVazio = new ArrayList<>();
    private int numeroGerado;
    private ArrayList<Integer> arrayNumerosGerados= new ArrayList<>();
    private Animal a;
    private MyAdapter myAdapter;
    private Handler handler = new Handler();
    private int cont = 0;
    private int vezes = 0;
    private ImageView img;
    private int numAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
     //   listView=findViewById(R.id.imageView);
        img=findViewById(R.id.img);
        animalQtd=findViewById(R.id.animalQtd);
        preencherListaNomeAnimais();
        criarListaAnimais();

        new Thread(new Runnable() {
            public void run() {
                while (vezes < 10) {
                    vezes += 1;
                    handler.post(new Runnable() {
                        public void run() {
                                gerarNumero();
                                gerarAnimal();
                                gerarImagens();
                             //   mostraTela();
                            animalQtd.setText("Animal Nº "+vezes);
                           // Toast.makeText(getApplicationContext(), "numero:" +numeroGerado, Toast.LENGTH_SHORT).show();
                            if(vezes==10){
                                Intent it = new Intent(getApplicationContext(), RespostasActivity.class);
                                startActivity(it);
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

//    private void mostraTela() {
//        myAdapter = new MyAdapter(getApplicationContext(), animal);
//        listView.setAdapter(myAdapter);
//    }

    private void gerarImagens(){
        if(numAnimal == 0){
            Drawable d = getDrawable(R.drawable.borboleta);
            img.setImageDrawable(d);
        }
        if(numAnimal == 1){
            Drawable d = getDrawable(R.drawable.cavalo);
            img.setImageDrawable(d);
        }
        if(numAnimal == 2){
            Drawable d = getDrawable(R.drawable.dinossauro);
            img.setImageDrawable(d);
        }
        if(numAnimal == 3){
            Drawable d = getDrawable(R.drawable.elefante);
            img.setImageDrawable(d);
        }
        if(numAnimal == 4){
            Drawable d = getDrawable(R.drawable.galinha);
            img.setImageDrawable(d);
        }
        if(numAnimal == 5){
            Drawable d = getDrawable(R.drawable.gato);
            img.setImageDrawable(d);
        }
        if(numAnimal == 6){
            Drawable d = getDrawable(R.drawable.serpente);
            img.setImageDrawable(d);
        }
        if(numAnimal == 7){
            Drawable d = getDrawable(R.drawable.tartaruga_marinha);
            img.setImageDrawable(d);
        }
        if(numAnimal == 8){
            Drawable d = getDrawable(R.drawable.tubarao);
            img.setImageDrawable(d);
        }
        if(numAnimal == 9){
            Drawable d = getDrawable(R.drawable.vaca);
            img.setImageDrawable(d);
        }
    }

    private void gerarNumero(){
        int numRand = new Random().nextInt(10);
        if(arrayNumerosGerados.contains(numRand)==true){
            gerarNumero();
        }else{
            arrayNumerosGerados.add(numRand);
            numeroGerado = numRand;
        }
    }

    private void gerarAnimal(){
        animal.add(arrayAnimais.get(numeroGerado));
        numAnimal = numeroGerado;
    }

    private void preencherListaNomeAnimais(){
        lista_nome_animais = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_animais)));
    }

    public void criarListaAnimais() {
        Animal borboleta = new Animal(R.drawable.borboleta, lista_nome_animais.get(0).toString());
        Animal cavalo = new Animal(R.drawable.cavalo, lista_nome_animais.get(1).toString());
        Animal dinossauro = new Animal(R.drawable.dinossauro, lista_nome_animais.get(2).toString());
        Animal elefante = new Animal(R.drawable.elefante, lista_nome_animais.get(3).toString());
        Animal galinha = new Animal(R.drawable.galinha, lista_nome_animais.get(4).toString());
        Animal gato = new Animal(R.drawable.gato, lista_nome_animais.get(5).toString());
        Animal serpente = new Animal(R.drawable.serpente, lista_nome_animais.get(6).toString());
        Animal tartaruga = new Animal(R.drawable.tartaruga_marinha, lista_nome_animais.get(7).toString());
        Animal tubarao = new Animal(R.drawable.tubarao, lista_nome_animais.get(8).toString());
        Animal vaca = new Animal(R.drawable.vaca, lista_nome_animais.get(9).toString());

        arrayAnimais.add(borboleta);
        arrayAnimais.add(cavalo);
        arrayAnimais.add(dinossauro);
        arrayAnimais.add(elefante);
        arrayAnimais.add(galinha);
        arrayAnimais.add(gato);
        arrayAnimais.add(serpente);
        arrayAnimais.add(tartaruga);
        arrayAnimais.add(tubarao);
        arrayAnimais.add(vaca);
    }
}