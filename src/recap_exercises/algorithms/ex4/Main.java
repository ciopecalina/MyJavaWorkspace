package recap_exercises.algorithms.ex4;

import java.util.Scanner;

public class Main {

    private static int computePossibleFriend(int x) {
        int sumOfDivisors = 0;
        for (int i = 1; i <= x / 2; i++) {
            if (x % i == 0) {
                sumOfDivisors += i;
            }
        }
        return sumOfDivisors;
    }

    private static int getFriend(int x) {
        int posssibleFriendOfX = computePossibleFriend(x);
        int posssibleFriendOfposssibleFriendOfX = computePossibleFriend(posssibleFriendOfX);

        if (posssibleFriendOfposssibleFriendOfX == x) {
            return posssibleFriendOfX;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lowerLimit = scanner.nextInt();
        int upperLimit = scanner.nextInt();

        int noOfPairs = 0;

        for (int i = lowerLimit; i <= upperLimit; i++) {
            int rez = getFriend(i);

            if (i < rez) {
                noOfPairs += 1;

                if (noOfPairs == 1) {
                    System.out.print(i + " " + rez);
                } else if (noOfPairs > 1) {
                    System.out.print("\n" + i + " " + rez);
                }
            }

        }

        if (noOfPairs == 0) {
            System.out.print("Nicio pereche nu a fost gasita in intervalul dorit.");
        }
    }
}

