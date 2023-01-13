package com.langhidev.set;

import java.lang.reflect.Array;
import java.util.*;

public class Notas {
    public static void main(String[] args) {

        // >>> Crie um conjunto e adicione as notas
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5.5, 7d, 1d, 4.3));
        System.out.println(notas);

        // >>> Confira se a nota 5 está no conjunto
        System.out.println("Alguém tirou nota 5? "+notas.contains(5d));

        // >>> Exiba a menor nota
        System.out.println("Menor nota: "+ Collections.min(notas));
        // >>> Exiba a maior nota
        System.out.println("Maior nota: "+ Collections.max(notas));

        // >>> Exiba a soma dos valores
            // Com Iterator
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        
            // Jeito que eu pensei
        soma = 0d;
        for (Double nota : notas) {
            soma+=nota;
        }
        System.out.println("Soma dos Valores: "+soma);

        System.out.println("Média das notas: "+soma/notas.size());

        // >>> Remova a nota 1
        notas.remove(1d);
        System.out.println(notas);

        // >>> Remova as notas menores que 7 e exiba a lista
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7)
                iterator1.remove();
        }
        System.out.println(notas);

        // >>> Exiba todas as notas na ordem em que foram informados
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5.5);
        notas2.add(7d);
        notas2.add(1d);
        notas2.add(4.3);

        System.out.println(notas2);

        // >>> Exiba todas as notas na ordem crescente
        System.out.println("Notas em ordem crescente:");
        Set<Double> notasCresc = new TreeSet<>(notas2);
        System.out.println(notasCresc);

        // >>> Apague todo o conjunto
        notas.clear();

        // >>> Confira se o conjunto está vazio
        System.out.println("Conjunto vazio? "+notas.isEmpty());
    }
}
