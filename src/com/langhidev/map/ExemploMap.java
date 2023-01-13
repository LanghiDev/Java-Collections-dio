package com.langhidev.map;

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {

        // >>> Crie um dicionário
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("Fusca", 14.5);
            put("HB20", 15.6);
        }};

        System.out.println(carrosPopulares);

        // >>> Substitua o consumo do gol por 15,2 km/l
        carrosPopulares.put("Gol", 15.2);
        System.out.println(carrosPopulares);

        // >>> Confira se o modelo tucson está no dicionario
        System.out.println("Tem Fusca? "+carrosPopulares.containsKey("Tucson"));

        // >>> Exiba o consumo do Uno
        System.out.println("Consumo do Uno: "+carrosPopulares.get("Uno"));

        // >>> Exiba os modelos
        System.out.println("Modelos: ");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);

        // >>> Exiba os consumos dos carros
        System.out.println("Consumos dos carros: ");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);

        // >>> Exiba o modelo mais econômico e seu consumo:
        Double melhorConsumo = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        System.out.println(entries);
        String melhorModelo = "";

        for (Map.Entry<String, Double> entry: entries) {
            if(entry.getValue().equals(melhorConsumo)){
                melhorModelo = entry.getKey();
                System.out.println("Modelo mais econômico: "+melhorModelo+" com "+melhorConsumo+" km/l");
            }
        }

        // >>> Exiba o modelo menos econômico e seu consumo:
        Double piorConsumo = Collections.min(carrosPopulares.values());
        
        String piorModelo = "";

        for (Map.Entry<String, Double> entry : carrosPopulares.entrySet()) {
            if (entry.getValue().equals(piorConsumo)){
                piorModelo = entry.getKey();
                System.out.println("Modelo menos econômico: "+piorModelo+" com "+piorConsumo+" km/l");
            }
        }

        // >>> Exiba a soma dos consumos
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Soma dos consumos: "+soma);

        // >>> Exiba a média dos consumos deste dicionário
        System.out.println("Média dos consumos: "+(soma/carrosPopulares.size()));

        // >>> Remova os modelos com o consumo igual a 15,6 km/l
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()){
            if (iterator1.next().equals(15.6))
                iterator1.remove();
        }
        System.out.println(carrosPopulares);

        // >>> Exiba todos os carros na ordem em que foram informados
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("Fusca", 14.5);
            put("HB20", 15.6);
        }};

        System.out.println("Carros na ordem que foram informados: ");
        System.out.println(carrosPopulares1);

        // >>> Exiba o dicionário ordenado pelo modelo
        System.out.println("Ordenado pelo modelo: ");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);

        System.out.println(carrosPopulares2);

        // >>> Apague o dicionário de carros
        carrosPopulares.clear();

        // >>> Confira se o dicionário está vazio
        System.out.println("Sem carros em estoque? "+carrosPopulares.isEmpty());



    }
}
