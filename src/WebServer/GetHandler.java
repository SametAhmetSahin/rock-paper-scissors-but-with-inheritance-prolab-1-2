package WebServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class GetHandler implements HttpHandler {

    @Override

    public void handle(HttpExchange he) throws IOException {
        // parse request
        URI requestedUri = he.getRequestURI();
        String query = requestedUri.getRawQuery();
        String[] QueryPairs = query.split("&");
        HashMap<String, String> QueryData = new HashMap<String, String>();
        for (String pair : QueryPairs) {
            QueryData.put(pair.split("=")[0], pair.split("=")[1]);
        }


        // send response
        String response = "";
        for (String key : QueryData.keySet())
            response += key + " = " + QueryData.get(key) + "\n";
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.toString().getBytes());

        os.close();

        System.out.println("query: " + query);
    }
}