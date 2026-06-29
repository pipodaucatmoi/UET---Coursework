import java.sql.SQLOutput;

public class NumberWrapper{
    private int value;
    public NumberWrapper(int value){
        this.value = value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
    public static void swap(NumberWrapper a, NumberWrapper b) {
        NumberWrapper temp = a;
        a = b;
        b = temp;
    }
    static void main(String[] args) {
        NumberWrapper n1 = new NumberWrapper(5);
        NumberWrapper n2 = new NumberWrapper(10);
        System.out.println("TRUOC KHI SWAP");
        System.out.println(n1.getValue());
        System.out.println(n2.getValue());
        swap(n1, n2);
        System.out.println("SAU KHI SWAP");
        System.out.println(n1.getValue());
        System.out.println(n2.getValue());

    }
}


