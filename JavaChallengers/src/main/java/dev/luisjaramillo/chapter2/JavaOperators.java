package dev.luisjaramillo.chapter2;

public class JavaOperators {

    public static void main(String... args){
        preIncrement();
        postIncrement();
    }

    static void  preIncrement(){
        int variable1 =0;
        System.out.println("Test preIncrement variable1:" + ++variable1);
        System.out.println("Test preIncrement variable1:" + variable1);
    }

    static void postIncrement(){
        int variable1 =0;
        System.out.println("Value:" + variable1++);
        System.out.println("Value:" + variable1);
    }
}
