import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Repository repo = new Repository();
        ArrayList<Music> musicArrayList = repo.createMusicArrayList();

        AVLInterface<Integer> avlAVLInterface = new AVLAVLInterface<>();
        //make key value pair
        Map<String, Details> musicMap = new TreeMap<>();
        for (Music music : musicArrayList) {
            musicMap.put(music.getName(), music.getDetails());
        }
        //insert into avl tree
        for (Map.Entry<String, Details> entry : musicMap.entrySet()) {
            avlAVLInterface.add(entry);
        }

        avlAVLInterface.traversePreOrder();

        avlAVLInterface.count();
        System.out.println(avlAVLInterface.count() + " nodes in tree");

        avlAVLInterface.find("Never Be the Same - Radio Edit");
    }
}
