package bai36;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Food extends Product{
    protected LocalDate today = LocalDate.now();
    protected LocalDate hetHan;

    public Food(String name, double price, LocalDate hetHan, LocalDate today) {
        super(name, price);
        this.hetHan = hetHan;
        this.today = today;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNameProduct() {
        return "Food";
    }

    @Override
    public double getRealPrice() {
        long soNgay = ChronoUnit.DAYS.between(today, hetHan);
        if (soNgay < 7){
            return price * 0.8;
        } else {
            return price;
        }
    }

}
