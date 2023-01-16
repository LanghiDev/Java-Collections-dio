package com.langhidev.map;

import java.util.*;

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

        Set<Map.Entry<Integer, Contato>> listaContatosSet = new TreeSet<>(new ComparatorNumero());
        listaContatosSet.addAll(listaContatos.entrySet());

        mostrarContatos(listaContatosSet);

        System.out.println("------------Ordem de Nome------------");

        Set<Map.Entry<Integer, Contato>> listaContatosSet1 = new TreeSet<>(new ComparatorNomeContato());
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

class ComparatorNumero implements Comparator<Map.Entry<Integer, Contato>>{
    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return Integer.compare(c1.getValue().getNumero(), c2.getValue().getNumero());
    }
}

class ComparatorNomeContato implements Comparator<Map.Entry<Integer, Contato>>{
    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return c1.getValue().getNome().compareToIgnoreCase(c2.getValue().getNome());
    }
}