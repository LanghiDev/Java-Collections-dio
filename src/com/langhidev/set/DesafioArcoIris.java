package com.langhidev.set;

import java.util.*;

/**
 * Exercício Proposto
 * Crie um conjunto contendo as cores do arco-íris e:
 * A) Exiba todas as cores uma abaixo da outra.
 * B) A quantidade de cores que o arco-íris tem.
 * C) Exiba as cores em ordem alfabética.
 * D) Exiba as cores na ordem inversa da que foi informada.
 * E) Exiba todas as cores que começam com a letra "v".
 * F) Remova todas as cores que não começam com a letra "v".
 * G) Limpe o conjunto.
 * H) Confira se o conjunto está vazio.
 * */
public class DesafioArcoIris {
    public static void main(String[] args) {

        Set<String> arcoIris = new HashSet<>(){{
            add("Vermelho");
            add("Laranja");
            add("Amarelo");
            add("Verde");
            add("Azul");
            add("Anil");
            add("Violeta");
        }};

        System.out.println("============= ARCO-ÍRIS =============");
        // >>> A) Exiba todas as cores uma abaixo da outra
        for (String cor : arcoIris) {
            System.out.println(cor);
        }

        // >>> B) A quantidade de cores que o arco-íris tem
        System.out.println("Quantidade de cores: "+arcoIris.size());

        // >>> C) Exiba as cores em ordem alfabética
        Set<String> arcoIrisAlf = new TreeSet<>(arcoIris);
        System.out.println("Em ordem alfabética: "+arcoIrisAlf);

        // >>> D) Exiba as cores na ordem inversa da que foi informada
        List<String> arcoIrisInverso = new ArrayList<>(arcoIris);
        Collections.sort(arcoIrisInverso, Collections.reverseOrder());
        System.out.println("Em ordem inversa: "+arcoIrisInverso);

        // >>> E) Exiba todas as cores que começam com a letra "v"
        for(String cor : arcoIris){
            if(cor.startsWith("V"))
                System.out.println(cor);
        }

        // >>> F) Remova todas as cores que não começam com a letra "v"
        Iterator<String> iterator1 = arcoIris.iterator();
        while (iterator1.hasNext()){
            String next = iterator1.next();
            if(next.charAt(0) != 'V') iterator1.remove();
        }

        System.out.println(arcoIris);

        // >>> G) Limpe o conjunto
        arcoIris.clear();

        // >>> H) Confira se o conjunto está vazio
        System.out.println("Conjunto está vazio? "+arcoIris.isEmpty());
    }
}
