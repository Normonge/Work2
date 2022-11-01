import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        Repository repo = new Repository();
        ArrayList<Music> musicArrayList = repo.createMusicArrayList();
        musicArrayList.forEach(music -> System.out.println(music.getName()  + " " + music.getDetails()));

    }



}