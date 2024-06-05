package recap_exercises.recursion_and_arrays.ex2a;

import java.util.Scanner;

public class Main {
    private static int myMathPowR(int x, int y) {
        if (y == 0) {
            return 1;
        }
        return x * myMathPowR(x, y - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int power = myMathPowR(x, y);
        System.out.println(power);
    }
}

