package com.jhonssantiago.jogodamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //
                Intent it = new Intent(getActivity(), TelaCadastro.class);
                startActivity(it);
            }
        }, 1000);

    }

    public Context getActivity(){
        return this;

    }
}