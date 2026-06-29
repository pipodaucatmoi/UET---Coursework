package task49;

public class Main {
    static void main(String[] args) {
        Kho<Food> foodKho = new Kho<>();
        Food apple = new Food("F01", "Táo Mỹ", "30/10/2026");
        Food milk = new Food("F02", "Sữa tươi TH", "01/12/2026");

        foodKho.addKho(apple);
        foodKho.addKho(milk);
        foodKho.kiemKe();

        foodKho.removeKho(apple);
        foodKho.kiemKe();

        Kho<Electronic> electronicKho = new Kho<>();
        Electronic tv = new Electronic("E01", "Tivi Sony 4K", "24 Tháng");
        Electronic laptop = new Electronic("E02", "MacBook Pro", "12 Tháng");

        electronicKho.addKho(tv);
        electronicKho.addKho(laptop);
        electronicKho.kiemKe();

        electronicKho.removeKho(laptop);
        electronicKho.kiemKe();
    }
}
