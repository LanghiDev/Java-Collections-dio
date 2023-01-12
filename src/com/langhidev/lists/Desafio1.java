package com.langhidev.lists;

import java.util.Iterator;
import java.util.LinkedList;

public class Desafio1 {

    public static void main(String[] args) {

        LinkedList notas2 = new LinkedList();

        notas2.add(10d);
        notas2.add(7.5);
        notas2.add(9.75);
        notas2.add(8.0);
        notas2.add(5d);
        notas2.add(4.75);
        notas2.add(1.0);
        notas2.add(9d);

        System.out.println(notas2);

        // >>> Mostre a primeira nota sem removê-lo
        System.out.println("Primeira nota: "+notas2.getFirst());
        System.out.println(notas2);

        // >>> Mostre a primeira nota removendo-o
        System.out.println("Primeira nota removida: "+notas2.removeFirst());
        System.out.println(notas2);

    }
}
