package com.langhidev.stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ExercicioStreamApi {
    public static void main(String[] args) {

        List<String> numeros = Arrays.asList("7", "10", "1", "4", "0", "1", "10", "7", "5", "8", "15", "30", "45");

        numeros.forEach(num -> System.out.print(num+" ")); // Imprime todos os elementos da lista

        System.out.println("\n-----------------------");

        // Pega os 5 primeiros números e coloca dentro de um Set
        Set<String> numerosSet = numeros.stream().limit(5).collect(Collectors.toSet()); // Se tiver numero repetido ele nao grava, já que é um Set
        numerosSet.forEach(System.out::println);

        System.out.println("-----------------------");

        // Transforma a lista de String em uma lista de números inteiros
        List<Integer> numerosInt = numeros.stream().map(Integer::parseInt).collect(Collectors.toList());
        numerosInt.forEach(n -> System.out.println(n+" - "+n.getClass()));

        // Pega os números pares e maiores que 2 e coloca em uma lista
        List<Integer> paresMaiorQue2 = numeros.stream().map(Integer::parseInt).filter(n -> (n % 2 == 0 && n > 2)).collect(Collectors.toList());

        System.out.println(paresMaiorQue2);

        // Média dos números
        numeros.stream().mapToInt(Integer::parseInt).average().ifPresent(System.out::println);

        // Remove os valores impares
        numerosInt.removeIf(n -> (n % 2 != 0));
        System.out.println(numerosInt);

        // Exercícios :)
        // Ignora os 3 primeiros elementos da lista e imprime o restante
        numeros.stream().skip(3).forEach(System.out::println);

        // Quantos números ficam se retirar os números repetidos da lista
        long qnt = numeros.stream().distinct().count();

        System.out.println("Quantos números ficam se retirar os números repetidos da lista? "+qnt);

        // Mostre o menor valor da lista
        System.out.print("Menor valor da lista: ");
        numeros.stream().mapToInt(Integer::parseInt).min().ifPresent(System.out::println);
        // Mostre o maior valor da lista
        System.out.print("Maior valor da lista: ");
        numeros.stream().mapToInt(Integer::parseInt).max().ifPresent(System.out::println);

        // Somar apenas os números impares
        System.out.print("Soma dos números ímpares: ");
        List<Integer> numerosImpares = numeros.stream().map(Integer::parseInt).filter(n -> n % 2 != 0).collect(Collectors.toList());
        int somaImpares = numerosImpares.stream().mapToInt(Integer::intValue).sum();
        System.out.println(somaImpares);

        // Mostrar a lista na ordem numérica
        System.out.print("Lista na ordem numérica: ");
        numeros.stream().map(Integer::parseInt).sorted().collect(Collectors.toList()).forEach(n -> System.out.print(n+" "));

        System.out.println();

        // Agrupe os valores impares múltiplos de 3 e de 5
        Map<Boolean, List<Integer>> imparesMultiplos3e5 = numerosImpares.stream().collect(Collectors.groupingBy(n -> (n % 3 == 0 && n % 5 == 0)));
        System.out.println(imparesMultiplos3e5);


    }
}
