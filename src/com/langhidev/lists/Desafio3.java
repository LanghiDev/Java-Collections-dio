package com.langhidev.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Desafio do segundo exercício proposto.
 * Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
 * 1. "Telefonou para a vítima?"
 * 2. "Esteve no local do crime?"
 * 3. "Mora perto da vítima?"
 * 4. "Devia para a vítima?"
 * 5. "Já trabalhou com a vítima?"
 * Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4
 * como "Cúmplice" e 5 como "Assassina". Caso contrário, ela será classificado como "Inocente".
 * */
public class Desafio3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Character> respostas = new ArrayList<>();

        System.out.println("\n=-=-=-= BEM-VINDO À INVESTIGAÇÃO =-=-=-=");
        System.out.println("[Por favor, responda só Sim ou Não - S/N]\n");

        System.out.print("Telefonou para a vítima? ");
        respostas.add(input.next().charAt(0));
        System.out.print("Esteve no local do crime? ");
        respostas.add(input.next().charAt(0));
        System.out.print("Mora perto da vítima? ");
        respostas.add(input.next().charAt(0));
        System.out.print("Devia para a vítima? ");
        respostas.add(input.next().charAt(0));
        System.out.print("Já trabalhou com a vítima? ");
        respostas.add(input.next().charAt(0));

        int qntSim = 0;

        for (Character resp : respostas) {
            if(resp.equals('s'))
                qntSim++;
        }

        String classificada = "";

        switch (qntSim){
            case 2:
                classificada = "Suspeita";
                break;
            case 3:
            case 4:
                classificada = "Cúmplice";
                break;
            case 5:
                classificada = "Assassina";
                break;
            default:
                classificada = "Inocente";
                break;
        }

        System.out.println("Você está classificado como "+classificada);
    }
}
