package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (String s : list) {
                if (!Character.isUpperCase(s.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> evenValues = new ArrayList<>();
            list.forEach(listValue -> {
                if (listValue % 2 == 0) {
                    evenValues.add(listValue);
                }
            });

            list.addAll(evenValues);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            values.removeIf(s -> {
                return !Character.isUpperCase(s.charAt(0))
                        || !s.endsWith(".")
                        || s.split(" ").length <= 3;
            });
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> list.stream().collect(Collectors.toMap(string -> string, String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> newList = new ArrayList<>(list1);
            newList.addAll(list2);
            return newList;
        };
    }

    public static void main(String[] args) {
        var interfaceCreator = new InterfaceCreator();
        //System.out.println(interfaceCreator.isValuesStartWithUpperCase().test(List.of("Asd", "oLo", "Nkjsd", "Jsdq")));

        /*List<Integer> list = IntStream.range(1, 14).boxed().collect(Collectors.toList());
        System.out.println(list);
        interfaceCreator.addEvenValuesAtTheEnd().accept(list);
        System.out.println(list);*/

        /*System.out.println(interfaceCreator.filterCollection(new ArrayList<>(List.of(
                "hello world in Java.",
                "MJC is a great school.",
                "This is a good way to learn Java Functional Interfaces.",
                "this is a good way to learn Java Functional Interfaces.",
                "Test string."
        ))).get());*/

        /*List<String> list = new ArrayList<>(List.of(
                "hello world in Java.",
                "MJC is a great school.",
                "This is a good way to learn Java Functional Interfaces.",
                "this is a good way to learn Java Functional Interfaces.",
                "Test string."
        ));
        System.out.println(interfaceCreator.stringSize().apply(list));*/

        List<Integer> list1 = IntStream.range(1, 14).boxed().collect(Collectors.toList());
        List<Integer> list2 = IntStream.range(100, 114).boxed().collect(Collectors.toList());
        System.out.println(interfaceCreator.concatList().apply(list1, list2));
    }
}
