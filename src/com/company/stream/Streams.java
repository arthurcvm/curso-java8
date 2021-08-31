package com.company.stream;

import java.util.Arrays;
import java.util.List;

public class Streams {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);

        lista.stream()
                .skip(2)
                .limit(3)
                .distinct()
                .filter(e -> e % 2 == 0)
                .forEach(e -> System.out.println(e));

        lista.stream()
                .limit(3)
                .map(e -> e*2)
                .skip(2)
                .forEach(e -> System.out.println(e));
    }
}
