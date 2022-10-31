import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Repository {
    //read top10s_1.csv

    public void readFile(){
        try{
            File file = new File("top10s_1.csv");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] values = line.split(",");
                System.out.println(values[0]);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
