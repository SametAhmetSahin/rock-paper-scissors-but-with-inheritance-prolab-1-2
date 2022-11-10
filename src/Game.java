import WebServer.*;
import GameObjects.*;
import java.io.IOException;

public class Game
{
    static GameObject player1, player2;

    public static void main(String[] args) throws IOException
    {
        int port = 8080;

        WebServer server = new WebServer();
        server.Start(port);
    }

    public static void InitializeGame()
    {

    }
}
