package PROGRAMMING_2.CTA4;

public class Cylinder extends Shape {
    private double radius;
    private double height;
    
    public Cylinder (double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double surfaceArea() {
        return 2 * Math.PI * radius * height + 2 * Math.PI * Math.pow(radius, 2);
    }

    public double volume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    public String toString() {
        return 
            "Cylinder:"
            + "\n\tRadius = " + radius
            + "\n\tHeight = " + height
            + "\n\tSurface Area = " + surfaceArea()
            + "\n\tVolume = " + volume()
            + ")\n";
    }
}
