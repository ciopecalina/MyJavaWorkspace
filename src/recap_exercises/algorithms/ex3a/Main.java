package recap_exercises.algorithms.ex3a;

import java.util.Scanner;

public class Main {
    private static int getMultipleOf5Lower(int number) {
        return number - number % 5;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int multiple = getMultipleOf5Lower(n);
        System.out.print(multiple);
        scanner.close();
    }
}

