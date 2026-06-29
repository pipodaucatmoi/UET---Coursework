class Author {
    private final String name;
    private final String email;
    private final String phone;
    private final String address;

    public Author(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
}

class Report {
    private final String title;
    private final String content;
    private final Author author;

    public Report(String title, String content, Author author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Author getAuthor() { return author; }

    public void printReportDetails() {
        System.out.println("=================================");
        System.out.println("REPORT: " + title.toUpperCase());
        System.out.println("=================================");
        System.out.println("Content: " + content);
        System.out.println("\n----- Author information -----");
        System.out.println("Name         : " + author.getName());
        System.out.println("Email        : " + author.getEmail());
        System.out.println("Phone number : " + author.getPhone());
        System.out.println("Address      : " + author.getAddress());
        System.out.println("=================================\n");
    }
}

public class ReportManager {
    public static void ReportManager() {
        Author reportAuthor = new Author(
            "Vu Duc Trung", 
            "25022036@vnu.edu.vn", 
            "0966780714", 
            "Truong dai hoc cong nghe - DHQGHN"
        );

        Report finalReport = new Report(
            "Thuc trang ung dung AI trong quan ly xa hoi tai Viet Nam",
            "Bao cao phan tich cac co hoi, thach thuc va han che khi ap dung tri tue nhan tao",
            reportAuthor
        );

        finalReport.printReportDetails();
    }
}
