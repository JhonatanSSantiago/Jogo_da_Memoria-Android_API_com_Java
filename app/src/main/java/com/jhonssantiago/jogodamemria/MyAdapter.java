package com.jhonssantiago.jogodamemria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Animal> animals;

    public MyAdapter(Context context, ArrayList<Animal> animals){
        this.animals = animals;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return animals.size();
    }

    @Override
    public Object getItem(int i) {
        return animals.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Animal a = animals.get(i);

        view = inflater.inflate(R.layout.imagem, null); //view vazia
        ImageView img = view.findViewById(R.id.imagemPerso);
        img.setImageResource(a.getImagem());

        return view;
    }
}
