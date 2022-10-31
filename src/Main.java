public class Main {
    public static void main(String[] args) {
        Main ex1 = new Main();
        ex1.go();
        Repository repo = new Repository();
        repo.readFile();
    }

   NMAVLTree tree;

    public Main(){
        tree = new NMAVLTree();
    }
    public void go(){
        System.out.println("Here we go!");

        add(30);
        add(20);
        add(10);
    }

    public void add(int n){
        tree.add(n);
    }
}