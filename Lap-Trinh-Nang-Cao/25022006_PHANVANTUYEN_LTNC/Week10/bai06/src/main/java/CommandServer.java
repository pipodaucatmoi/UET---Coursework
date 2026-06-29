import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class CommandServer {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(2511);
            System.out.println("CommandServer is running on port " + port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();

                    BufferedReader input = new BufferedReader(
                            new InputStreamReader(socket.getInputStream())
                    );

                    PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                    String command = input.readLine();
                    System.out.println("Received command: " + command);

                    if ("START".equalsIgnoreCase(command)) {
                        output.println("System initialized...");
                    } else if ("SHUTDOWN".equalsIgnoreCase(command)) {
                        output.println("System shutdown...");
                    } else {
                        output.println("Unknown command");
                    }

                    socket.close();
                } catch (SocketTimeoutException e) {
                    System.out.println("No client connected within 5 seconds");
                }
            }
        } catch (BindException e) {
            System.out.println("Error: Port " + port + " is already in use");
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}