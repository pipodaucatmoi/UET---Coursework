import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server {
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    public static void main(String[] args) {
        int port = 2511;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("Server is running on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                logger.info("Client connected: " + clientSocket.getInetAddress());

                Thread clientThread = new Thread(() -> handleClient(clientSocket));
                clientThread.start();
            }
        } catch (Exception e) {
            logger.severe("Server error: " + e.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String message;

            while ((message = input.readLine()) != null) {
                logger.info("Tin nhắn từ " + clientSocket.getInetAddress() + ": " + message);
                output.println("Server echo: " + message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }
        } catch (Exception e) {
            logger.warning("Client error: " + e.getMessage());
        } finally {
            try {
                logger.info("Client disconnected: " + clientSocket.getInetAddress());
                clientSocket.close();
            } catch (Exception e) {
                logger.warning("Close socket error: " + e.getMessage());
            }
        }
    }
}