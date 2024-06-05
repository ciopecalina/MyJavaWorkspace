package recap_exercises.recursion_and_arrays.ex4b;

import java.util.Scanner;

public class Main {

    private static void bubbleSort(double[] array) {
        double aux = 0;
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < (n - 1); i++) {
            swapped = false;
            for (int j = 0; j < (n - i - 1); j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
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
