package com.langhidev.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Notas {
    public static void main(String[] args) {

        List<Double> notas = new ArrayList<>();

        notas.add(10d);
        notas.add(7.5);
        notas.add(9.75);
        notas.add(8.0);
        notas.add(5d);
        notas.add(4.75);
        notas.add(1.0);
        notas.add(9d);

        System.out.println(notas);

        // >>> Exiba a posição da nota 5
        System.out.println("Posição da nota 5: "+notas.indexOf(5d));

        // >>> Adicione na lista a nota 8.5 na posição 3
        notas.add(2, 8.5);
        System.out.println(notas);

        // >>> Substitua a nota 5 pela nota 6
        notas.set(notas.indexOf(5d), 6d);
        System.out.println(notas);

        // >>> Confira se a nota 5 está na lista
        System.out.println("Alguém tirou nota 5? "+notas.contains(5d));

        // >>> Exiba todas as notas na ordem em que foram informadas
        System.out.println("===========NOTAS NA ORDEM===========");
        for (Double nota : notas) System.out.println(nota);

        // >>> Exiba a terceira nota adicionada
        System.out.println("Terceira Nota: "+notas.get(2));
        System.out.println(notas);

        // >>> Exiba a menor nota
        System.out.println("Menor nota: "+ Collections.min(notas));
        // >>> Exiba a maior nota
        System.out.println("Maior nota: "+ Collections.max(notas));

        // >>> Exiba a soma dos valores
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Soma das notas: "+soma);

                // - Jeito que pensei...
        soma = 0d;
        for (Double nota : notas) {
            soma += nota;
        }
        System.out.println("Soma das notas: "+soma);

        // >>> Exiba a média das notas
        System.out.println("Média das notas: "+(soma/notas.size()));

        // >>> Remova a nota 1
        notas.remove(1d);
        System.out.println(notas);

        // >>> Remova a menor nota
        notas.remove(Collections.min(notas));
        System.out.println(notas);

        // >>> Remova a nota da posição 0
        notas.remove(0);
        System.out.println(notas);

        // >>> Remova as notas menores que 7 e exiba a lista
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }
        System.out.println(notas);

                // - Jeito que pensei...
        for (Double nota :
                notas) {
            if(nota < 7) notas.remove(nota);
        }
        System.out.println(notas);

        // >>> Apague toda a lista
        notas.clear();
        System.out.println(notas);

        // >>> Confira se a lista está vazia
        System.out.println("Está sem notas? "+notas.isEmpty());

    }
}
