package com.langhidev.map;

import java.util.*;
import java.util.function.Function;

public class ExercicioContato {
    public static void main(String[] args) {

        Map<Integer, Contato> listaContatos = new HashMap<>(){{
            put(1, new Contato("Ana", 8888));
            put(4, new Contato("Nick", 5555));
            put(3, new Contato("Yuri", 7777));
        }};

        System.out.println("============ LISTA DE CONTATOS ============");
        System.out.println("------------Ordem Aleatória------------");

        mostrarContatos(listaContatos.entrySet());

        System.out.println("------------Ordem de Inserção------------");

        Map<Integer, Contato> listaContatos1 = new LinkedHashMap<>(){{
            put(1, new Contato("Ana", 8888));
            put(4, new Contato("Nick", 5555));
            put(3, new Contato("Yuri", 7777));
        }};

        mostrarContatos(listaContatos1.entrySet());

        System.out.println("------------Ordem de ID------------");

        Map<Integer, Contato> listaContatos2 = new TreeMap<>(listaContatos1);
        mostrarContatos(listaContatos2.entrySet());

        System.out.println("------------Ordem de Telefone------------");

        Set<Map.Entry<Integer, Contato>> listaContatosSet = new TreeSet<>(Comparator.comparing(contato -> contato.getValue().getNumero()));
        listaContatosSet.addAll(listaContatos.entrySet());

        mostrarContatos(listaContatosSet);

        System.out.println("------------Ordem de Nome------------");

        Set<Map.Entry<Integer, Contato>> listaContatosSet1 = new TreeSet<>(Comparator.comparing(contato -> contato.getValue().getNome()));

        listaContatosSet1.addAll(listaContatos.entrySet());

        mostrarContatos(listaContatosSet1);

    }

    public static void mostrarContatos(Set<Map.Entry<Integer, Contato>> contatos){
        for (Map.Entry<Integer, Contato> contato : contatos) {
            System.out.println("ID = "+contato.getKey() + " - Contato = nome: "+contato.getValue().getNome()+", numero: "+contato.getValue().getNumero());
        }
    }
}

class Contato {
    private String nome;
    private Integer numero;

    public Contato(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return nome.equals(contato.nome) && numero.equals(contato.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numero);
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                '}';
    }
}