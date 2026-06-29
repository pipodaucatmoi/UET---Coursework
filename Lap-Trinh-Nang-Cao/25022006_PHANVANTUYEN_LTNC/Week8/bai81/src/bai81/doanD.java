package bai81;

class Author {
    private String name, email, phone, address;

    public Author(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getInfo() {
        return name + " (Email: " + email + ")";
    }
}

class Report {
    private String title;
    private Author author;

    public Report(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public void inBaoCao() {
        System.out.println("Tiêu đề: " + title);
        System.out.println("Tác giả: " + author.getInfo());
    }
}

public class doanD {
    public static void main(String[] args) {
        System.out.println("=== CHẠY THỬ ĐOẠN D: QUẢN LÝ BÁO CÁO ===");

        Author author = new Author("Nguyen Van A", "nva@gmail.com", "0987", "Hà Nội");
        Report report = new Report("Báo cáo Refactoring", author);

        report.inBaoCao();
    }
}
