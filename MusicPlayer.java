import java.util.ArrayList;

public class MusicPlayer {
    private ArrayList<Song> songs;

    public MusicPlayer() {
        songs = new ArrayList<Song>(); //initialize the list of songs
    }

    public void searchMusic(String searchTerm) {
        //search for a song by title or artist 
        ArrayList<Song> results = new ArrayList<Song>();
        for (Song song : songs) {
            if (song.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                song.getArtist().toLowerCase().contains(searchTerm.toLowerCase())) {
            results.add(song);
            }
        }

        //Display search results
        if (results.size() > 0) {
            System.out.println("Search results: ");
            for (Song song : results) {
                System.out.println(song.getTitle() + " by " + song.getArtist());
            }
        } else {
            System.out.println("No results found for \"" + searchTerm + "\"");
        }
    }

    //Other methods
}

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}