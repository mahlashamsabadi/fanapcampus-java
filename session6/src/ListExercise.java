import java.util.ArrayList;
import java.util.List;

public class ListExercise {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list2.add(3.1);
        list2.add(4.2);
        list2.add(5.5);

        addElements(list1,list2);
        // output: 4,6
        System.out.println("---------------------------------------------------------------------");
        list1.add(6);
        list1.add(7);
        // list1: [1,2,6,7] , list2: [3,4,5]
        addElements(list1,list2);
        // output: 4,6,11,

    }

    public static void addElements(List<? extends Number> list1, List<? extends Number> list2) {
        int minLength = Math.min(list1.size(), list2.size());

        for (int i = 0; i < minLength; i++) {
            System.out.println((list1.get(i).doubleValue() + list2.get(i).doubleValue()));
        }
    }
}
