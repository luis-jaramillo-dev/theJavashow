package dev.luisjaramillo.chapter5;

public class WrapperAndAutoboxing {

    public static void main(String... args) {

        OverloadingLimitations test = new OverloadingLimitations();
        test.printLine("test", "test");
        test.printLine("test", 7);
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b); // true

        Integer x = 200;
        Integer y = 200;
        System.out.println(x == y); // false
    }
}
