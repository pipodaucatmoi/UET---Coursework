import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {
    private static final AtomicInteger nextClientId = new AtomicInteger(1);
    private static final Map<Integer, String> clients = new ConcurrentHashMap<>();
    private static final Map<String, List<String>> rooms = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(2511), 0);

            server.createContext("/join", Server::handleJoin);
            server.createContext("/submit", Server::handleSubmit);
            server.createContext("/messages", Server::handleMessages);

            server.setExecutor(null);
            server.start();

            System.out.println("REST Chat Server is running on http://localhost:2511");
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    private static void handleJoin(HttpExchange exchange) {
        try {
            Map<String, String> query = parseQuery(exchange.getRequestURI().getQuery());
            String room = query.getOrDefault("room", "default");

            int clientId = nextClientId.getAndIncrement();
            clients.put(clientId, room);
            rooms.putIfAbsent(room, Collections.synchronizedList(new ArrayList<>()));

            send(exchange, 200, String.valueOf(clientId));
        } catch (Exception e) {
            send(exchange, 500, "Server error");
        }
    }

    private static void handleSubmit(HttpExchange exchange) {
        try {
            Map<String, String> query = parseQuery(exchange.getRequestURI().getQuery());

            String room = query.get("room");
            int clientId = Integer.parseInt(query.get("clientId"));
            String message = query.get("message");

            if (!clients.containsKey(clientId)) {
                send(exchange, 400, "Invalid client ID");
                return;
            }

            if (!clients.get(clientId).equals(room)) {
                send(exchange, 400, "Client is not in this room");
                return;
            }

            rooms.putIfAbsent(room, Collections.synchronizedList(new ArrayList<>()));
            rooms.get(room).add("Client " + clientId + ": " + message);

            send(exchange, 200, "Message submitted");
        } catch (Exception e) {
            send(exchange, 400, "Bad request");
        }
    }

    private static void handleMessages(HttpExchange exchange) {
        try {
            Map<String, String> query = parseQuery(exchange.getRequestURI().getQuery());
            String room = query.getOrDefault("room", "default");

            List<String> messages = rooms.getOrDefault(room, new ArrayList<>());
            send(exchange, 200, String.join("\n", messages));
        } catch (Exception e) {
            send(exchange, 500, "Server error");
        }
    }

    private static Map<String, String> parseQuery(String query) {
        Map<String, String> result = new HashMap<>();

        if (query == null || query.isEmpty()) {
            return result;
        }

        String[] pairs = query.split("&");

        for (String pair : pairs) {
            String[] parts = pair.split("=", 2);
            String key = decode(parts[0]);
            String value = parts.length > 1 ? decode(parts[1]) : "";
            result.put(key, value);
        }

        return result;
    }

    private static String decode(String text) {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    private static void send(HttpExchange exchange, int statusCode, String response) {
        try {
            byte[] data = response.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(statusCode, data.length);

            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(data);
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Response error: " + e.getMessage());
        }
    }
}