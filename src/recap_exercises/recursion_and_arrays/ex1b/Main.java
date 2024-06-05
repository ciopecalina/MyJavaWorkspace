package recap_exercises.recursion_and_arrays.ex1b;

import java.util.Scanner;

public class Main {
    private static int reverseNumber(int n) {
        int reversedNr = 0;
        while (n > 0) {
            reversedNr = reversedNr * 10 + n % 10;
            n /= 10;
        }
        return reversedNr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int reverse = reverseNumber(n);
        System.out.println(reverse);
    }
}

