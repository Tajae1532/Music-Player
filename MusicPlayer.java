import java.util.ArrayList;
import java.util.HashMap;

public class MusicPlayer {
    private ArrayList<Song> songs;
    private int currentSongIndex;
    private boolean repeat;
    private Playlist playlist;
    private HashMap<String, Lyric> lyrics;

    public MusicPlayer() {
        // Constructor for MusicPlayer, initializes the list of songs
        songs = new ArrayList<Song>();
        currentSongIndex = 0;
        repeat = false;
        playlist = new Playlist();
        lyrics = new HashMap<String, Lyric>();
        loadLyrics();
    }
    

    public void loadLyrics()    {
        try {
            Lyric firstDayOut = new Lyric("First Day Out", "lyrics/firstdayout.txt");
            lyrics.put(firstDayOut.getTitle(), firstDayOut);
        } catch (Exception e)   {
            System.err.println("Error loading they lyrics" + e.getMessage());
        }
    };

    public void printLyrics(String songTitle)   {
        Lyric songLyrics = lyrics.get(songTitle);
        if (songLyrics != null) {
            System.out.println("Lyrics for " + songLyrics.getTitle() + ": ");
            songLyrics.printLyrics();
        } else{
            System.out.println("Lyrics not found for song: " + songTitle);
        }
    }


    public void addSong(Song song) {
        // Add a new song to the list
        songs.add(song);
    }

    public void addToPlaylist(Song song)    {
        // Add a song to the playlist
        songs.add(song);
    }

    public void playPlaylist()  {
        // Play the songs in the playlist
        for (Song song : playlist.getSongs())   {
            System.out.println("Now playing: " + song.getTitle() + " by " + song.getArtist());
        }
    }

    public void searchMusic(String searchTerm) {
        // Search for a song by title or artist
        ArrayList<Song> results = new ArrayList<Song>();
        for (Song song : songs) {
            if (song.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    song.getArtist().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(song);
            }
        }

        // Display search results
        if (results.size() > 0) {
            System.out.println("Search results:");
            for (Song song : results) {
                System.out.println(song.getTitle() + " by " + song.getArtist());
            }
        } else {
            System.out.println("No results found for \"" + searchTerm + "\"");
        }
    }

    public void nextSong() {
        if (songs.isEmpty()) {
            System.out.println("No songs in the player.");
            return;
        }

        currentSongIndex = (currentSongIndex + 1) % songs.size();
        Song currentSong = songs.get(currentSongIndex);
        System.out.println("Now playing: " + currentSong.getTitle() + " by " + currentSong.getArtist());
    }

    public void listSongs() {
        if (songs.isEmpty()) {
            System.out.println("No songs in the player.");
            return;
        }

        System.out.println("List of songs: ");
        for (Song song : songs) {
            System.out.println(song.getTitle() + " by " + song.getArtist());
        }
    }

    public void previousSong() {
        if (songs.isEmpty()) {
            System.out.println("No songs in the player.");
            return;
        }

        currentSongIndex = (currentSongIndex - 1 + songs.size()) % songs.size();
        Song currentSong = songs.get(currentSongIndex);
        System.out.println("Now playing: " + currentSong.getTitle() + " by " + currentSong.getArtist());
    }

    public void toggleRepeat() {
        repeat = !repeat;
        System.out.println("Repeat is now " + (repeat ? "on" : "off") + ".");
    }
}

