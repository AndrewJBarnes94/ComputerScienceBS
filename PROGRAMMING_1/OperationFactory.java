public class OperationFactory {

    public interface Operation {
        double apply(double x, double y);
    }

    public Operation getOperation(String operator) {
        return switch (operator) {
            case "add" -> (x, y) -> x + y;
            case "subtract" -> (x, y) -> x - y;
            case "multiply" -> (x, y) -> x * y;
            case "divide" -> (x, y) -> {
                if (y == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return x / y;
            };
            default -> throw new IllegalArgumentException("Unknown operator");
        };
    }

    public static void main(String[] args) {
        OperationFactory factory = new OperationFactory();
        Operation addOperation = factory.getOperation("add");
        System.out.println("Result of addition: " + addOperation.apply(5, 3));

        Operation divideOperation = factory.getOperation("divide");
        System.out.println("Result of division: " + divideOperation.apply(10, 2));
    }
}
