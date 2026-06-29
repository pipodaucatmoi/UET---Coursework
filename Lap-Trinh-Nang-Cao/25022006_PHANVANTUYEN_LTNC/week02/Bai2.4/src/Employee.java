class MyDate{
    int day, month, year;
    public MyDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public void setBirthday(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public String toString(){
        return day + "/" + month + "/" + year;
    }
}
public class Employee{
    private String name;
    private MyDate birthday;

    public Employee(String name, MyDate birthday){
        this.name = name;
        this.birthday = birthday;
    }
    public Employee(Employee other){
        this.name = other.name;
        this.birthday = new MyDate(other.birthday.day, other.birthday.month, other.birthday.year);
    }

    static void main(String[] args) {
        MyDate acc1 = new MyDate(1,1,2000);
        Employee emp1 = new Employee("A", acc1);
        Employee emp2 = new Employee(emp1);
        System.out.println(emp1);
        System.out.println(emp2);
        acc1.setBirthday(2,2,2022);
        System.out.println(emp1.birthday);
        System.out.println(emp2.birthday);
    }
}
