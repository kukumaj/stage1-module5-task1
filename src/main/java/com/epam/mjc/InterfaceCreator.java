package com.epam.mjc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            boolean result = true;
            for (String element : x
            ) {
                if (element.charAt(0) < 65 || element.charAt(0) > 90) {
                    result = false;
                    break;
                }
            }
            return result;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> list2 = new ArrayList<>();
            list2.addAll(x);
            for (int element : x
            ) {
                if (element % 2 == 0) {
                    list2.add(element);
                }
            }
            x.removeAll(x);
            x.addAll(list2);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();

            for (String element : values
            ) {
                String[] words = element.split(" ");
                if (element.charAt(0) > 65 && element.charAt(0) < 90 && element.endsWith(".") && words.length > 3) {
                    list.add(element);
                }
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String element : x
            ) {
                map.put(element, element.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {

        return (list1, list2) -> {
            List<Integer> list3 = new ArrayList<>();
            list3.addAll(list1);
            list3.addAll(list2);
            return list3;
        };

    }
}