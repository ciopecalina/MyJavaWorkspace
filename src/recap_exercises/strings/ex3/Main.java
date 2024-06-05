package recap_exercises.strings.ex3;

import java.util.Scanner;

public class Main {
    private static int convertStringToNumber(String numberStr) {
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int numValue = 0;

        for (int i = 0; i < numberStr.length(); i++) {
            for (int j = 0; j < digits.length; j++) {
                if (numberStr.charAt(i) == digits[j]) {
                    numValue = numValue * 10 + j;
                }
            }
        }
        return numValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = convertStringToNumber(s);
        System.out.println(n);
    }
}

