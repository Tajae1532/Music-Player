import java.util.ArrayList;
import java.util.List;

public class Album {
    
    private String title;
    private String artist;
    private int year;
    private List<Song> songs;

    public Album(String title, String artist, int year) {
        this.title = title;
        this.artist =artist;
        this.year = year;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song)  {
        songs.add(song);
    }

    public void printAlbumDetails() {
        System.out.println("Album: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Year: " + year);
        System.out.println("Track List:");
        for (int i = 0; i < songs.size(); i++)  {
            System.out.println((i+1) + ". " + songs.get(i).getTitle() + " - " + songs.get(i).getDuration() + " seconds");
        }
    }

    private int getTotalDuration()  {
        int total = 0 for (Song song : songs)   {
            total += song.getDuration();
        }
        return total;
    }

    
}
