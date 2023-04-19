import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Playlist {
    private ArrayList<Song> songs;
    private ArrayList<String> allowedSongs;

    public ArrayList<Song> getSongs()   {
        return songs;
    }
    

    public Playlist()   {
        songs = new ArrayList<>();
        allowedSongs = new ArrayList<>();
        readAllowedSongsFromFile("songs.txt");
    }

    //add songs to the playlist
    public void addSong(Song song)  {
        if (allowedSongs.contains(song.getTitle())) {
            songs.add(song);
            System.out.println(song.getTitle() + " added to playlist");
        }
        else{
            System.out.println(song.getTitle() + " is not allowed in this playlist");
        }
    }

    //remove songs to the playlist
    public void removeSong(int index)   {
        if (index >=0 && index < songs.size())  {
            songs.remove(index);
        }
        else    {
            System.out.println("Invalid song");
        }
    }

    public Song getSong(int index)  {
        if (index >= 0 && index < songs.size())  {
            return songs.get(index);
        }
        else{
            System.out.println("Invalid song");
            return null;
        }
    }

    private void readAllowedSongsFromFile(String filename)  {
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))  {
            String line;
            while ((line = br.readLine()) != null)  {
                allowedSongs.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading " + filename + ": " + e.getMessage());
        }
    }
    
}
