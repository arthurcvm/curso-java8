package com.company.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Reduces {
    public static void main(String[] args) {
        String s = "Teste de string";
        String[] split = s.split(" ");
        List<String> listStr = Arrays.asList(split);
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        //Soma
        Optional<Integer> soma = list.stream()
                .reduce((n1, n2) -> n1 + n2);
        System.out.println(soma.get());

        //Multiplicação
        Optional<Integer> multi = list.stream()
                .reduce((n1, n2) -> n1 * n2);
        System.out.println(multi.get());

        //Concatenação
        Optional<String> concat = listStr.stream()
                .reduce((s1, s2) -> s1.concat(s2));
        System.out.println(concat.get());

        //Valor identidade - valor padrão para a variável acumulativa.
        //Soma
        Integer soma2 = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(soma2);

        //Multiplicação
        Integer multi2 = list.stream()
                .reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(multi2);

        //Concatenação
        String concat2 = listStr.stream()
                .reduce("", (s1, s2) -> s1.concat(s2));
        System.out.println(concat2);

        //menor valor
        double od = DoubleStream.of(1.5,2.9,6.7)
                .reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2));
        System.out.println(od);

        //Soma
        Integer soma3 = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
        System.out.println(soma3);

        //map + soma
        String reduce = list.stream()
                .map(n1 -> n1.toString())
                .reduce(
                        "",
                        (n1, n2) -> n1.toString().concat(n2.toString()),
                        (n1, n2) -> n1.concat(n2)
                );
        System.out.println(reduce);
    }
}
