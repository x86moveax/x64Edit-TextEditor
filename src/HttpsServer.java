import com.sun.net.httpserver.HttpServer;

import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HttpsServer {
    public static void HttpServer() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0); // создание хттп сервера с портом 8000
        server.createContext("/main", (exchange -> {
            String response0 = "Hello all!";
            String response1 = "Go use my texteditor!!";
            String response2 = "I see it";
            exchange.sendResponseHeaders(200, response0.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response0.getBytes());
            exchange.sendResponseHeaders(200, response1.getBytes().length);
            OutputStream os1 = exchange.getResponseBody();
            os.write(response1.getBytes());
            exchange.sendResponseHeaders(200, response2.getBytes().length);
            OutputStream os2 = exchange.getResponseBody();
            os.write(response2.getBytes());
            os.close();
            os1.close();
            os2.close();
        }));
        server.setExecutor(null);
        server.start();
        System.out.println("Server is running on port 8000");
    }
}
