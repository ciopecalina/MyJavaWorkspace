package inheritance;

import java.lang.reflect.Modifier;
import java.util.Scanner;

class Vehicle {
    protected final String serialNumber;
    private final int noPersons;
    private String name;


    public Vehicle(String serialNumber, int noPersons) {
        this.serialNumber = serialNumber;
        this.noPersons = noPersons;
    }

    public Vehicle(String serialNumber, int noPersons, String name) {
        this.serialNumber = serialNumber;
        this.noPersons = noPersons;
        this.name = name;
    }


    public String getSerialNumber() {
        return this.serialNumber;
    }

    public boolean goTo(double positionX, double positionY) {
        System.out.println("Error: unknown vehicle cannot move...");
        return false;
    }

    public boolean addFuel(double amount) {
        System.out.println("Error: unknown type of vehicle...");
        return false;
    }

    public void printInfo() {
        System.out.println("Vehicle properties:"
                + "\n\t- serial number: " + this.serialNumber
                + "\n\t- capacity: " + this.noPersons + " persons"
                + "\n\t- name: " + this.name);
    }

}

class OnRoad extends Vehicle {
    private final int noWheels;
    private final int noDoors;

    public OnRoad(String serialNumber, int noPersons) {
        super(serialNumber, noPersons);
        this.noWheels = 4;
        this.noDoors = 4;
    }

    public OnRoad(String serialNumber, int noPersons, String name) {
        super(serialNumber, noPersons, name);
        this.noWheels = 4;
        this.noDoors = 4;
    }

    public OnRoad(String serialNumber, int noPersons, String name, int noWheels) {
        super(serialNumber, noPersons, name);
        this.noWheels = noWheels;
        this.noDoors = 4;

    }

    public OnRoad(String serialNumber, int noPersons, String name, int noWheels, int noDoors) {
        super(serialNumber, noPersons, name);
        this.noWheels = noWheels;
        this.noDoors = noDoors;
    }

    @Override
    public boolean goTo(double positionX, double positionY) {
        System.out.println("Driving the vehicle on road to coordinates: [" + positionX + ", " + positionY + "]");
        return true;
    }

    @Override
    public boolean addFuel(double amount) {
        System.out.println("Adding " + amount + " l of fuel to the driving vehicle");
        return true;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Driving vehicle properties:"
                + "\n\t- number of wheels: " + this.noWheels
                + "\n\t- number of doors: " + this.noDoors);
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }
}

class OnWater extends Vehicle {
    private final int noEngines;
    private final double cargoCapacity;


    public OnWater(String serialNumber, int noPersons) {
        super(serialNumber, noPersons);
        this.noEngines = 2;
        this.cargoCapacity = 0;
    }

    public OnWater(String serialNumber, int noPersons, String name) {
        super(serialNumber, noPersons, name);
        this.noEngines = 2;
        this.cargoCapacity = 0;
    }

    public OnWater(String serialNumber, int noPersons, String name, int noEngines) {
        super(serialNumber, noPersons, name);
        this.noEngines = noEngines;
        this.cargoCapacity = 0;
    }

    public OnWater(String serialNumber, int noPersons, String name, int noEngines, double cargoCapacity) {
        super(serialNumber, noPersons, name);
        this.noEngines = noEngines;
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public boolean goTo(double positionX, double positionY) {
        System.out.println("Sailing the vessel to coordinates: [" + positionX + ", " + positionY + "]");
        return true;
    }

    @Override
    public boolean addFuel(double amount) {
        System.out.println("Adding " + amount + " l of fuel to the vessel");
        return true;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Vessel properties:"
                + "\n\t- number of engines: " + this.noEngines
                + "\n\t- cargo capacity: " + this.cargoCapacity);
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

}

class OnAir extends Vehicle {
    private final int noTurbines;
    private boolean hasFirstClass;

    public OnAir(String serialNumber, int noPersons) {
        super(serialNumber, noPersons);
        this.noTurbines = 2;
        this.hasFirstClass = false;
    }

    public OnAir(String serialNumber, int noPersons, String name) {
        super(serialNumber, noPersons, name);
        this.noTurbines = 2;
        this.hasFirstClass = false;
    }

    public OnAir(String serialNumber, int noPersons, String name, int noTurbines) {
        super(serialNumber, noPersons, name);
        this.noTurbines = noTurbines;
        this.hasFirstClass = false;
    }

    public OnAir(String serialNumber, int noPersons, String name, int noTurbines, boolean hasFirstClass) {
        super(serialNumber, noPersons, name);
        this.noTurbines = noTurbines;
        this.hasFirstClass = hasFirstClass;
    }

    @Override
    public boolean goTo(double positionX, double positionY) {
        System.out.println("Flying the airplane to coordinates: [" + positionX + ", " + positionY + "]");
        return true;
    }

    @Override
    public boolean addFuel(double amount) {
        System.out.println("Adding " + amount + " l of fuel to the airplane");
        return true;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Airplane properties:"
                + "\n\t- number of turbines: " + this.noTurbines);

        if (hasFirstClass == true) {
            System.out.println("\t- has first class");
        } else {
            System.out.println("\t- does not have first class");
        }
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testIdx = scanner.nextInt();
        switch (testIdx) {
            case 1:
                try {
                    if (Modifier.isFinal(Vehicle.class.getDeclaredField("serialNumber").getModifiers())
                            && (Modifier.isFinal(Vehicle.class.getDeclaredField("noPersons").getModifiers()))) {
                        System.out.println("serialNumber and noPersons were properly declared");
                    } else {
                        System.out.println("serialNumber and noPersons should only be set once!");
                    }
                } catch (NoSuchFieldException | SecurityException e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                try {
                    if (Modifier.isFinal(OnRoad.class.getDeclaredField("noWheels").getModifiers())
                            && (Modifier.isFinal(OnRoad.class.getDeclaredField("noDoors").getModifiers()))) {
                        System.out.println("noWheels and noDoors were properly declared");
                    } else {
                        System.out.println("noWheels and noDoors should only be set once!");
                    }

                    if (Modifier.isFinal(OnWater.class.getDeclaredField("noEngines").getModifiers())) {
                        System.out.println("noEngines was properly declared");
                    } else {
                        System.out.println("noEngines should only be set once!");
                    }

                    if (Modifier.isFinal(OnAir.class.getDeclaredField("noTurbines").getModifiers())) {
                        System.out.println("noTurbines was properly declared");
                    } else {
                        System.out.println("noTurbines should only be set once!");
                    }
                } catch (NoSuchFieldException | SecurityException e) {
                    e.printStackTrace();
                }
                break;

            case 3:
                try {
                    Vehicle.class.getConstructor(String.class, int.class);
                    System.out.println("Constructor Vehicle(String, int) found");

                    Vehicle.class.getConstructor(String.class, int.class, String.class);
                    System.out.println("Constructor Vehicle(String, int, String) found");
                } catch (NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                }
                break;

            case 4:
                try {
                    OnRoad.class.getConstructor(String.class, int.class);
                    System.out.println("Constructor OnRoad(String, int) found");

                    OnRoad.class.getDeclaredConstructor(String.class, int.class, String.class);
                    System.out.println("Constructor OnRoad(String, int, String) found");

                    OnRoad.class.getDeclaredConstructor(String.class, int.class, String.class, int.class);
                    System.out.println("Constructor OnRoad(String, int, String, int) found");

                    OnRoad.class.getDeclaredConstructor(
                            String.class, int.class, String.class, int.class, int.class);
                    System.out.println("Constructor OnRoad(String, int, String, int, int) found");
                } catch (NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                }
                break;

            case 5:
                try {
                    OnWater.class.getConstructor(String.class, int.class);
                    System.out.println("Constructor OnWater(String, int) found");

                    OnWater.class.getDeclaredConstructor(String.class, int.class, String.class);
                    System.out.println("Constructor OnWater(String, int, String) found");

                    OnWater.class.getDeclaredConstructor(String.class, int.class, String.class, int.class);
                    System.out.println("Constructor OnWater(String, int, String, int) found");

                    OnWater.class.getDeclaredConstructor(
                            String.class, int.class, String.class, int.class, double.class);
                    System.out.println("Constructor OnWater(String, int, String, int, double) found");
                } catch (NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                }
                break;

            case 6:
                try {
                    OnAir.class.getConstructor(String.class, int.class);
                    System.out.println("Constructor OnAir(String, int) found");

                    OnAir.class.getDeclaredConstructor(String.class, int.class, String.class);
                    System.out.println("Constructor OnAir(String, int, String) found");

                    OnAir.class.getDeclaredConstructor(String.class, int.class, String.class, int.class);
                    System.out.println("Constructor OnAir(String, int, String, int) found");

                    OnAir.class.getDeclaredConstructor(
                            String.class, int.class, String.class, int.class, boolean.class);
                    System.out.println("Constructor OnAir(String, int, String, int, boolean) found");
                } catch (NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                }
                break;

            case 7:
                Vehicle v7 = new Vehicle("3FDS9DFF8FSD7", 4, "Moby");
                System.out.println(v7.goTo(22, 23));
                System.out.println(v7.addFuel(100));
                System.out.println(v7.getSerialNumber());
                v7.printInfo();
                break;

            case 8:
                OnRoad v8 = new OnRoad("FDFL8KMFSDLKM6", 2, "Sporty", 4, 2);
                System.out.println(v8.goTo(21.3, 12.88));
                System.out.println(v8.addFuel(28.12));
                System.out.println(v8.getSerialNumber());
                v8.printInfo();
                break;

            case 9:
                OnWater v9 = new OnWater("F8GFDG86D87GGD", 20, "Wavess", 2, 2000);
                System.out.println(v9.goTo(11.8, 4.33));
                System.out.println(v9.addFuel(148.05));
                System.out.println(v9.getSerialNumber());
                v9.printInfo();
                break;

            case 10:
                OnAir v10 = new OnAir("GJR96GDF98DF9ND", 120, "Bluesky", 2, false);
                System.out.println(v10.goTo(41.3, 120.88));
                System.out.println(v10.addFuel(3000.5));
                System.out.println(v10.getSerialNumber());
                v10.printInfo();
                break;
        }
    }
}
