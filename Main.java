import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        //Loading song from songs.txt
        try (BufferedReader br = new BufferedReader(new FileReader("songs.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] songData = line.split(",");
                if (songData.length == 2) {
                    player.addSong(new Song(songData[0].trim(), songData[1].trim()));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the songs.txt file: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Prompt the user for a command
            System.out.print("Enter a command: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("search")) {
                // Search for a song by title or artist
                System.out.print("Enter a search term: ");
                String searchTerm = scanner.nextLine();
                player.searchMusic(searchTerm);
            } 
            else if (input.equalsIgnoreCase("repeat")) {
                player.toggleRepeat();
            }
            else if (input.equalsIgnoreCase("next")) {
                player.nextSong();
            } else if (input.equalsIgnoreCase("previous")) {
                player.previousSong();
            }             
            else if (input.equalsIgnoreCase("exit")) {
                // Exit the program
                System.out.println("Goodbye!");
                break;
            } else {
                // Invalid command
                System.out.println("Invalid command. Try again.");
            }
        }
    }
}
