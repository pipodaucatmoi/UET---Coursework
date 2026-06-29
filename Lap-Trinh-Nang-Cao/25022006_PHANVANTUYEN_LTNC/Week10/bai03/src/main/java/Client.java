import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    private static final String BASE_URL = "http://localhost:2511";

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            HttpClient client = HttpClient.newHttpClient();

            System.out.print("Enter room name: ");
            String room = scanner.nextLine();

            String clientId = joinRoom(client, room);
            System.out.println("Joined room '" + room + "' with client ID: " + clientId);

            while (true) {
                System.out.print("Enter message: ");
                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                submitMessage(client, room, clientId, message);
                showMessages(client, room);
            }
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }

    private static String joinRoom(HttpClient client, String room) throws Exception {
        String url = BASE_URL + "/join?room=" + encode(room);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }

    private static void submitMessage(HttpClient client, String room, String clientId, String message) throws Exception {
        String url = BASE_URL
                + "/submit?room=" + encode(room)
                + "&clientId=" + encode(clientId)
                + "&message=" + encode(message);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static void showMessages(HttpClient client, String room) throws Exception {
        String url = BASE_URL + "/messages?room=" + encode(room);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

        System.out.println("Messages in room:");
        System.out.println(response);
    }

    private static String encode(String text) {
        return URLEncoder.encode(text, StandardCharsets.UTF_8);
    }
}