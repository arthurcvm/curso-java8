package com.company.lambda;

import java.util.Arrays;
import java.util.List;

public class DebugLambda {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,5,8,9);

        //Transformar em Bloco
        list.stream()
                .map((n) -> {
                    StringBuilder builder = new StringBuilder();
                    builder.append(n);
                    builder.append("s");
                    builder.append("a");
                    return builder;
                })
                .forEach(System.out::println);

        //Transferir para um método
        list.stream()
                .map((n) -> converteParaStringBuilder(n))
                .forEach(System.out::println);

        //Utilizando o peek - pode ser chamado em qualquer ponto do Stream()
        list.stream()
                .peek(n -> System.out.println(n + "Teste!"))
                .map((n) -> converteParaStringBuilder(n))
                .forEach(System.out::println);
    }

    private static StringBuilder converteParaStringBuilder(Integer n){
        StringBuilder builder = new StringBuilder();
        builder.append(n);
        builder.append("s");
        builder.append("a");
        return builder;
    }
}
