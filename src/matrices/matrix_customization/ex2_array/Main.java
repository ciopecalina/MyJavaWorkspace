package matrices.matrix_customization.ex2_array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final int ADD = 0;
    private static final int SUBSTRACT = 1;
    private static final int MULTIPLY = 2;
    private static final int MULTIPLY_MATRIX = 3;

    private static Map<String, Integer> commandsMap = createCommandsMap();

    private static Map<String, Integer> createCommandsMap() {
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("add", ADD);
        myMap.put("substract", SUBSTRACT);
        myMap.put("multiply", MULTIPLY);
        myMap.put("multiplyMatrix", MULTIPLY_MATRIX);
        return myMap;
    }

    private static int[][] adunare(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            return null;
        }

        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    private static int[][] scadere(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            return null;
        }

        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    private static int[][] inmultireScalar(int[][] a, int sc) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] * sc;
            }
        }
        return result;
    }

    private static int[][] inmultire(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            return null;
        }

        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    private static int[][] readMatrix(Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] array) {
        for (int[] row : array) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int[][] A = readMatrix(scanner);
        int[][] B;

        int[][] res;
        switch (commandsMap.get(command)) {
            case ADD:
                B = readMatrix(scanner);
                res = adunare(A, B);
                printMatrix(res);
                break;
            case SUBSTRACT:
                B = readMatrix(scanner);
                res = scadere(A, B);
                printMatrix(res);
                break;
            case MULTIPLY:
                int b = scanner.nextInt();
                res = inmultireScalar(A, b);
                printMatrix(res);
                break;
            case MULTIPLY_MATRIX:
                B = readMatrix(scanner);
                res = inmultire(A, B);
                printMatrix(res);
                break;
        }
    }
}
