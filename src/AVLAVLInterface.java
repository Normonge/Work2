import java.util.Map;

public class AVLAVLInterface<T extends Comparable<T>> implements AVLInterface<T> {

    private Node<T> root;

    public AVLInterface<T> add(Map.Entry<String, Details> data) {
        root = insert((T) data.getKey(), (Details) data.getValue(), root);
        return this;
    }

    private Node<T> insert(T data, Details details, Node<T> node) {
        if (node == null) {
            return new Node<>(data, details);
        }
        if (data.compareTo(node.getName()) < 0) {
            node.setLeftChild(insert(data, details, node.getLeftChild()));
        } else if (data.compareTo(node.getName()) > 0) {
            node.setRightChild(insert(data, details, node.getRightChild()));
        } else {
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }

    @Override
    public void traverseInOrder() {
        traverseInOrder(root);
    }

    @Override
    public void traversePostOrder() {
        traversePostOrder(root);
    }


    @Override
    public String getMyName() {
        return null;
    }

    @Override
    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.getLeftChild());
            System.out.println(node.getName().toString());
            traverseInOrder(node.getRightChild());
        }
    }

    private void traversePostOrder(Node<T> node) {
        if (node != null) {
            traversePostOrder(node.getLeftChild());
            traversePostOrder(node.getRightChild());
            System.out.println(node.getName().toString());
        }
    }

    //preorder
    private void traversePreOrder(Node<T> node) {
        if (node != null) {
            System.out.println(node.getName().toString() + " " + node.getDetails());
            if (node.getLeftChild() != null) {
                System.out.println("Left Child:{ " + node.getLeftChild().getName().toString() + " } ");
            } else
                System.out.println("Left Child:{ null } ");

            if (node.getRightChild() != null) {
                System.out.println("Right Child:{ " + node.getRightChild().getName().toString() + " } ");
            } else
                System.out.println("Right Child:{ null } ");

            System.out.println("--------------------------------------------------");
            traversePreOrder(node.getLeftChild());
            traversePreOrder(node.getRightChild());
        }
    }


    public int count() {
        return count(root);
    }

    private int count(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return count(node.getLeftChild()) + 1 + count(node.getRightChild());
    }

    private Node<T> applyRotation(Node<T> node) {
        int balance = balance(node);
        if (balance > 1) {
            if (balance(node.getLeftChild()) < 0) {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (balance(node.getRightChild()) > 0) {
                node.setRightChild(rotateRight(node.getRightChild()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> leftNode = node.getLeftChild();
        Node<T> centerNode = leftNode.getRightChild();
        leftNode.setRightChild(node);
        node.setLeftChild(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rightNode = node.getRightChild();
        Node<T> centerNode = rightNode.getLeftChild();
        rightNode.setLeftChild(node);
        node.setRightChild(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private void updateHeight(Node<T> node) {
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
    }

    private int balance(Node<T> node) {
        return node != null ? height(node.getLeftChild()) - height(node.getRightChild()) : 0;
    }

    private int height(Node<T> node) {
        return node != null ? node.getHeight() : -1;
    }

    @Override
    public void go() {

    }

    @Override
    public void find(String name) {
        find(name, root);
    }

    private void find(String name, Node<T> node) {
        if (node != null) {
            if (name.compareTo(node.getName().toString()) < 0) {
                find(name, node.getLeftChild());
            } else if (name.compareTo(node.getName().toString()) > 0) {
                find(name, node.getRightChild());
            } else {
                System.out.println(node.getSearchResult());
            }
        }
    }

    @Override
    public void greeting() {

    }

    @Override
    public void help() {

    }

    @Override
    public void exit() {

    }
}