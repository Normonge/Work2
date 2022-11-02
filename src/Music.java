import java.util.ArrayList;

public class Music implements Comparable<Music> {
    String name;
    Details details;

    public Music(String name, Details details) {
        this.name = name;
        this.details = details;
    }

    public Details getDetails() {
        return details;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Music o) {
        return 0;
    }
}
