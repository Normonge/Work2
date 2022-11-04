import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Repository repo = new Repository();
        ArrayList<Music> musicArrayList = repo.createMusicArrayList();

        Tree<Integer> avlTree = new AVLTree<>();
        //make key value pair
        Map<String, Details> musicMap = new TreeMap<>();
        for (Music music : musicArrayList) {
            musicMap.put(music.getName(), music.getDetails());
        }
        //insert into avl tree
        for (Map.Entry<String, Details> entry : musicMap.entrySet()) {
            avlTree.add(entry);
        }

        avlTree.traversePreOrder();

        avlTree.count();
        System.out.println(avlTree.count() + " nodes in tree");


        avlTree.find("Never Be the Same - Radio Edit");
    }
}
