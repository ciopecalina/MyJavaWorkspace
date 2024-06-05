package recap_exercises.algorithms.ex1;

import java.util.Scanner;

public class Main {

    private static int getComplementaryNumber(int n) {
        int aux = 1;
        while (aux < n) {
            aux *= 10;
        }
        return aux - n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getComplementaryNumber(n);
        System.out.print(c);
    }
}