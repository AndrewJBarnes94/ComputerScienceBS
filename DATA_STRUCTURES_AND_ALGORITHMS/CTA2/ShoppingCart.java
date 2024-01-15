public class ShoppingCart<MyType> implements BagInterface<MyType> {
    private MyType[] bag;
    private int numberOfProducts;
    private final int DEFAULT_CAPACITY = 5;
    
    public ShoppingCart() {
        @SuppressWarnings("unchecked")
        MyType[] tempBag = (MyType[])new Object[DEFAULT_CAPACITY];
        bag = tempBag;
        numberOfProducts = 0;
    }

    public boolean add(MyType newEntry) {
        if (isFull()) {
            return false;
        }
        bag[numberOfProducts] = newEntry;
        numberOfProducts++;
        return true;
    }
    
    public MyType[] toArray() {
        @SuppressWarnings("unchecked")
        MyType[] result = (MyType[])new Object[numberOfProducts];
        for (int index = 0; index < numberOfProducts; index++) {
            result[index] = bag[index];
        }
        return result;
    }

    public boolean isFull() {
        return numberOfProducts >= bag.length;
    }
}
