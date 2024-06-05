package recap_exercises.recursion_and_arrays.ex2b;

import java.util.Scanner;

public class Main {
    private static int myMathPow(int x, int y) {
        int result = 1;
        for (int i = 0; i < y; i++)
            result *= x;

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int power = myMathPow(x, y);
        System.out.println(power);
    }
}

