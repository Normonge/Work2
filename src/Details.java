public class Details implements Comparable<Details> {
    String artist;
    String genre;
    String year;
    String bpm;
    String nrgy;
    String dnce;

    public Details(String artist, String genre, String year, String bpm, String nrgy, String dnce) { //constructor
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.bpm = bpm;
        this.nrgy = nrgy;
        this.dnce = dnce;
    }

    public String returnAllDetails() {
        return artist + " " + genre + " " + year + " " + bpm + " " + nrgy + " " + dnce;
    }

    @Override
    public int compareTo(Details o) {
        return 0;
    }
}
