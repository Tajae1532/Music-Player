import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        // Add some songs to the player
        player.addSong(new Song("Really Really", "Kevin Gates"));
        player.addSong(new Song("Thug Cry", "YoungBoy"));
        player.addSong(new Song("My Side", "Lil Durk"));
        player.addSong(new Song("Timing", "YK Osiris"));

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
            } else if (input.equalsIgnoreCase("next")) {
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
