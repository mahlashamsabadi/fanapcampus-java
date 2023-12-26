/**
 * The ternary operator in Java is used to write conditional statements in one line.
 * This operator allows us to write a simple conditional block in one line.
 * This helps to simplify and increase the readability of the code.
 * We should write it like this ==> result = (condition) ? expression1: expression2
 * In this code, the condition part is a conditional expression or a piece of code that has a boolean output.
 * If the condition written in this section is true, the express1 and otherwise the express2 will be saved in the result variable.
 */
public class TernaryOperatorExercise {
    public static void main(String[] args) {
        int i = 10;
        String typeOfNumber = i % 2 == 0 ? "even" : "odd";
        System.out.println(typeOfNumber); // even

        i = 3;
        typeOfNumber = i % 2 == 0 ? "even" : "odd";
        System.out.println(typeOfNumber); // odd
    }
}

