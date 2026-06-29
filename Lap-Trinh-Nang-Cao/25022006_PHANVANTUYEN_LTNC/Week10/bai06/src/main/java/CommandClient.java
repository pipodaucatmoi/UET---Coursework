import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

public class CommandClient {
    public static void main(String[] args) {
        sendCommand("START");
        sendCommand("SHUTDOWN");
    }

    private static void sendCommand(String command) {
        try (
                Socket socket = new Socket("localhost", 2511);
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true)
        ) {
            output.println(command);
            String response = input.readLine();
            System.out.println("Command: " + command);
            System.out.println("Response: " + response);
        } catch (ConnectException e) {
            System.out.println("Error: Remote server is offline");
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}