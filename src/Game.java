import WebServer.*;
import GameObjects.*;
import java.io.IOException;

public class Game
{

    public static void main(String[] args) throws IOException
    {
        Player player1, player2;
        player1 = new ComputerPlayer();


        int port = 8080;

        WebServer server = new WebServer();
        server.Start(port);
    }

    public static void InitializeGame()
    {

    }
}
