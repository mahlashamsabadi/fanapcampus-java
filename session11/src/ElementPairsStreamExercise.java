import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ElementPairsStreamExercise {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(3,4);
        list2.stream().map(j -> list1.stream().map(i -> new Pair<Integer,Integer>(i, j)))
                .map(i -> i.collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .filter(i -> (i.getValue()+ i.getKey()) % 3 == 0)
                .forEach(System.out::println);
    }
}
