package com.langhidev.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoList {
    public static void main(String[] args) {

        List<Gato> gatos = new ArrayList<>(){{
            add(new Gato("Mel", 13, "prata"));
            add(new Gato("Ouro", 9, "amarelo"));
            add(new Gato("Chocolate", 18, "marrom"));
            add(new Gato("Ouro", 8, "Abacaxi"));
        }};

        // >>> Ordem de inserção
        System.out.println("Ordem de Inserção");
        System.out.println(gatos);

        // >>> Ordem aleatória
        System.out.println("Ordem aleatória");
        Collections.shuffle(gatos); // Bagunça a lista
        System.out.println(gatos);

        // >>> Ordem natural alfabética (Nome)
        System.out.println("Ordem Alfabética");
        Collections.sort(gatos);
        System.out.println(gatos);

        // >>> Ordem Idade
        System.out.println("Ordem de Idade");
            // Há duas formas de fazer isso
            // 1)
        Collections.sort(gatos, new ComparatorIdade());
            // 2)
        gatos.sort(new ComparatorIdade());

        System.out.println(gatos);

        // >>> Ordem Cor
        System.out.println("Ordem de Cor");
            // Há duas maneiras
            // 1)
        Collections.sort(gatos, new ComparatorCor());
            // 2)
        gatos.sort(new ComparatorCor());

        System.out.println(gatos);

        // >>> Ordem Nome/Cor/Idade
        System.out.println("Ordem de Nome/Cor/Idade");
            // Há duas maneiras
            // 1)
        Collections.sort(gatos, new ComparatorNomeCorIdade());
            // 2)
        gatos.sort(new ComparatorNomeCorIdade());

        System.out.println(gatos);

    }
}

class Gato implements Comparable<Gato>{
    private String nome;
    private int idade;
    private String cor;

    public Gato(String nome, int idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato>{
    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato>{
    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato>{
    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if(nome != 0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if(cor != 0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}