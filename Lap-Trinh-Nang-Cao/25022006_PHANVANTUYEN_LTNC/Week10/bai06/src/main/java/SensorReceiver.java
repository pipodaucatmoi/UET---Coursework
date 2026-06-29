import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SensorReceiver {
    public static void main(String[] args) {
        int port = 2511;

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("SensorReceiver is listening on port " + port);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String data = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received sensor data: " + data);
            }
        } catch (Exception e) {
            System.out.println("Receiver error: " + e.getMessage());
        }
    }
}