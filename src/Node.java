public class  Node<T extends Comparable<T>> {

    private T name;
    private Details details;
    private int height = 1;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T name, Details details) {
        this.name = name;
        this.details = details;
    }



    public T getName() {
        return name;
    }

    //returnAllDetails
    public String getDetails() {
        return details.returnAllDetails();
    }

    public String getSearchResult() {
        return name.toString() + " is a song by " + details.artist + ". it is a " + details.genre + " song that was popular in " + details.year + ".";
    }

    public void setName(T name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }//
}