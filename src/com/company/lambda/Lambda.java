package com.company.lambda;

import java.util.stream.IntStream;

public class Lambda {
    public static void main(String[] args) {

        //Parênteses
        Runnable runnable = () -> System.out.println("Teste de runnable");

        IntStream.range(0,5)
                .filter(n -> n % 2 == 0)
                .reduce((n1, n2) -> n1+n2)
                .ifPresent(System.out::println);

        //Chaves
        IntStream.range(0,5)
                .filter(n -> {
                    System.out.println("Teste de multilinhas");
                   return n % 2 == 0;
                })
                .forEach(System.out::println);
    }
}
