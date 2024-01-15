public class BagDemo {
    public static void main(String[] args) {
        ShoppingCart<String> shoppingCart = new ShoppingCart<>();
        
        testAdd(shoppingCart, "bread");
        testAdd(shoppingCart, "milk");
        testAdd(shoppingCart, "water");
        testAdd(shoppingCart, "eggs");
        testAdd(shoppingCart, "lunchmeat");
        testAdd(shoppingCart, "cheese");

        System.out.println();

        displayBag(shoppingCart);
    }

    public static void testAdd(ShoppingCart<String> bag, String item) {
        if (bag.add(item)) {
            System.out.println(item + ": Added");
        } else {
            System.out.println(item + ": Not able to add");
        }
    }

    public static void displayBag(ShoppingCart<String> bag) {
        System.out.println("Items in bag: ");
        Object[] bagArray = bag.toArray();
        for (Object item : bagArray) {
            System.out.println(item);
        }
    }
}


