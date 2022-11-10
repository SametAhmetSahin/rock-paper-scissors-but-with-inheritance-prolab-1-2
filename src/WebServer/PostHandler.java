package WebServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static WebServer.RootHandler.parseQuery;

public class PostHandler implements HttpHandler
{
    @Override
    public void handle(HttpExchange he) throws IOException
    {
        // parse request
        InputStreamReader isr = new InputStreamReader(he.getRequestBody(), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String query = br.readLine();
        //HashMap<String, String> queryData = parseQuery(query);

        System.out.println("query: " + query);

        String jsonDebug = "{\"balance\": 1000.21, \"num\":100, \"is_vip\":true, \"name\":\"foo\"}";

        JSONObject jo;
        try {
            //jo = (JSONObject) new JSONParser().parse(query);
            jo = (JSONObject) new JSONParser().parse(jsonDebug);


        } catch (ParseException e) {
            System.out.println("Parse failed");
            throw new RuntimeException(e);
        }

        // send response
        String response;
        response = jo.toString();
        System.out.println("response:" + response);
        he.sendResponseHeaders(200, response.length());

        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
