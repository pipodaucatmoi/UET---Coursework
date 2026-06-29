public class Student {
    private String id;
    private String name;
    private String mail;
    private double gpa;
    public Student(){
        this.id = "";
        this.name = "";
        this.mail = "";
        this.gpa = 0.0;
    }
    public Student(String id, String name){
        this.id = id;
        this.name = name;
        this.mail  = "";
        this.gpa = 0.0;
    }
    public Student(String id, String name, String mail, double gpa){
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.gpa = gpa;
    }
    public boolean setGpa(double diem){
        if ((diem < 0) || (diem > 4)){
            System.out.println("Diem khong hop le");
            return false;
        } else {
            this.gpa = diem;
            return true;
        }
    }
    public void getValue(){
        System.out.println("id:"+this.id +" name:"+ this.name +" email:"+ this.mail +" gpa:"+ this.gpa);
    }
    static void main(String[] args) {
        Student hocSinh1 = new Student();
        Student hocSinh2 = new Student("002", "jack");
        Student hocSinh3 = new Student("003", "tom", "vnu@gmail.com", 3.7);
        System.out.println("CHECK TRUOC");
        hocSinh1.getValue();
        hocSinh2.getValue();
        hocSinh3.getValue();
        hocSinh1.setGpa(3.6);
        hocSinh2.setGpa(3.3);
        hocSinh3.setGpa(-0.6);
        System.out.println("SAU KHI THAO TAC");
        hocSinh1.getValue();
        hocSinh2.getValue();
        hocSinh3.getValue();

    }
}
