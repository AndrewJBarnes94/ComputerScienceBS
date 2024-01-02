package DATA_STRUCTURES_AND_ALGORITHMS.BookExamples;

public class ArrayBagDemo1 {
    public static void main(String[] args) {
        System.out.println("Testing an initially empty bag with sufficient capacity:");
        BagInterface<String> aBag = new ArrayBag<>();
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        testAdd(aBag, contentsOfBag1);

        System.out.println("Testing an initially empty bag that will be filled to capacity:");
        aBag = new ArrayBag<>(7);
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};
        testAdd(aBag, contentsOfBag2);
    }

    private static void testAdd(BagInterface<String> aBag, String[] content) {
        System.out.println("Adding the following strings to the bag:");
        for (int index = 0; index < content.length; index++) {
            if (aBag.add(content[index])) {
                System.out.println(content[index]);
            } else {
                System.out.print("Unable to add " + content[index] + " to the bag.");
            }
        }
        System.out.println();
        displayBag(aBag);
    }

    private static void displayBag(BagInterface<String> aBag) {
        System.out.println("The bag contains the following string(s):");
        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++) {
            System.out.println(bagArray[index] + " ");
        }
        System.out.println();
    }
}
