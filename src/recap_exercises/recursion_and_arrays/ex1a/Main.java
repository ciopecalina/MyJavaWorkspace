package recap_exercises.recursion_and_arrays.ex1a;

import java.util.Scanner;

public class Main {

    private static int reverseNumberR(int n) {
        if (n < 10) {
            return n;
        }

        int reversedNr = reverseNumberR(n / 10);
        int mul;
        for (mul = 1; mul <= n / 10; mul *= 10) ;
        return (n % 10) * mul + reversedNr;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int reverse = reverseNumberR(n);
        System.out.println(reverse);
    }
}

