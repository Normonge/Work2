import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Repository {
    //read top10s_1.csv

    public void readTitleFile() throws IOException {
        StringBuilder fileContents = new StringBuilder();
        File file = new File("top10s_1.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                //print title only

                System.out.println(line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")[1]);
            }

        }


    }

}
