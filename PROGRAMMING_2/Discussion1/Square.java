package PROGRAMMING_2.Discussion1;

public class Square extends Rectangle{

    public Square(double side) {
        super(side, side);
    }

    @Override
    public double area() {
        return getLength() * getLength();
    }
}
