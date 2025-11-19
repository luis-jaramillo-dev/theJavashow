package dev.luisjaramillo.integers;

public class PalindromeNumber {

    public static void main(String... args) {
        System.out.println(new PalindromeNumber().isPalindromeUsingStringBuilder(55));
    }

    private boolean isPalindromeUsingStringBuilder(int number) {
        StringBuilder sBuilder = new StringBuilder(String.valueOf(number));
        return sBuilder.toString().equals(sBuilder.reverse().toString());
    }

    private boolean isPalindrome(int number) {
        if (number < 0 || (number % 10 == 0 && number != 0)) return false;
        int reversedNum = 0, pop = 0;
        while (number > reversedNum) {
            pop = number % 10;
            reversedNum = reversedNum * 10 + pop;
            number = number / 10;
        }
        return number == reversedNum || number == reversedNum / 10;

    }

}
