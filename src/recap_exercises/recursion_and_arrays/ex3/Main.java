package recap_exercises.recursion_and_arrays.ex3;

import java.util.Scanner;

public class Main {
    private static void moveZeroesToStart(int[] arr) {
        int indexOfLastZeroValue = arr.length - 1;
        int i = arr.length - 1;

        while (i >= 0) {
            if (arr[i] != 0) {
                arr[indexOfLastZeroValue] = arr[i];
                indexOfLastZeroValue--;
            }
            i--;
        }

        while (indexOfLastZeroValue >= 0) {
            arr[indexOfLastZeroValue] = 0;
            indexOfLastZeroValue--;
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = scanner.nextInt();
        }

        moveZeroesToStart(array);
    }
}

