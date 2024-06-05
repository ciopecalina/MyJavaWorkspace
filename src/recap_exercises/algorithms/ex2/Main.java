package recap_exercises.algorithms.ex2;

import java.util.Scanner;

public class Main {
    private static void printBasePowers(int b, int e) {
        if (e < 0) {
            System.out.println("Error: The exponent should be positive!");
            return;
        }

        int crtResult = 1;
        for (int crtPower = 0; crtPower <= e; crtPower++) {
            System.out.print(crtResult + " ");
            crtResult *= b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        int e = scanner.nextInt();
        printBasePowers(b, e);
    }
}
