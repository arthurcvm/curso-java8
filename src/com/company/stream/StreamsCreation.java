package com.company.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsCreation {
    public static void main(String[] args) throws Exception {

        //Collection
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream().forEach(System.out::println);

        //Arrays
        Integer[] intArray = new Integer[]{1,2,3,4};
        Arrays.stream(intArray).forEach(System.out::println);

        //Stream.of
        Stream.of("teste", "de", "stream", "com", "qualquer", "tipo")
                .forEach(System.out::println);

        //IntStream.range
        IntStream.range(0,5).forEach(System.out::println);
        IntStream.rangeClosed(0,5).forEach(System.out::println);

        //Stream.iterate
        Stream.iterate(5, n -> n *2)
                .limit(10)
                .forEach(System.out::println);

        //BufferedReader - lines
        File file = new File("streams.txt");
        FileReader in = new FileReader(file);
        try(BufferedReader br = new BufferedReader(in)) {
            br.lines().forEach(System.out::println);
        }

        //Files
        Path p = Paths.get("");
        Files.list(p).forEach(System.out::println);

        //Random
        new Random().ints()
                .limit(10)
                .forEach(System.out::println);

        //Pattern - Regex
        String s = "Teste de String";
        Pattern pat = Pattern.compile(" ");
        pat.splitAsStream(s)
                .forEach(System.out::println);


    }
}
