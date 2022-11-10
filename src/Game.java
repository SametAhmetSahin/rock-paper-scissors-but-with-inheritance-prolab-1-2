import WebServer.*;
import GameObjects.*;
import java.io.IOException;

public class Game
{
    public static void main(String[] args) throws IOException
    {
        int port = 8080;

        WebServer server = new WebServer();
        server.Start(port);
    }
}
