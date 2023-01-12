package com.langhidev.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe de Desafio de um dos exercícios propostos:
 * Faça um programa que receba a temperatura média dos 6 primeiros meses do ano e armazene-as em uma lista.
 * Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média, e em que mês elas ocorreram (mostrar o mês por extenso: 1 - Janeiro, 2 - Fevereiro e etc)*/
public class Desafio2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Mes> meses = new ArrayList<>();

        // Recebendo meses
        for(int m=0; m<6; m++){
            System.out.print("Nome do "+(m+1)+"° Mês: ");
            String nome = input.next();

            System.out.print("Temperatura média desse Mês: ");
            Double temp = input.nextDouble();

            meses.add(new Mes(nome, temp));
        }

        System.out.println(meses);

        // Calculando a média semestral das temperaturas
        Double soma = 0d;
        for (Mes mes : meses) {
            soma += mes.getTemperatura();
        }
        Double mediaTempSemestral = soma/meses.size();

        System.out.println("Média Semestral das Temperaturas: "+mediaTempSemestral);

        // Mostrando todas as temperaturas acima da média, e o mês em que ocorreram
        System.out.println("----Meses que tiveram a Temperatura acima da média----");
        for (Mes mes : meses) {
            if (mes.getTemperatura() > mediaTempSemestral){
                System.out.println((meses.indexOf(mes)+1)+" - "+mes.getNome());
            }
        }
    }
}

class Mes{
    private String nome;
    private Double temperatura;

    public Mes(String nome, Double temperatura) {
        this.nome = nome;
        this.temperatura = temperatura;
    }

    public String getNome() {
        return nome;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", temperatura=" + temperatura +
                '}';
    }
}