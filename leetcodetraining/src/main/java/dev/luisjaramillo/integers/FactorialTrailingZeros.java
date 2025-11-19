package dev.luisjaramillo.integers;

public class FactorialTrailingZeros {

    public static void main(String[] args) {
        int result = new FactorialTrailingZeros().trailingZerosCounter(50);
        System.out.println(result);
    }

    private int trailingZerosCounter(int number) {
        int count = 0;
        while (number > 0) {
            number /= 5;
            count += number;
        }
        return count;
    }

}
