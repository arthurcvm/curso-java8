package com.company.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Collects {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        //fornecedor - acumulação - combinação
        List<Integer> collect = list.stream()
                .collect(
                        () -> new ArrayList<>(),
                        (l, e) -> l.add(e),
                        (l1, l2) -> l1.addAll(l2)
                );

        System.out.println(collect);

        //toList
        List<Integer> collect2 = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(collect2);

        //Joining
        String join = list.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining(";"));

        System.out.println(join);

        //averaging
        Double media = list.stream()
                .collect(Collectors.averagingInt(n -> n.intValue()));

        System.out.println(media);

        //summing
        Integer soma = list.stream()
                .collect(Collectors.summingInt(n -> n.intValue()));

        System.out.println(soma);

        //summarizing
        IntSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingInt(n -> n.intValue()));

        System.out.println("IntSummaryStatistics");
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());

        // counting
        Long count = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.counting());

        System.out.println(count);

        // max/min
        list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        // groupingBy
        Map<Integer, List<Integer>> groupingBy = list.stream()
                .collect(Collectors.groupingBy((n) -> n % 3));

        System.out.println(groupingBy);

        // partitioningBy
        Map<Boolean, List<Integer>> partitioningBy = list.stream()
                .collect(Collectors.partitioningBy((n) -> n % 3 == 0));

        System.out.println(partitioningBy);

        // toMap
        Map<Integer, Double> toMap = list.stream()
                .collect(Collectors.toMap(n -> n, n -> Math.pow(n.doubleValue(), 5)));

        System.out.println(toMap);
    }
}
