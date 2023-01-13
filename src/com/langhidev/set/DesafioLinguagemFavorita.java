package com.langhidev.set;

import java.util.*;

/**
 * Exercício Proposto:
 * Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e ide. Em seguida, crie um
 * conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
 * A) Ordem de Inserção;
 * B) Ordem Natural (nome);
 * C) IDE;
 * D) Ano de criação e nome;
 * E) Nome, ano de criação e IDE.
 * Ao final, exiba as linguagens no console, um abaixo da outra.
 * */
public class DesafioLinguagemFavorita {
    public static void main(String[] args) {

        Set<LinguagemFavorita> linguagens = new HashSet<>(){{
            add(new LinguagemFavorita("Python", 1991, "PyCharm IDE"));
            add(new LinguagemFavorita("JavaScript", 1995, "VS Code"));
            add(new LinguagemFavorita("Java", 1991, "IntelliJ"));
        }};

        System.out.println("======= LINGUAGENS DE PROGRAMAÇÃO E IDES =======");

        // >>> A) Ordem de Inserção
        Set<LinguagemFavorita> linguagensOrdem = new LinkedHashSet<>(){{
            add(new LinguagemFavorita("Python", 1991, "PyCharm IDE"));
            add(new LinguagemFavorita("JavaScript", 1995, "VS Code"));
            add(new LinguagemFavorita("Java", 1991, "IntelliJ"));
        }};
        System.out.println("Em Ordem de Inserção: "+linguagensOrdem);

        // >>> B) Ordem Natural (nome)
        Set<LinguagemFavorita> linguagens2 = new TreeSet<>(linguagensOrdem);
        System.out.println("Em Ordem Alfabética: "+linguagens2);

        // >>> C) IDE
        Set<LinguagemFavorita> linguagemIde = new TreeSet<>(new ComparatorIde());
        linguagemIde.addAll(linguagens);
        System.out.println("Em Ordem Alfabética de IDE: "+linguagemIde);

        // >>> D) Ano de criação e nome
        Set<LinguagemFavorita> linguagemAnoNome = new TreeSet<>(new ComparatorAnoNome());
        linguagemAnoNome.addAll(linguagens);
        System.out.println("Em Ordem de Ano: "+linguagemAnoNome);

        // >>> E) Nome, ano de criação e IDE
        Set<LinguagemFavorita> linguagens3 = new TreeSet<>(new ComparatorNomeAnoIde());
        linguagens3.addAll(linguagens);
        System.out.println("Por Ordem de tudo: "+linguagens3);

        System.out.println("=-=-=-=-=- LINGUAGENS FAVORITAS =-=-=-=-=-");
        for (LinguagemFavorita linguagem :
                linguagens) {
            System.out.println(linguagem.getNome()+" ~ Desde "+linguagem.getAnoDeCriacao()+" ~ "+linguagem.getIde());
        }
    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    private String nome;
    private Integer anoDeCriacao;
    private String ide;

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    @Override
    public int compareTo(LinguagemFavorita linguagem) {
        return this.getNome().compareToIgnoreCase(linguagem.getNome());
    }
}

class ComparatorIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        return l1.getIde().compareToIgnoreCase(l2.getIde());
    }
}

class ComparatorAnoNome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int ano = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
        if(ano != 0) return ano;

        return l1.getNome().compareToIgnoreCase(l2.getNome());
    }
}

class ComparatorNomeAnoIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int nome = l1.getNome().compareToIgnoreCase(l2.getNome());
        if(nome != 0) return nome;

        int ano = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
        if(ano != 0) return ano;

        return l1.getIde().compareToIgnoreCase(l2.getIde());
    }
}