package PROGRAMMING_2.Discussion1;

public class GeometryTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 20);
        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Rectangle perimeter: " + rectangle.perimeter());

        Square square = new Square(5);
        System.out.println("Square area: " + square.area());
        System.out.println("Square perimeter: " + square.perimeter());
    }
}
