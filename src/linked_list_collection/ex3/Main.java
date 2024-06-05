package linked_list_collection.ex3;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static LinkedList<Integer> sum(LinkedList<Integer> op1, LinkedList<Integer> op2) {
        LinkedList<Integer> result = new LinkedList<>();

        while (op1.size() < op2.size()) {
            op1.addFirst(0);
        }
        while (op2.size() < op1.size()) {
            op2.addFirst(0);
        }

        int carry = 0;

        ListIterator<Integer> iterator1 = op1.listIterator(op1.size());
        ListIterator<Integer> iterator2 = op2.listIterator(op2.size());

        while (iterator1.hasPrevious() || iterator2.hasPrevious() || carry > 0) {
            int sum = carry;
            if (iterator1.hasPrevious()) {
                sum += iterator1.previous();
            }
            if (iterator2.hasPrevious()) {
                sum += iterator2.previous();
            }

            result.addFirst(sum % 10);
            carry = sum / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op1Size = scanner.nextInt();
        LinkedList<Integer> op1 = new LinkedList<Integer>();
        for (int i = 0; i < op1Size; ++i) {
            int x = scanner.nextInt();
            op1.add(x);
        }

        int op2Size = scanner.nextInt();
        LinkedList<Integer> op2 = new LinkedList<Integer>();
        for (int i = 0; i < op2Size; ++i) {
            int x = scanner.nextInt();
            op2.add(x);
        }

        LinkedList<Integer> res = sum(op1, op2);
        for (Integer cif : res) {
            System.out.print(cif);
        }
        System.out.println();
    }
}
