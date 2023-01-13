package com.langhidev.map;

import java.util.*;

public class OrdenacaoMap {
    public static void main(String[] args) {

        // Ordem Aleatória
        System.out.println("-=-=-=-ORDEM ALEATÓRIA-=-=-=-");
        Map<String, Livro> livraria = new HashMap<>(){{
            put("Júlio Verne", new Livro("Volta ao mundo em 80 dias", 250));
            put("H.G. Wells", new Livro("A Máquina do Tempo", 310));
            put("Douglas Adams", new Livro("O guia do mochileiro das galáxias", 110));
        }};

        mostrarLivros(livraria.entrySet());

        // Ordem de Inserção
        System.out.println("-=-=-=-ORDEM DE INSERÇÃO-=-=-=-");
        Map<String, Livro> livraria1 = new LinkedHashMap<>(){{
            put("Júlio Verne", new Livro("Volta ao mundo em 80 dias", 250));
            put("H.G. Wells", new Livro("A Máquina do Tempo", 310));
            put("Douglas Adams", new Livro("O guia do mochileiro das galáxias", 110));
        }};

        mostrarLivros(livraria1.entrySet());

        // Ordem Alfabética de autores
        System.out.println("-=-=-=-ORDEM ALFABÉTICA (AUTORES)-=-=-=-");
        Map<String, Livro> livraria2 = new TreeMap<>(livraria1);
        mostrarLivros(livraria2.entrySet());

        // Ordem Alfabética dos livros
        System.out.println("-=-=-=-ORDEM ALFABÉTICA (LIVROS)-=-=-=-");
        Set<Map.Entry<String, Livro>> livraria3 = new TreeSet<>(new ComparatorNome());
        livraria3.addAll(livraria.entrySet());
        mostrarLivros(livraria3);

        // Ordem número da página
        System.out.println("-=-=-=-ORDEM POR PÁGINAS-=-=-=-");
        Set<Map.Entry<String, Livro>> livraria4 = new TreeSet<>(new ComparatorPagina());
        livraria4.addAll(livraria.entrySet());
        mostrarLivros(livraria4);

    }

    public static void mostrarLivros(Set<Map.Entry<String, Livro>> livros){
        // Mostrando o nome do autor e o nome do livro
        for (Map.Entry<String, Livro> livro : livros) {
            System.out.println(livro.getValue().getNome()+" - "+livro.getKey());
        }
    }
}

class Livro{
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPagina implements Comparator<Map.Entry<String, Livro>>{
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return Integer.compare(l1.getValue().getPaginas(), l2.getValue().getPaginas());
    }
}