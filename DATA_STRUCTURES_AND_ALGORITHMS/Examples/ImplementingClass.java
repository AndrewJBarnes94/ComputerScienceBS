package DATA_STRUCTURES_AND_ALGORITHMS.Examples;

public class ImplementingClass implements SimpleInterface {
    @Override
    public void performAction() {
        System.out.println("Perform action!");
    }

    public static void main(String[] args) {
        ImplementingClass obj = new ImplementingClass();
        obj.performAction();
    }
}