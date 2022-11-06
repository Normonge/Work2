import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Repository {
    //read top10s_1.csv

    public ArrayList<Music> createMusicArrayList() throws IOException {
        StringBuilder fileContents = new StringBuilder();
        File file = new File("top10s_1.csv");
        ArrayList<Music> musicArrayList = new ArrayList<Music>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            String line;
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                //print title only

                //create music object
                Details details = new Details(
                        line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")[2],
                        line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")[3],
                        line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")[4],
                        line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")[5],
                        line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")[6],
                        line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")[7]
                );
                String title = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")[1];
                musicArrayList.add(new Music(title, details));
            }

        }

        return musicArrayList;
    }

}
