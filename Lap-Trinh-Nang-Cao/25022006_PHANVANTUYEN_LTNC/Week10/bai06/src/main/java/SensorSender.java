import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SensorSender {
    public static void main(String[] args) {
        int port = 2511;

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName("localhost");

            for (int i = 1; i <= 5; i++) {
                String data = "Temp: " + (25 + i) + "C, Humidity: " + (60 + i) + "%";
                byte[] buffer = data.getBytes();

                DatagramPacket packet = new DatagramPacket(
                        buffer,
                        buffer.length,
                        address,
                        port
                );

                socket.send(packet);
                System.out.println("Sent: " + data);

                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Sender error: " + e.getMessage());
        }
    }
}