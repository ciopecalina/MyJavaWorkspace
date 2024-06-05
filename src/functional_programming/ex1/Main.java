package functional_programming.ex1;

import java.util.List;
import java.util.Scanner;

class DirectImplementation {
    private final static IOperator sum = (a, b) -> a + b;
    private final static IOperator difference = (a, b) -> a - b;
    private final static IOperator multiply = (a, b) -> a * b;
    private final static IOperator division = (a, b) -> a / b;
    private final static IOperator modulo = (a, b) -> a % b;

    public static List<IOperator> getOperations() {
        return List.of(sum, difference, multiply, division, modulo);
    }
}

interface IOperator {
    int operation(int a, int b);
}

class MethodCallReference {
    private static int sum(int a, int b) {
        return a + b;
    }

    private static int difference(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static int division(int a, int b) {
        return a / b;
    }

    private static int modulo(int a, int b) {
        return a % b;
    }

    public static List<IOperator> getOperations() {
        IOperator sum = (a, b) -> sum(a, b);
        IOperator difference = (a, b) -> difference(a, b);
        IOperator multiply = (a, b) -> multiply(a, b);
        IOperator division = (a, b) -> division(a, b);
        IOperator modulo = (a, b) -> modulo(a, b);

        return List.of(sum, difference, multiply, division, modulo);
    }
}

class MethodReference {
    private static int sum(int a, int b) {
        return a + b;
    }

    private static int difference(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static int division(int a, int b) {
        return a / b;
    }

    private static int modulo(int a, int b) {
        return a % b;
    }

    public static List<IOperator> getOperations() {
        IOperator sum = MethodReference::sum;
        IOperator difference = MethodReference::difference;
        IOperator multiply = MethodReference::multiply;
        IOperator division = MethodReference::division;
        IOperator modulo = MethodReference::modulo;

        return List.of(sum, difference, multiply, division, modulo);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testIdx = scanner.nextInt();
        List<IOperator> operations;

        if (testIdx == 1) {
            operations = DirectImplementation.getOperations();
        } else if (testIdx == 2) {
            operations = MethodReference.getOperations();
        } else {
            operations = MethodReference.getOperations();
        }

        for (IOperator item : operations) {
            System.out.println(item.operation(2, 3));
        }
    }
}

