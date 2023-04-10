import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        // Add some songs to the player
        player.addSong(new Song("Bohemian Rhapsody", "Queen"));
        player.addSong(new Song("Stairway to Heaven", "Led Zeppelin"));
        player.addSong(new Song("Imagine", "John Lennon"));
        player.addSong(new Song("Hotel California", "Eagles"));

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
            } else if (input.equalsIgnoreCase("exit")) {
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
