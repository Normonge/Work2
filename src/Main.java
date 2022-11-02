import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        Repository repo = new Repository();
        ArrayList<Music> musicArrayList = repo.createMusicArrayList();

        Tree<Integer> avlTree = new AVLTree<>();
        musicArrayList.forEach(music -> avlTree.insert(music.getName()));

        avlTree.traversePreOrder();
        avlTree.count();
        System.out.println(avlTree.count() + " nodes in tree");

        System.out.println("Max is: " + avlTree.getMax());
        System.out.println("Min is: " + avlTree.getMin());

//        System.out.println("Deleting 42 from Tree");
//        avlTree.delete(42);

    //   System.out.println("New Max is: " + avlTree.getMax());


    }
    }
