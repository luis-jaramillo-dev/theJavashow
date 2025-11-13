package dev.luisjaramillo.chapter5;

public class BasicOverloading {
    public static void main(String... args) {

        printLine("String Value", "String value 2");
        printLine("String value", 1);
    }

    static void printLine(String stringParameter,
                          String anotherStringParameter) {
        System.out.printf("String parameter %s , String parameter %s",
                stringParameter,
                anotherStringParameter
        );
    }

    static void printLine(String stringParameter, int intParameter) {
        System.out.printf("String parameter %s , int %s",
                stringParameter,
                intParameter
        );
    }
}
