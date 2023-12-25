/**
 * اپراتور ternary در جاوا برای نوشتن دستور شرط به صورت یک خطی است.
 * این اپراتور به ما این امکان را میدهد که در صورت داشتن بلاک شرطی ساده آن را درون یک خط بنویسیم.
 * این کار به ساده نویسی و افزایش خوانایی کد کمک میکند.
 * نحوه نوشتن آن به این صورت است: result = (condition) ? expression1 : expression2
 * در این کد قسمت condition یک عبارت شرطی یا قطعه کدی است که خروجی boolean دارد.
 * در صورت برقرار بودن شرط نوشته شده در این قسمت مقدار نوشته شده در expression1 و در غیر این صورت مقدار expression2 در متغیر result ذخیره میشود.
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

