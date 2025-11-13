package dev.luisjaramillo.chapter5;

public class OverloadAccessModifiers {

    public void display(int a) {
        System.out.println("Public display with int: " + a);
    }

    private void display(String s) {
        System.out.println("Private display with String: " + s);
    }

    protected void display(double d) {
        System.out.println("Protected display with double: " + d);
    }

}
