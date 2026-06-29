package task410;

public class Main {
    public static void main(String[] args) {
        LibrarySection<Book> bookKho = new LibrarySection<>();
        Book sach1 = new Book("B01", "Dế Mèn Phiêu Lưu Ký", 150, "Tô Hoài");
        Book sach2 = new Book("B02", "Clean Code", 464, "Robert C. Martin");
        bookKho.addLib(sach1);
        bookKho.addLib(sach2);
        bookKho.showLib();

        bookKho.outLib(sach1);
        bookKho.showLib();

        LibrarySection<Dvd> dvdKho = new LibrarySection<>();
        Dvd dvd1 = new Dvd("D01", "Inception", "Christopher Nolan", 148);
        Dvd dvd2 = new Dvd("D02", "Avenger: Endgame", "Anthony Russo", 181);
        dvdKho.addLib(dvd1);
        dvdKho.addLib(dvd2);
        dvdKho.showLib();

        dvdKho.outLib(dvd2);
        dvdKho.showLib();
    }
}
