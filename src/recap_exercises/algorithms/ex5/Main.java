package recap_exercises.algorithms.ex5;


import java.util.Scanner;

public class Main {

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void printPrimesSequence(int limit) {
        int sum = 0;
        int i = 2;
        System.out.print(i);
        do {
            if (isPrime(i)) {
                sum += i;
                if (i != 2) {
                    System.out.print(" " + sum);
                }
            }
            i++;
        } while (sum < limit && i <= limit / 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 2) {
            System.out.print("Niciun numar prim nu a fost gasit.");
        } else {
            printPrimesSequence(n);
        }
    }
}

