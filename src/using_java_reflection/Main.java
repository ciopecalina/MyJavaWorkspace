package using_java_reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    private static void invokeDisplaySerialNumberAndPassowrd(Vehicle vehicle) {
        try {
            Method method = Vehicle.class.getDeclaredMethod("displaySerialNumberAndPassword");
            method.setAccessible(true);
            method.invoke(vehicle);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void increaseNoPersons(Vehicle vehicle) {
        try {
            Method method = Vehicle.class.getDeclaredMethod("changeNoPersons", int.class);
            method.setAccessible(true);
            Field field = Vehicle.class.getDeclaredField("noPersons");
            field.setAccessible(true);
            int currentNoPersons = (int) field.get(vehicle);
            method.invoke(vehicle, currentNoPersons * 2);
            System.out.println(vehicle.getNoPersons());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        String serialNumber = scanner.nextLine();
        int noPersons = Integer.parseInt(scanner.nextLine());
        Vehicle vehicle = new Vehicle(serialNumber, noPersons);
        switch (a) {
            case 1:
                invokeDisplaySerialNumberAndPassowrd(vehicle);
                break;
            case 2:
                increaseNoPersons(vehicle);
                break;
        }
    }
}

class Vehicle {
    private final String serialNumber;
    private int noPersons;
    private String name;

    public Vehicle(String serialNumber, int noPersons, String name) {
        this.serialNumber = serialNumber;
        this.noPersons = noPersons;
        this.name = name;
    }

    public Vehicle(String serialNumber, int noPersons) {
        this(serialNumber, noPersons, "");
    }

    private void displaySerialNumberAndPassword() {
        System.out.println("Method hacked: " + serialNumber);
        System.out.println("Password is: " + "dsf98fsd98!{dev}hack!345m");
    }

    private boolean changeNoPersons(int no) {
        this.noPersons = no;
        return true;
    }

    public int getNoPersons() {
        return noPersons;
    }
}

