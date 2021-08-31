package com.company.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Streams2 {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);

        //count
        long count = lista.stream()
                .filter(e -> e % 2 == 0)
                .count();

        System.out.println(count);

        //min/max
        Optional<Integer> max = lista.stream()
                .filter(e -> e % 2 == 0)
                .max(Comparator.naturalOrder());

        System.out.println(max.get());

        //collect - toList
        List<Integer> novaLista = lista.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 3)
                .collect(Collectors.toList());

        System.out.println(novaLista);

        //collect - groupingBy
        Map<Integer, List<Integer>> mapa = lista.stream()
                .collect(Collectors.groupingBy(e -> e % 3));

        System.out.println(mapa);

        //collect - joining
        String collect = lista.stream()
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining("; "));

        System.out.println(collect);
    }
}
