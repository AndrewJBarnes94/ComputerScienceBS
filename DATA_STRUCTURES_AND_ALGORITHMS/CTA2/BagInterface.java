public interface BagInterface<T> {
    boolean add(T newEntry);
    T[] toArray();
    boolean isFull();
}