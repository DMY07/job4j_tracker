package ru.job4j.oop;

import static java.lang.Math.sqrt;

public class Triangle {
    private Point one;
    private Point two;
    private Point three;

    public Triangle(Point ap, Point bp, Point cp) {
        this.one = ap;
        this.two = bp;
        this.three = cp;
    }
//тест тт

    public double semiPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public boolean exist(double ab, double ac, double bc) {
        return ab + ac > bc && ab + bc > ac && ac + bc > ab;
    }

    public double area() {
        double result = -1;
        double ab = one.distance(two);
        double ac = one.distance(three);
        double bc = two.distance(three);
        if (exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);
            result = sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return result;
    }
}
