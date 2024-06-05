package matrices.matrix_customization.ex3_arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final int ADD = 0;
    private static final int SUBSTRACT = 1;
    private static final int MULTIPLY = 2;
    private static final int MULTIPLY_MATRIX = 3;

    private static final Map<String, Integer> commandsMap = createCommandsMap();

    private static Map<String, Integer> createCommandsMap() {
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("add", ADD);
        myMap.put("substract", SUBSTRACT);
        myMap.put("multiply", MULTIPLY);
        myMap.put("multiplyMatrix", MULTIPLY_MATRIX);
        return myMap;
    }

    private static ArrayList<ArrayList<Integer>> allocMatrix(int n, int m) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(0);
            }
            matrix.add(row);
        }
        return matrix;
    }

    private static ArrayList<ArrayList<Integer>> adunare(ArrayList<ArrayList<Integer>> a, ArrayList<ArrayList<Integer>> b) {
        int n = a.size();
        int m = a.get(0).size();
        ArrayList<ArrayList<Integer>> result = allocMatrix(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.get(i).set(j, a.get(i).get(j) + b.get(i).get(j));
            }
        }
        return result;
    }

    private static ArrayList<ArrayList<Integer>> scadere(ArrayList<ArrayList<Integer>> a, ArrayList<ArrayList<Integer>> b) {
        int n = a.size();
        int m = a.get(0).size();
        ArrayList<ArrayList<Integer>> result = allocMatrix(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.get(i).set(j, a.get(i).get(j) - b.get(i).get(j));
            }
        }
        return result;
    }

    private static ArrayList<ArrayList<Integer>> inmultireScalar(ArrayList<ArrayList<Integer>> a, int sc) {
        int n = a.size();
        int m = a.get(0).size();
        ArrayList<ArrayList<Integer>> result = allocMatrix(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.get(i).set(j, a.get(i).get(j) * sc);
            }
        }
        return result;
    }

    private static ArrayList<ArrayList<Integer>> inmultire(ArrayList<ArrayList<Integer>> a, ArrayList<ArrayList<Integer>> b) {
        int n1 = a.size();
        int m1 = a.get(0).size();
        int n2 = b.size();
        int m2 = b.get(0).size();

        if (m1 != n2) {
            return null;
        }

        ArrayList<ArrayList<Integer>> result = allocMatrix(n1, m2);
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                int sum = 0;
                for (int k = 0; k < m1; k++) {
                    sum += a.get(i).get(k) * b.get(k).get(j);
                }
                result.get(i).set(j, sum);
            }
        }
        return result;
    }

    private ArrayList<ArrayList<Integer>> readMatrix(Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Integer>> matrix = allocMatrix(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix.get(i).set(j, scanner.nextInt());
            }
        }
        return matrix;
    }

    private void printMatrix(ArrayList<ArrayList<Integer>> array) {
        for (int i = 0; i < array.size(); ++i) {
            for (int elem : array.get(i)) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Main main = new Main();
        ArrayList<ArrayList<Integer>> A = main.readMatrix(scanner);
        ArrayList<ArrayList<Integer>> B;

        ArrayList<ArrayList<Integer>> res;
        switch (commandsMap.get(command)) {
            case ADD:
                B = main.readMatrix(scanner);
                res = main.adunare(A, B);
                main.printMatrix(res);
                break;
            case SUBSTRACT:
                B = main.readMatrix(scanner);
                res = main.scadere(A, B);
                main.printMatrix(res);
                break;
            case MULTIPLY:
                int scalar = scanner.nextInt();
                res = main.inmultireScalar(A, scalar);
                main.printMatrix(res);
                break;
            case MULTIPLY_MATRIX:
                B = main.readMatrix(scanner);
                res = main.inmultire(A, B);
                main.printMatrix(res);
                break;
        }
        scanner.close();
    }
}