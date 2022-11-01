public class Details {
    String artist;
    String genre;
    String year;
    String bpm;
    String nrgy;
    String dnce;

    public Details(String artist, String genre, String year, String bpm, String nrgy, String dnce) {
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
}
