import java.util.Arrays;

class Product{
    String id, name;
    String price;
    public Product(String id, String name, String price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public String toString(){
        return "ID:" + this.id +" |NAME:" + name + " |GIA:" + price;
    }
}
class Inventory{
    Product[] items;
    public Inventory(Product[] initialltems){
        this.items = initialltems;
    }
    public void showInventory(){
        for (Product p : items){
            System.out.println(p);
        }
    }
}

public class ShallowDeepCopy {
    static void main(String[] args) {
        Product[] arr1 = {new Product("001", "LAPTOP", "2000$"), new Product("002", "IP", "1900$")};
        Inventory kho = new Inventory(arr1);
        //System.out.println(arr1[0]);
        arr1[0].setPrice("5000S");
        kho.showInventory();
    }
}
