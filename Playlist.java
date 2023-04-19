import java.util.ArrayList;

public class Playlist {
    private ArrayList<Song> songs;

    public ArrayList<Song> getSongs()   {
        return songs;
    }
    

    public Playlist()   {
        songs = new ArrayList<>();
    }

    //add songs to the playlist
    public void addSong(Song song)  {
        songs.add(song);
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
    
}
