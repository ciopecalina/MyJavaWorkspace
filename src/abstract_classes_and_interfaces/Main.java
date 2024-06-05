package abstract_classes_and_interfaces;

import java.lang.reflect.Modifier;
import java.util.Scanner;

class Rectangle extends Shape {

    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(String text, String material, int width, int height) {
        super(text, material);
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle: height is: "
                + this.height
                + ", width is "
                + this.width
                + ", "
                + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;

        Rectangle other = (Rectangle) obj;

        return super.equals(other) && this.width == other.width && this.height == other.height;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + this.width;
        result = prime * result + this.height;
        return result;
    }

    public void displayRectangleHeight() {
        System.out.println("Rectangle height is: " + this.height);
    }

    public int getSize() {
        return this.width * this.height;
    }
}

abstract class Shape {

    private final String text;
    private final String material;

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
        return "made of " + this.material + ", contains the text: " + this.text + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;

        Shape other = (Shape) obj;

        return this.text.equals(other.text) && this.material.equals(other.material);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.text == null) ? 0 : this.text.hashCode());
        result = prime * result + ((this.material == null) ? 0 : this.material.hashCode());
        return result;
    }

    public abstract int getSize();
}

class Triangle extends Shape {

    private final int base;
    private final int height;

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
        return "Triangle: height is "
                + this.height
                + ", base is: "
                + this.base
                + ", "
                + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;

        Triangle other = (Triangle) obj;

        return super.equals(other) && this.base == other.base && this.height == other.height;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + this.base;
        result = prime * result + this.height;
        return result;
    }

    public void displayTriangleHeight() {
        System.out.println("Triangle height is: " + this.height);
    }

    public int getSize() {
        return (this.base * this.height) / 2;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNumber = scanner.nextInt();
        switch (testNumber) {
            case 1:
                if (Modifier.isAbstract(Shape.class.getModifiers())) {
                    System.out.println("Shape class is abstract");
                } else {
                    System.out.println("Shape class is not abstract!");
                }
                break;
            case 2:
                try {
                    if (Modifier.isAbstract(Shape.class.getDeclaredMethod("getSize").getModifiers())) {
                        System.out.println("getSize method is abstract");
                    } else {
                        System.out.println("getSize method is not abstract!");
                    }
                } catch (NoSuchMethodException e) {
                    System.out.println("getSize method not declared in class Shape!");
                }
                break;
            default:
                System.out.println("Invalid test number!");
                break;
        }
    }
}
