package com.company.FuncionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class FuncionalInterfaces {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        //Suplier
        Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .forEach(System.out::println);

        //Consumer
        list.stream().forEach((e)-> System.out.println(e));

        //Predicate
        list.stream().filter(e -> e % 2 == 0)
                .forEach(System.out::println);

        //Function
        list.stream().map(e -> e.doubleValue())
                .forEach(System.out::println);

        //UnaryOperator/BinaryOperator
        list.stream().reduce((e1, e2) -> e1+e2)
                .ifPresent(System.out::println);
    }
}
