public class Book {
    private String title;
    private String author;
    private double price;

     public Book(String title, String author, double price){
         this.title = title;
         this.author = author;
         this.price = price;
     }
     public boolean equals(Object obj){
         if (this == obj){
             return true;
         }
         if (obj instanceof Book){
             Book other = (Book) obj;
             return ((this.title.equals(other.title)) && (this.author.equals(other.author)) && (this.price == other.price));
         }
         return false;
     }

    static void main(String[] args) {
        Book sach1 = new Book("hai", "vancao", 100);
        Book sach2 = new Book("hai", "vancao", 100);
        System.out.println(sach1 == sach2);
        System.out.println(sach1.equals(sach2));
    }
}
