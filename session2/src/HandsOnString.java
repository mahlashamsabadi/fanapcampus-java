public class HandsOnString {
    public static void main(String[] args) {
        String name = "Mahla";
        int age = 22;
        String replacement = "fanap";
        String str1 = String.format("Hi, I'm %s and I'm %d years old", name,age);
        System.out.println(str1.toUpperCase());
        String changedStr1 = str1.replace(name , replacement);
        System.out.println(changedStr1);
        String removedStr =  changedStr1.substring(0,changedStr1.indexOf(replacement) + replacement.length());
        System.out.println(removedStr.toLowerCase());
    }
}
