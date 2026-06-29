import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 2511;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server đang chạy ở cổng: " + port);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );

            PrintWriter output = new PrintWriter(
                    clientSocket.getOutputStream(), true
            );

            String message;

            while ((message = input.readLine()) != null) {
                System.out.println("Client: " + message);
                output.println("Server echo: " + message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            clientSocket.close();
            System.out.println("Server stopped");
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}