package DATA_STRUCTURES_AND_ALGORITHMS.BookExamples;

public class ArrayBag<T> implements BagInterface<T> {
    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    private boolean integrityOK;
    private static final int MAX_CAPACITY = 1000;

    /** Creates an empty bag whose initial capacity is 25. */
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }
    
    /** Creates an empty bag having a given initial capacity
     * @param desiredCapacity The integer capacity desired.
     */
    public ArrayBag(int desiredCapacity) {
        integrityOK = false;
        if (desiredCapacity <= MAX_CAPACITY) {
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[])new Object[desiredCapacity];
            bag = tempBag;
            numberOfEntries = 0;
            integrityOK = true;
        } else {
            throw new IllegalStateException("Attemptto create a bag whose "
                                            + "capacity exceeds allowed maximum.");
        }
    }

    /** 
     * Gets the current number of entries in this bag.
     * @return The integer number of entries currently in the bag. 
     */
    public int getCurrentSize() {
        return numberOfEntries;
    }
    
    /**
     * Sees whether this bag iss empty.
     * @return True if the bag is empty, or false if not.
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Adds a new entry to this bag.
     * @param newEntry The object to be added as a new entry.
     * @return True fi the addition is successful, or false if not.
     */
    public boolean add(T newEntry) {
        checkIntegrity();
        boolean result = true;
        if (isArrayFull()) {
            result = false;
        } else {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     * @return Either the removed entry, if the removal was successful, or null
     */
    public String remove(){
        return null;
    }

    /**
     * Removes once occurrence of a given entry from this bag, if possible.
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public String remove(T anEntry){
        return null;
    }

    /**
     * Removes all entries from this bag.
     */
    public void clear(){
        
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the bag.
     */
    public int getFrequencyOf(T anEntry){
        return 0;
    }

    /**
     * Tests whether this bag contains a given entry.
     * @param anEntry The entry to find.
     * @return True if the bag contains anEntry, or false if not.
     */
    public boolean contains(T anEntry){
        return false;
    }

    /**
     * Retrieves all entries that are in this bag.
     * @return A newly allocated array of all the entries in the bag.
     */
    public T[] toArray() {
        checkIntegrity();
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = bag[index];
        }
        return result;
    }

    /**
     * @return True if the ArrayBag is full, or false if not.
     */
    public boolean isArrayFull() {
        return numberOfEntries >= bag.length;
    }

    private void checkIntegrity() {
        if (!integrityOK) {
            throw new SecurityException("ArrayBag is corrupt");
        }
    }

}
