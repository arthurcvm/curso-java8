package com.company.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelsStreams {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);

        //Parallel vs ParallelStream
//        list.parallelStream();
//        IntStream.range(0,5).parallel();

        //forEach vs ForEachOrdered
        list.parallelStream()
                .forEach(System.out::println);
        System.out.println("---");
        list.parallelStream()
                .forEachOrdered(System.out::println);

        System.out.println("---");

        //FindAny
        list.parallelStream().findAny()
                .ifPresent(System.out::println);
        System.out.println("---");
        list.stream().findAny()
                .ifPresent(System.out::println);
        System.out.println("---");

        //Unordered
        list.parallelStream()
                .unordered()
                .skip(1)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("---");

        //Reduce
        list.parallelStream()
                .reduce((v1, v2) -> v1+v2)
                .ifPresent(System.out::println);
        System.out.println("---");

        //Collect
        Map<Integer, Boolean> collect =
                list.parallelStream()
                        .collect(Collectors.toConcurrentMap(n -> n, n -> n % 2 == 0));
        System.out.println(collect);System.out.println("---");

        //GroupingBy
        Map<Boolean, List<Integer>> collect2 =
                list.parallelStream()
                        .collect(
                                Collectors.groupingByConcurrent(n -> n % 2 == 0));
        System.out.println(collect2);

    }
}
