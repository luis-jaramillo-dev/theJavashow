package dev.luisjaramillo.chapter5;

public class BasicOverloading {
    public static void main(int test, String... args) {
        calculate("String Value", "String value 2");
        calculate("String value", 1);
    }

    static void calculate(String stringParameter,
                          String anotherStringParameter) {
        System.out.printf("String parameter %s , String parameter %s",
                stringParameter,
                anotherStringParameter
        );
    }

    static void calculate(String stringParameter, int intParameter) {
        System.out.printf("String parameter %s , int %s",
                stringParameter,
                intParameter
        );
    }

}
