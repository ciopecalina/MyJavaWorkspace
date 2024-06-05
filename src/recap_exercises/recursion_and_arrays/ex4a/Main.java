package recap_exercises.recursion_and_arrays.ex4a;

import java.util.Scanner;

public class Main {

    private static void bubbleSort(double[] array) {
        double aux = 0;
        int n = array.length;

        for (int i = 0; i < n; i++)
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
                    aux = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = aux;
                }
            }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] doubleArray = new double[n];

        for (int i = 0; i < n; ++i) {
            doubleArray[i] = scanner.nextDouble();
        }
        bubbleSort(doubleArray);

        for (int i = 0; i < doubleArray.length; ++i) {
            System.out.print(doubleArray[i] + " ");
        }
    }
}

