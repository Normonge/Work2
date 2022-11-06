import java.io.IOException;
import java.util.*;

public class AVLTree<T extends Comparable<T>> implements AVLInterface<T> {

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
        return "My name is " + "Norman Marroquin-MONGE";
    }

    @Override
    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.getLeftChild());
            System.out.println(node.getName().toString() + " " + node.getDetails());
            if (node.getLeftChild() != null) {
                System.out.println("Left Child:{ " + node.getLeftChild().getName().toString() + " } ");
            } else {
                System.out.println("Left Child:{ null } ");
            }
            if (node.getRightChild() != null) {
                System.out.println("Right Child:{ " + node.getRightChild().getName().toString() + " } ");
            } else {
                System.out.println("Right Child:{ null } ");
            }

            System.out.println("--------------------------------------------------");
            traverseInOrder(node.getRightChild());
        }
    }

    private void traversePostOrder(Node<T> node) {
        if (node != null) {
            traversePostOrder(node.getLeftChild());
            traversePostOrder(node.getRightChild());
            System.out.println(node.getName().toString() + " " + node.getDetails());
            if (node.getLeftChild() != null) {
                System.out.println("Left Child:{ " + node.getLeftChild().getName().toString() + " } ");
            } else {
                System.out.println("Left Child:{ null } ");
            }
            if (node.getRightChild() != null) {
                System.out.println("Right Child:{ " + node.getRightChild().getName().toString() + " } ");
            } else {
                System.out.println("Right Child:{ null } ");
            }

            System.out.println("--------------------------------------------------");
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
    public void go() throws IOException {
        Repository repo = new Repository();
        ArrayList<Music> musicArrayList = repo.createMusicArrayList();


        //make key value pair
        Map<String, Details> musicMap = new TreeMap<>();
        for (Music music : musicArrayList) {
            musicMap.put(music.getName(), music.getDetails());
        }
        //insert into avl tree
        for (Map.Entry<String, Details> entry : musicMap.entrySet()) {
            this.add(entry);
        }

        findOption();
    }

    public void giveOption() {
        System.out.println("Choose an option: ");
        System.out.println("\t 1. Find a song");
        System.out.println("\t 2. Add a song");
        System.out.println("\t 3. Count the number of nodes");
        System.out.println("\t 4. Traverse the tree in inorder");
        System.out.println("\t 5. Traverse the tree in preorder");
        System.out.println("\t 6. Traverse the tree in postorder");
        System.out.println("\t 7. Greeting");
        System.out.println("\t 8. Help");
        System.out.println("\t 9. Exit");
    }

    public void findOption() {
        giveOption();
        Scanner enter = new Scanner(System.in);
        int chosen = enter.nextInt();


        if (chosen == 1) {
            System.out.println("Enter the name of the song: ");
            Scanner enterName = new Scanner(System.in);
            String name = enterName.nextLine();

            //ignor case
            this.find(name.toLowerCase());
        } else if (chosen == 2) {
            System.out.println("Enter the name of the song: ");
            Scanner enterName = new Scanner(System.in);
            String name = enterName.nextLine();

            System.out.println("Enter the artist of the song: ");
            Scanner enterDetails = new Scanner(System.in);
            String artist = enterDetails.nextLine();

            System.out.println("Enter the genre of the song: ");
            Scanner enterGenre = new Scanner(System.in);
            String genre = enterGenre.nextLine();

            System.out.println("Enter the year of the song: ");
            Scanner enterYear = new Scanner(System.in);
            String year = enterYear.nextLine();

            System.out.println("Enter the bpm of the song: ");
            Scanner enterBPM = new Scanner(System.in);
            String bpm = enterBPM.nextLine();

            System.out.println("Enter the nrgy of the song: ");
            Scanner enterNrgy = new Scanner(System.in);
            String nrgy = enterNrgy.nextLine();

            System.out.println("Enter the dnce of the song: ");
            Scanner enterDnce = new Scanner(System.in);
            String dnce = enterDnce.nextLine();

            Details details = new Details(artist, genre, year, bpm, nrgy, dnce);
            Map<String, Details> musicMap = new TreeMap<>();
            musicMap.put(name, details);
            Map.Entry<String, Details> entry = musicMap.entrySet().iterator().next();
            this.add(entry);


        } else if (chosen == 3) {
            System.out.println("The number of nodes is: " + this.count());
        } else if (chosen == 4) {
            System.out.println("Inorder traversal: ");
            this.traverseInOrder();
        } else if (chosen == 5) {
            System.out.println("Preorder traversal: ");
            this.traversePreOrder();
        } else if (chosen == 6) {
            System.out.println("Postorder traversal: ");
            this.traversePostOrder();
        } else if (chosen == 7) {
            greeting();
        } else if (chosen == 8) {
            System.out.println("1. Find a song: Enter the name of the song and the program will return the details of the song");
            System.out.println("2. Add a song: Enter the name of the song, the artist, the genre, the year, the bpm, the nrgy and the dnce of the song and the program will add the song to the tree");
            System.out.println("3. Count the number of nodes: The program will return the number of nodes in the tree");
            System.out.println("4. Traverse the tree in inorder: The program will return the inorder traversal of the tree");
            System.out.println("5. Traverse the tree in preorder: The program will return the preorder traversal of the tree");
            System.out.println("6. Traverse the tree in postorder: The program will return the postorder traversal of the tree");
            System.out.println("7. Greeting: The program will return a greeting");
            System.out.println("8. Help: The program will return the help menu");
            System.out.println("9. Exit: The program will exit");
        } else if (chosen == 9) {
            System.out.println("Goodbye!");
            System.exit(0);
        } else {
            System.out.println("Invalid option. Please try again.");
            findOption();
        }
        findOption();
    }

    @Override
    public void find(String name) {
        find(name, root);
    }

    private void find(String name, Node<T> node) {
        if (node != null) {
            if (name.compareTo(node.getName().toString().toLowerCase(Locale.ROOT)) < 0) {
                find(name, node.getLeftChild());
            } else if (name.compareTo(node.getName().toString().toLowerCase(Locale.ROOT)) > 0) {
                find(name, node.getRightChild());
            } else {
                System.out.println(node.getSearchResult());
            }
        }
    }

    @Override
    public void greeting() {
        String name = getMyName();
        System.out.println("Hello, I am " + name + "." + "COSC-310" + "11/6/2022");
    }

    @Override
    public void help() {

    }

    @Override
    public void exit() {

    }
}