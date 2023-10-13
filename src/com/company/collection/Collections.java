package com.company.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Collections {
    public static void main(String[] args) {

        //List
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //ForEach
        list.forEach(n -> System.out.println(n));

        //removeIf
        list.removeIf(n -> n % 2 == 0);
        list.forEach(n -> System.out.println(n));

        //replaceAll
        list.replaceAll(n -> n * 2);
        list.forEach(n -> System.out.println(n));

        //Map
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "teste");
        map.put(1, "de");
        map.put(2, "map");
        map.put(3, "no");
        map.put(4, "java");

        //ForEach
        map.forEach((k, v) -> System.out.println(k + v));

        //Compute
        map.compute(1, (k, v) -> v + " agora");
        map.forEach((k,v)-> System.out.println(k+v));

        //Merge
        map.merge(3, "!", (v1, v2) -> v1 +v2);
        map.forEach((k,v)-> System.out.println(k+v));

        //ReplaceAll
        map.replaceAll((k, v) -> v + "!");
        map.forEach((k,v)-> System.out.println(k+v));

    }
}
