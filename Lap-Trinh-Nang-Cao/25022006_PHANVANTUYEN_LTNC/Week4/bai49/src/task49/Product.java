package task49;
import java.util.List;
import java.util.ArrayList;

public abstract class Product {
    public String id, name;
    public double price;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return this.name;
    }
    abstract String getInf();
}

class Food extends Product{
    public String hanSuDung;

    public Food(String id, String name, String hanSuDung) {
        super(id, name);
        this.hanSuDung = hanSuDung;
    }
    @Override
    public String getInf() {
        return name + " - " + hanSuDung;
    }
}

class Electronic extends Product{
    public String timeBaoHanh;

    public Electronic(String id, String name, String timeBaoHanh) {
        super(id, name);
        this.timeBaoHanh = timeBaoHanh;
    }
    @Override
    public String getInf() {
        return name + " - " + timeBaoHanh;
    }
}

class Kho<T extends Product>{
    List<T> list = new ArrayList<>();

    public void addKho(T value){
        list.add(value);
        System.out.println("Nhap kho: " + value.getName());
    }
    public void removeKho(T value){
        if (list.remove(value)){
            System.out.println("Xuat kho: " + value.getName());
        } else {
            System.out.println("Error");
        }
    }
    public void kiemKe(){
        for (T in : list){
            System.out.println(in.getInf());
        }
    }
}
