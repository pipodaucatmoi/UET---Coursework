import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 2511;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to server");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true
            );

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter message: ");
                String message = scanner.nextLine();

                output.println(message);

                String response = input.readLine();
                System.out.println(response);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}