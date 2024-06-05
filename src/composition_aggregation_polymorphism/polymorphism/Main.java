package composition_aggregation_polymorphism.polymorphism;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Terrestrial {
    String name;

    Terrestrial(String name) {
        this.name = name;
    }

    public void greet() {
        System.out.println("Hello, my name is " + this.name);
    }
}

class Tiger extends Terrestrial {
    Tiger(String name) {
        super(name);
    }

    @Override
    public void greet() {
        super.greet();
    }

    public void greet(String nickname) {
        System.out.println("Hello, my name is " + this.name + " and I am a tiger! But they call me " + nickname + ".");
    }
}

class Zebra extends Terrestrial {
    Zebra(String name) {
        super(name);
    }

    @Override
    public void greet() {
        System.out.println("Hello, my name is " + this.name + " and I am a zebra!");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testIdx = scanner.nextInt();

        switch (testIdx) {
            case 1:
                Set<String> names = new HashSet<>();
                for (Method method : Tiger.class.getDeclaredMethods()) {
                    String name = method.getName();
                    if (names.contains(name)) {
                        System.out.println("Static polymorphism properly implemented");
                        return;
                    } else {
                        names.add(name);
                    }
                }
                System.out.println("Static polymorphism has to be implemented in the Tiger class!");
                break;

            case 2:
                try {
                    if (Zebra.class.getMethod("greet").getDeclaringClass().equals(Zebra.class)) {
                        System.out.println("Dynamic polymorphism properly implemented");
                    } else {
                        System.out.println("Dynamic polymorphism has to be implemented in the Zebra class!");
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
