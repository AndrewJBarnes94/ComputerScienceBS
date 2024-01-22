package PROGRAMMING_2.CTA4;

public class Cone extends Shape {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double surfaceArea() {
        double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
        return Math.PI * radius * (radius + slantHeight);
    }

    public double volume() {
        return Math.PI * Math.pow(radius, 2) * height / 3;
    }

    public String toString() {
        return 
            "Cone:"
            + "\n\tRadius = " + radius
            + "\n\tHeight = " + height
            + "\n\tSurface Area = " + surfaceArea()
            + "\n\tVolume = " + volume()
            + ")\n";
    }
}
