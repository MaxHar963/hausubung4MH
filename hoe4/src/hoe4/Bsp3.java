/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoe4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Max
 */
public class Bsp3 {

    private static int getCountEmtpyString(List<String> strings) {

        return strings.stream().filter(s -> s.length() == 0).collect(Collectors.toList()).size();

    }

    private static int getCountLength(List<String> strings) {

        return strings.size();

    }

    private static List<String> deleteEmptyStrings(List<String> strings) {

        return strings
                .stream()
                .filter((n) -> !n.isEmpty())
                .collect(Collectors.toList());

    }

    private static String getMergedString(List<String> strings, String separator) {

        return strings
                .stream()
                .filter(n -> true)
                .reduce((left, right) -> left + separator + right)
                .orElse(null);

    }

    private static List<Integer> getSquares(List<Integer> numbers) {

        return numbers
                .stream()
                .map((n) -> n = n * n)
                .collect(Collectors.toList());

    }

    private static int getMax(List<Integer> numbers) {

        return numbers.
                stream()
                .max((left, right) -> left - right)
                .orElse(Integer.MAX_VALUE);

    }

    private static int getMin(List<Integer> numbers) {

        return numbers.
                stream()
                .max((left, right) -> left - right)
                .orElse(Integer.MIN_VALUE);

    }

    private static int getSum(List<Integer> numbers) {

        return numbers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

    }

    private static int getAverage(List<Integer> strings) {

        return (int) strings.stream().mapToInt(Integer::intValue).average().orElse(0.0);

    }

    public void run() {

        List<String> list = new ArrayList<String>();
        List<Integer> list2 = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("Hallo");
        list.add("Hallo2");
        list2.add(4);
        list2.add(5);
        list2.add(9);
        list2.add(4);
        list2.add(6);

        System.out.println(getCountEmtpyString(list));
        System.out.println(getCountLength(list));
        System.out.println(deleteEmptyStrings(list));
        System.out.println(getMergedString(list," "));
        System.out.println(getCountEmtpyString(list));
        System.out.println(getSquares(list2));
        System.out.println(getMax(list2));
        System.out.println(getMin(list2));
        System.out.println(getSum(list2));
        System.out.println(getAverage(list2));
        
        
    }

}
