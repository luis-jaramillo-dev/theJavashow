package dev.luisjaramillo.challenges;

public class MetalGearReference {

    String name;

    public static void main(String... doYourBest) {
        MetalGearReference solidSnake = new MetalGearReference();
        solidSnake.changeSoldierName(solidSnake, "SolidSnake");
        MetalGearReference liquidSnake = new MetalGearReference();
        liquidSnake.changeSoldierName(liquidSnake, "LiquidSnake");

        System.out.println("1 soldier = " + solidSnake.name + "2 soldier = " + liquidSnake.name);
    }

    void changeSoldierName(MetalGearReference metalGearReference, String name) {
        metalGearReference.name = name;
        this.name = "BigBoss";
        metalGearReference = null;
    }

}
