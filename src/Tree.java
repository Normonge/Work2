public interface Tree<T extends Comparable<T>> {
    Tree<T> insert(String data);
    void delete(T data);
    void traverse();
    void traversePostOrder();
    int count();
    void traversePreOrder();
    T getMax();
    T getMin();
    boolean isEmpty();
}
