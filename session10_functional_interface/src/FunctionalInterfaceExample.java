import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceExample {
    static Function<Character, Double> powOfTowEachDigit = c -> Math.pow(Integer.parseInt(String.valueOf(c)),2);
    static Function<String, char[]> splitEachDigit = String::toCharArray;
    static Function<String, Integer> stringToInteger = Integer::parseInt;
    static Predicate<Integer> isHappyNumber = (i) -> i == 1;


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(IsHappyNumber(number));
    }

    public static boolean IsHappyNumber(int number) {
        String numberString = String.valueOf(number);

        while (numberString.length()>1){
            char[] numberDigits = splitEachDigit.apply(numberString);
            int result = 0;
            for (char i:numberDigits) {
                result += powOfTowEachDigit.apply(i);
            }
            numberString = String.valueOf(result);
        }
        return isHappyNumber.test(stringToInteger.apply(numberString));
    }
}
