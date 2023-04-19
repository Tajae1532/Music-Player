import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lyric {
    private String title;
    private String lyrics;

    public Lyric(String title, String lyricFilePath)   {
        this.title = title;
        this.lyrics = readLyricsFromFile(lyricFilePath);
    }

    public String getTitle()    {
        return this.title;
    }

    public void printLyrics()   {
        System.out.println("Lyrics for " + title + ": ");
        System.out.println(lyrics);
    }

    private String readLyricsFromFile(String lyricFilePath)   {
        StringBuilder lyricsBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(lyricFilePath))) {
            String line;
            while ((line = br.readLine()) != null)  {
                lyricsBuilder.append(line);
                lyricsBuilder.append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading the lyrics: " + e.getMessage());
        }
        return lyricsBuilder.toString();
    }
}
