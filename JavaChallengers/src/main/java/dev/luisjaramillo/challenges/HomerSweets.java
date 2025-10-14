package dev.luisjaramillo.challenges;

public class HomerSweets {

    public static void main(String[] args) {
        String[] homerSweets = {"Chocolate", "Cake", "IceCream"};
        changeFirstElementToPudding(homerSweets);
        System.out.println(homerSweets[0]);//This will print "Pudding"
    }

    static void changeFirstElementToPudding(String[] sweets) {
        sweets[0] = "Pudding";
    }

}
