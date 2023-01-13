package com.langhidev.map;

import java.util.*;

public class ExercicioEstados {
    public static void main(String[] args) {

        Map<String, Integer> estadosBR = new HashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};

        // Substitua a população do estado do RN por 3534165
        estadosBR.put("RN", 3534165);

        mostrarEstados(estadosBR.entrySet());

        // Confira se o estado PB está no dicionário, caso não, adicione: PB - 4039277
        System.out.println("PB está no dicionário? "+estadosBR.containsKey("PB"));
        if(!estadosBR.containsKey("PB"))
            estadosBR.put("PB", 4039277);

        mostrarEstados(estadosBR.entrySet());

        // Exiba a população PE
        System.out.println("População PE: "+estadosBR.get("PE"));

        // Exiba todos os estados e suas populações na ordem que foi informado
        System.out.println("======== MOSTRANDO ESTADOS EM ORDEM DE INSERÇÃO ========");
        Map<String, Integer> estadosBR1 = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};

        mostrarEstados(estadosBR1.entrySet());

        // Exiba os estados e populações em ordem alfabética
        System.out.println("======== ORDEM ALFABÉTICA ========");
        Map<String, Integer> estadosBR2 = new TreeMap<>(estadosBR1);

        mostrarEstados(estadosBR2.entrySet());

        // Exiba o estado com menor população e sua quantidade
        System.out.println("==================================");
        System.out.println("Estado menos populoso:");
        Integer menorPopulacao = Collections.min(estadosBR.values());
        Set<Map.Entry<String, Integer>> entries = estadosBR.entrySet();
        for (Map.Entry<String, Integer> estado : entries) {
            if (estado.getValue().equals(menorPopulacao))
                System.out.println(estado.getKey()+" - "+estado.getValue());
        }

        // Exiba o estado com maior população e sua quantidade
        System.out.println("Estado mais populoso:");
        Integer maiorPopulacao = Collections.max(estadosBR.values());
        for(Map.Entry<String, Integer> estado : entries){
            if(estado.getValue().equals(maiorPopulacao))
                System.out.println(estado.getKey()+" - "+estado.getValue());
        }

        // Exiba a soma da população desses estados
        System.out.println("==================================");
        Integer soma = 0;
        Iterator<Integer> iterator = estadosBR.values().iterator();
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Soma da população: "+soma);

        // Exiba a média da população desses estados
        System.out.println("Média das populações: "+soma/estadosBR.size());

        // Remova os estados com a população menor que 4.000.000
        System.out.println("==================================");
        Iterator<Integer> iterator1 = estadosBR.values().iterator();
        while (iterator1.hasNext()){
            if(iterator1.next() < 4000000)
                iterator1.remove();
        }

        mostrarEstados(estadosBR.entrySet());

        // Apagar dicionário
        estadosBR.clear();

        System.out.println("Dicionário de estados vazio? "+estadosBR.isEmpty());


    }

    public static void mostrarEstados(Set<Map.Entry<String, Integer>> estados){
        for (Map.Entry<String, Integer> estado : estados) {
            System.out.println(estado.getKey()+" - "+estado.getValue());
        }
    }
}
