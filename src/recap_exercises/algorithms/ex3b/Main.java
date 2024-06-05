package recap_exercises.algorithms.ex3b;

import java.util.Scanner;

public class Main {
    private static int getMultipleOf5Upper(int number) {
        return number / 5 * 5 + (number % 5 == 0 ? 0 : 5);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int multiple = getMultipleOf5Upper(n);
        System.out.print(multiple);
    }
}
