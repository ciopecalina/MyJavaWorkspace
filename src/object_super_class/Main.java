package object_super_class;

import java.util.ArrayList;
import java.util.Scanner;


class Shape {

    private String text;
    private String material;

    public Shape() {
        this.text = "";
        this.material = "";
    }

    public Shape(String text, String material) {
        this.text = text;
        this.material = material;
    }

    @Override
    public String toString() {
        return "made of " + this.material + ", contains the text: \"" + this.text + "\".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        Shape other = (Shape) o;
        if (this.text.equals(other.text) &&
                this.material.equals(other.material)) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + ((material == null) ? 0 : material.hashCode());
        return result;
    }

    public int getSize() {
        return (-1);
    }

}

class Triangle extends Shape {
    private int base;
    private int height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public Triangle(String text, String material, int base, int height) {
        super(text, material);
        this.base = base;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Triangle: height is " + this.height + ", base is: " + this.base + ", " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (this == null) {
            return false;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        Triangle other = (Triangle) o;
        if (super.equals(other) &&
                this.base == other.base &&
                this.height == other.height) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + base;
        result = prime * result + height;
        return result;
    }

    public void displayTriangleHeight() {
        System.out.println("Triangle height is: " + this.height);
    }

    @Override
    public int getSize() {
        return (this.base * this.height) / 2;
    }
}


class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public Rectangle(String text, String material, int width, int height) {
        super(text, material);
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle: height is: " + this.height + ", width is: "
                + this.width + ", " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (this == null) {
            return false;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        Rectangle other = (Rectangle) o;
        if (super.equals(other) &&
                this.width == other.width &&
                this.height == other.height) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + width;
        result = prime * result + height;
        return result;
    }

    public void displayRectangleHeight() {
        System.out.println("Rectangle height is: " + this.height);
    }

    @Override
    public int getSize() {
        return this.width * this.height;
    }

}

public class Main {
    public static Triangle readTriangle(Scanner sc) {
        String material = sc.nextLine();
        String message = sc.nextLine();
        int base = sc.nextInt();
        int height = sc.nextInt();
        return new Triangle(message, material, base, height);
    }

    public static Rectangle readRectangle(Scanner sc) {
        String material = sc.nextLine();
        String message = sc.nextLine();
        int width = sc.nextInt();
        int height = sc.nextInt();
        return new Rectangle(message, material, width, height);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Shape> myShapes = new ArrayList<Shape>();
        int a = scanner.nextInt();
        switch (a) {
            case 1:
                while (scanner.hasNext()) {
                    scanner.nextLine();
                    Triangle t = readTriangle(scanner);
                    t.displayTriangleHeight();
                    System.out.println(t.toString());
                    System.out.println(t.getSize());
                    myShapes.add(t);
                }
                if (myShapes.size() > 1) {
                    Triangle first = (Triangle) myShapes.get(0);
                    for (int i = 1; i < myShapes.size(); ++i) {
                        Triangle t = (Triangle) myShapes.get(i);
                        System.out.println(t.equals(first));
                    }
                }
                break;
            case 2:
                while (scanner.hasNext()) {
                    scanner.nextLine();
                    Rectangle t = readRectangle(scanner);
                    t.displayRectangleHeight();
                    System.out.println(t.toString());
                    System.out.println(t.getSize());
                    myShapes.add(t);
                }
                if (myShapes.size() > 1) {
                    Rectangle first = (Rectangle) myShapes.get(0);
                    for (int i = 1; i < myShapes.size(); ++i) {
                        Rectangle r = (Rectangle) myShapes.get(i);
                        System.out.println(r.equals(first));
                    }
                }
                break;
            case 3:
                int c = 0;
                while (scanner.hasNext()) {
                    scanner.nextLine();
                    Shape s;
                    if (c % 2 == 0) {
                        s = readTriangle(scanner);
                    } else {
                        s = readRectangle(scanner);
                    }
                    System.out.println(s.toString());
                    myShapes.add(s);
                    ++c;
                }
                if (myShapes.size() > 1) {
                    Shape first = myShapes.get(0);
                    for (int i = 1; i < myShapes.size(); ++i) {
                        System.out.println(myShapes.get(i).equals(first));
                    }
                }
                break;
        }
    }
}

