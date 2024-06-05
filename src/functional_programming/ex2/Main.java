package functional_programming.ex2;

import java.util.List;
import java.util.Scanner;

class DirectImplementation {
    private static final IVerifyProperty isEven = a -> a % 2 == 0;
    private static final IVerifyProperty isNegative = a -> a < 0;
    private static final IVerifyProperty isZero = a -> a == 0;

    public static List<IVerifyProperty> getChecks() {
        return List.of(isEven, isNegative, isZero);
    }
}

interface IVerifyProperty {
    boolean hasProperty(int a);
}

class MethodCallReference {
    private static boolean isEven(int a) {
        return a % 2 == 0;
    }

    private static boolean isNegative(int a) {
        return a < 0;
    }

    private static boolean isZero(int a) {
        return a == 0;
    }

    public static List<IVerifyProperty> getChecks() {
        IVerifyProperty isEven = a -> isEven(a);
        IVerifyProperty isNegative = a -> isNegative(a);
        IVerifyProperty isZero = a -> isZero(a);

        return List.of(isEven, isNegative, isZero);
    }
}

class MethodReference {
    private static boolean isEven(int a) {
        return a % 2 == 0;
    }

    private static boolean isNegative(int a) {
        return a < 0;
    }

    private static boolean isZero(int a) {
        return a == 0;
    }

    public static List<IVerifyProperty> getChecks() {
        IVerifyProperty isEven = MethodReference::isEven;
        IVerifyProperty isNegative = MethodReference::isNegative;
        IVerifyProperty isZero = MethodReference::isZero;

        return List.of(isEven, isNegative, isZero);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testIdx = scanner.nextInt();
        List<IVerifyProperty> checks;

        if (testIdx == 1) {
            checks = DirectImplementation.getChecks();
        } else if (testIdx == 2) {
            checks = MethodReference.getChecks();
        } else {
            checks = MethodReference.getChecks();
        }

        for (IVerifyProperty item : checks) {
            System.out.println(item.hasProperty(2));
        }
        for (IVerifyProperty item : checks) {
            System.out.println(item.hasProperty(-3));
        }
        for (IVerifyProperty item : checks) {
            System.out.println(item.hasProperty(0));
        }
    }
}
