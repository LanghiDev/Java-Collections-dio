package com.langhidev.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class DesafioDados {
    public static void main(String[] args) {
        Random random = new Random();
        Map<Integer, Integer> lancamentoDados = new HashMap<>();

        // Lançando os dados
        for(int l=1; l<=100; l++){
            lancamentoDados.put(l, random.nextInt(6)+1);
        }

        // Obter o número de vezes que cada valor foi obtido
        Set<Map.Entry<Integer, Integer>> entries = lancamentoDados.entrySet();
        int vezes;
        for(int n=1; n<=6; n++){
            vezes = 0;
            System.out.print("Vezes que caiu o número "+n+" = ");
            for (Map.Entry<Integer, Integer> numero : entries){
                if(numero.getValue().equals(n))
                    vezes++;
            }
            System.out.print(vezes);
            System.out.println("");
        }

    }
}
