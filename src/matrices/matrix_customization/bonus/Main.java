package matrices.matrix_customization.bonus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int[][] generateMatrix(int rows, int limit) {
        final int col = 10;
        int[][] result = new int[rows][col];
        int num = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = ++num;
                if (num == limit) break;
            }
        }

        result[0][0] = 0; // 1 nu este numar prim

        return result;
    }

    private static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < 10) System.out.print("  " + num + " ");
                else if (num < 100) System.out.print(" " + num + " ");
                else System.out.print(num + " ");
            }

            System.out.println();
        }
    }

    private static ArrayList<Integer> eratostene(int[][] mat) {
        ArrayList<Integer> primes = new ArrayList<>();
        int limit = mat.length * mat[0].length;

        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(limit); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int num = mat[i][j];
                if (num <= limit && isPrime[num]) {
                    primes.add(num);
                }
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();
        int rows = limit / 10 + 1; // daca limit < 10, am avea 0 randuri
        if (limit % 10 == 0) rows--; // daca limit se imparte egal la 0, un rand este suficient
        int[][] matrix = generateMatrix(rows, limit);
        List<Integer> primes = eratostene(matrix);
        System.out.println(primes);
    }
}
