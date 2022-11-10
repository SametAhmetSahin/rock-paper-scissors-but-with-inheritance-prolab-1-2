package WebServer;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WebServer
{
    public void Start(int port) throws IOException
    {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("server started at " + port);

        server.createContext("/", new RootHandler());
        server.createContext("/get", new GetHandler());
        server.createContext("/post", new PostHandler());
        /*
        server.createContext("/echoHeader", new EchoHeaderHandler());
        server.createContext("/echoPost", new EchoPostHandler());
         */

        server.setExecutor(null);
        server.start();
    }
}

