package com.company.lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5);

        list.stream()
                .forEach(System.out::println); //Method reference

        list.stream()
                .forEach((n) -> System.out.println(n)); // Sem Method reference

        //Métodos estáticos
        list.stream()
                .map((n) -> multipliquePorDois(n))
                .forEach(System.out::println);

        list.stream()
                .map(MethodReference::multipliquePorDois)
                .forEach(System.out::println);

        //Construtores
        list.stream()
                .map((n) -> new BigDecimal(n))
                .forEach(System.out::println);

        list.stream()
                .map(BigDecimal::new)
                .forEach(System.out::println);

        //Várias instâncias
        list.stream()
                .map((n) -> n.doubleValue())
                .forEach(System.out::println);

        list.stream()
                .map(Integer::doubleValue)
                .forEach(System.out::println);

        //Única instancia
        BigDecimal dois = new BigDecimal(2);
        list.stream()
                .map(BigDecimal::new)
                .map((b) -> dois.multiply(b))
                .forEach(System.out::println);

        list.stream()
                .map(BigDecimal::new)
                .map(dois::multiply)
                .forEach(System.out::println);

    }

    private static Integer multipliquePorDois(Integer i){
        return i*2;
    }
}
