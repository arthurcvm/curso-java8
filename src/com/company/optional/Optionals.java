package com.company.optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Optionals {
    public static void main(String[] args) {

        String s = "a";
        Optional<Integer> numero = converteEmNumero(s);
        numero.ifPresent(n -> System.out.println(n));

        String s2 = "a";
        Integer numero2 = converteEmNumero(s2).orElse(2);
        Integer numero3 = converteEmNumero(s2).orElseGet(() -> 5);
        System.out.println(numero2);
        System.out.println(numero3);

//        Integer numero4 = converteEmNumero(s2).orElseThrow(() -> new NullPointerException("Valor vazio"));

        Stream.of(1,2,3)
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static Optional<Integer> converteEmNumero(String numeroStr){

        try{
            Integer integer = Integer.valueOf(numeroStr);
            return Optional.of(integer);}
        catch (Exception e){
            return Optional.empty();
        }
    }

}
