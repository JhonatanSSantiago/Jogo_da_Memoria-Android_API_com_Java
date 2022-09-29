package com.jhonssantiago.jogodamemria;

public class Animal {
    private int imagem;
    private String nome;

    public Animal(int imagem, String nome) {
        this.imagem = imagem;
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "imagem=" + imagem +
                ", nome='" + nome + '\'' +
                '}';
    }
}
