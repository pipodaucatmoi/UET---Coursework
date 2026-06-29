package bai84;

import java.util.ArrayList;
import java.util.List;

public class ParkingCustomer {
    private final String name;
    private final List<ParkingTicket> tickets = new ArrayList<>();

    public ParkingCustomer(String name) {
        this.name = name;
    }

    public void addTicket(ParkingTicket ticket) {
        tickets.add(ticket);
    }

    private double getTotalFee() {
        double total = 0;
        for (ParkingTicket ticket : tickets) {
            total += ticket.getFee();
        }
        return total;
    }

    private int getTotalBonusPoints() {
        int total = 0;
        for (ParkingTicket ticket : tickets) {
            total += ticket.getBonusPoints();
        }
        return total;
    }

    // Hàm receipt() cực kỳ trong sáng, chỉ chuyên lo ghép chuỗi
    public String receipt() {
        StringBuilder result = new StringBuilder("Parking Receipt for " + name + "\n");

        for (ParkingTicket ticket : tickets) {
            result.append("\t").append(ticket.getVehicle().getPlate())
                    .append("\t").append(ticket.getFee()).append("\n");
        }

        result.append("Total fee is ").append(getTotalFee()).append("\n");
        result.append("You earned ").append(getTotalBonusPoints()).append(" bonus points");
        return result.toString();
    }
}
