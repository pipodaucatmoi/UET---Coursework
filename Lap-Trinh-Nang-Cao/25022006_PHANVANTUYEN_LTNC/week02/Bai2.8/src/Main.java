class Person {
    private String name;
    private Person me;

    public Person(String name){
        this.name = name;
    }
    public void setMe(Person other){
        this.me = other;
    }
    public Person getMe(){
        return this.me;
    }
    public String getName(){
        return this.name;
    }
}
public class Main {
    static void main(String[] args) {
        Person p = new Person("domixi");
        p.setMe(p);
        System.out.println(p.setMe().getName());
        System.out.println("set p = null");
        p = null;
        // System.out.println(p.setMe().getName());
    }
}