package PROGRAMMING_2.CTA4;

public class ShapeArray {
    public static void main(String[] args) {
        Shape[] shapeArray = new Shape[3];

        shapeArray[0] = new Sphere(2.0);
        shapeArray[1] = new Cylinder(3.0, 4.0);
        shapeArray[2] = new Cone(5.0, 6.0);

        for (Shape shape : shapeArray) {
            System.out.println(shape);
        }
    }
}
