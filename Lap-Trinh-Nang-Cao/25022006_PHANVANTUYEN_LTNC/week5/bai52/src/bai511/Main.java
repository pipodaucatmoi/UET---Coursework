package bai511;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Queue<Ticket> customerQueue = new LinkedList<>();
        Stack<Message> messageHistory = new Stack<>();

        Customer khachA = new Customer("C01", "Khách A");
        Ticket ticketA = new Ticket("T01", "Hàng bị lỗi móp méo", new Date().toString());
        ticketA.setCustomer(khachA);
        customerQueue.offer(ticketA);
        System.out.println(khachA.getName() + " đến và gửi yêu cầu.");

        Customer khachB = new Customer("C02", "Khách B");
        Ticket ticketB = new Ticket("T02", "Hỏi thời gian giao hàng", new Date().toString());
        ticketB.setCustomer(khachB);
        customerQueue.offer(ticketB);
        System.out.println(khachB.getName() + " đến và gửi yêu cầu.");

        Ticket currentTicket = customerQueue.poll();
        System.out.println(">>> Đang xử lý cho: " + currentTicket.getCustomer().getName() + " | Vấn đề: " + currentTicket.content);

        messageHistory.push(new Message("M1", "Chào Khách A, Tiki có thể giúp gì ạ?"));
        System.out.println("Nhân viên gõ: " + messageHistory.peek());

        messageHistory.push(new Message("M2", "Bạn vui lòng chụp ảnh sản phẩm lỗi nhé."));
        System.out.println("Nhân viên gõ: " + messageHistory.peek());

        messageHistory.push(new Message("M3", "À nhầm, sản phẩm này không được đổi trả."));
        System.out.println("Nhân viên gõ: " + messageHistory.peek());

        Message undoneMsg = messageHistory.pop();
        System.out.println("Đã thu hồi tin nhắn: " + undoneMsg);
        System.out.println("Tin nhắn cuối cùng còn lại trên màn hình: " + messageHistory.peek());
        messageHistory.clear();

        Ticket nextTicket = customerQueue.poll(); // Lấy người tiếp theo
        System.out.println(">>> Đang xử lý cho: " + nextTicket.getCustomer().getName() + " | Vấn đề: " + nextTicket.content);

        messageHistory.push(new Message("M4", "Chào Khách B, đơn của bạn dự kiến giao ngày mai."));
        System.out.println("Nhân viên gõ: " + messageHistory.peek());
    }
}