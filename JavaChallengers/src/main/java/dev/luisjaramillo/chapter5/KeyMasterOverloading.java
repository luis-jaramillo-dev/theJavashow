package dev.luisjaramillo.chapter5;

//Can you figure out what will happenwhenthiscode is executed?


public class KeyMasterOverloading {
    public static void main(String... args) {
        makeKey(1);
        makeKey(1F);
        makeKey('1');
        makeKey(1.0);
    }

    static void makeKey(short shortCode) {
        System.out.println("short: " + shortCode);
    }

    static void makeKey(long longCode) {
        System.out.println("long: " + longCode);
    }

    static void makeKey(float floatCode) {
        System.out.println("float : " + floatCode);
    }

    static void makeKey(double floatCode) {
        System.out.println("double: " + floatCode);
    }

}
