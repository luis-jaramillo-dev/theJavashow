package dev.luisjaramillo.integers;

public class FizzBuzz {

    public static void main(String... args){
        new FizzBuzz().bizzBuzz(5);
    }

    private void bizzBuzz(int number) {
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i+": fizz");
                continue;
            }
            if (i % 3 == 0) {
                System.out.println(i+":fizz");
                continue;
            }
            if (i % 5 == 0) {
                System.out.println(i+":buzz");
                continue;
            }
            System.out.println(i+":"+i);
        }
    }

}
