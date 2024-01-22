package PROGRAMMING_2.CTA4;

public class Sphere extends Shape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double surfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double volume() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }

    public String toString() {
        return
            "Sphere:"
            + "\n\tRadius = " + radius
            + "\n\tSurface Area = " + surfaceArea()
            + "\n\tVolume = " + volume()
            + ")\n";
    }
}
