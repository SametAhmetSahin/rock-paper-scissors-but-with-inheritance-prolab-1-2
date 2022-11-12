import WebServer.*;
import GameObjects.*;
import java.io.IOException;
import java.util.Random;

public class Game
{
    static Player player1, player2;
    static Player.DeckItem deck1, deck2;
    static long maxRound = 10;
    static boolean isHumanGame;
    static Random rng = new Random();

    public static void main(String[] args) throws IOException
    {
        int port = 8080;

        WebServer server = new WebServer();
        server.Start(port);
    }

    public static void InitializeGame(boolean isHuman)
    {
        isHumanGame = isHuman;

        if(isHumanGame)
            InitializeHumanAiGame();
        else
            InitializeAiAiGame();
    }

    public static void InitializeHumanAiGame()
    {
        player1 = new HumanPlayer(rng.nextLong(), "Sen");
        player2 = new ComputerPlayer(rng.nextLong(), "Bilgisayar");
    }

    public static void InitializeAiAiGame()
    {
        player1 = new ComputerPlayer(rng.nextLong(), "Bilgisayar 1");
        player2 = new ComputerPlayer(rng.nextLong(), "Bilgisayar 2");
    }

    public static void PlayARound()
    {
        int humanSelection = -1;

        if(isHumanGame)
            humanSelection = GetHumanSelection();

        deck1 = player1.SelectItem(humanSelection);
        deck2 = player2.SelectItem(humanSelection);


    }
}
