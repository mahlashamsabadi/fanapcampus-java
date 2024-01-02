import java.util.ArrayList;
import java.util.List;

public class ListExercise {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        for (Integer i : addElements(list1, list2)) {
            System.out.println(i);
        }
        // output: 4,6
        System.out.println("---------------------------------------------------------------------");
        list1.add(6);
        list1.add(7);
        // list1: [1,2,6,7] , list2: [3,4,5]
        for (Integer i : addElements(list1, list2)) {
            System.out.println(i);
        }
        // output: 4,6,11,

    }

    public static List<Integer> addElements(List<Integer> list1, List<Integer> list2) {
        int minLength = Math.min(list1.size(), list2.size());
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < minLength; i++) {
            result.add(list1.get(i) + list2.get(i));
        }
        return result;
    }
}
