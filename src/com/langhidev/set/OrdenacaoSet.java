package com.langhidev.set;

import java.util.*;

public class OrdenacaoSet {
    public static void main(String[] args) {

        System.out.println("==========SÉRIES QUE EU GOSTO==========");
        System.out.println("-=-=-=-=-=-=Ordem Aleatória-=-=-=-=-=-=");
        Set<Serie> seriesTop = new HashSet<>(){{
            add(new Serie("A Misteriosa Sociedade Benedict", "Mistério", 55));
            add(new Serie("The Mandalorian", "Western Espacial", 48));
            add(new Serie("Doctor Who", "Ficção científica", 30));
        }};

        mostrarSeries(seriesTop);

        System.out.println("\n-=-=-=-=-=-=Ordem de Inserção-=-=-=-=-=-=");
        Set<Serie> seriesTop1 = new LinkedHashSet<>(){{
            add(new Serie("A Misteriosa Sociedade Benedict", "Mistério", 55));
            add(new Serie("The Mandalorian", "Western Espacial", 48));
            add(new Serie("Doctor Who", "Ficção científica", 48));
        }};

        mostrarSeries(seriesTop1);

        System.out.println("\n-=-=-=-=-=-=Ordem Natural (Alfabética)-=-=-=-=-=-=");
        Set<Serie> seriesTop2 = new TreeSet<>(seriesTop1);

        mostrarSeries(seriesTop2);

        System.out.println("\n-=-=-=-=-=-=Ordem Nome/Genero/TempoEpisodio-=-=-=-=-=-=");
        Set<Serie> seriesTop3 = new TreeSet<>(new ComparatorNomeGeneroTempoEp());
        seriesTop3.addAll(seriesTop);

        mostrarSeries(seriesTop3);

        // Exercício para fazer
        System.out.println("\n-=-=-=-=-=-=Ordem de Gênero-=-=-=-=-=-=");
        Set<Serie> seriesTopGenero = new TreeSet<>(new ComparatorGenero());
        seriesTopGenero.addAll(seriesTop);

        mostrarSeries(seriesTopGenero);

        System.out.println("\n-=-=-=-=-=-=Ordem de Tempo de Episódio-=-=-=-=-=-=");
        Set<Serie> seriesTopTempEp = new TreeSet<>(new ComparatorTempoEp());
        seriesTopTempEp.addAll(seriesTop);

        mostrarSeries(seriesTopTempEp);
    }

    public static void mostrarSeries(Set<Serie> series){
        for (Serie serie : series) {
            System.out.println(serie.getNome() + " ~ "+ serie.getGenero()+" ~ "+serie.getTempoEpisodio());
        }
    }
}

class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        if(tempoEpisodio != 0) return tempoEpisodio;

        int genero = this.getGenero().compareToIgnoreCase(serie.getGenero());
        if(genero != 0) return genero;

        return this.getNome().compareToIgnoreCase(serie.getNome());
    }
}

class ComparatorNomeGeneroTempoEp implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
        if(nome != 0) return nome;

        int genero = s1.getGenero().compareToIgnoreCase(s2.getGenero());
        if(genero != 0) return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}

class ComparatorGenero implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        return s1.getGenero().compareToIgnoreCase(s2.getGenero());
    }
}

class ComparatorTempoEp implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}