package recap_exercises.algorithms.ex6;

import java.util.Scanner;

public class Main {
    public static void printPitagoreicTriplets(int limit) {
        int noOfTriplets = 0;

        for (int a = 1; a <= limit; a++) {
            for (int b = a; b <= limit; b++) {
                int totalSumOfSquares = (int) (Math.pow(a, 2) + Math.pow(b, 2));
                int c = (int) (Math.sqrt(totalSumOfSquares));

                if ((int) (Math.pow(c, 2)) == totalSumOfSquares && c <= limit) {
                    noOfTriplets++;
                    if (noOfTriplets == 1) {
                        System.out.print(a + " " + b + " " + c);
                    } else {
                        System.out.print("\n" + a + " " + b + " " + c);
                    }
                }
            }
        }
        if (noOfTriplets == 0) {
            System.out.print("Niciun triplet nu a fost gasit.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPitagoreicTriplets(n);
    }
}
