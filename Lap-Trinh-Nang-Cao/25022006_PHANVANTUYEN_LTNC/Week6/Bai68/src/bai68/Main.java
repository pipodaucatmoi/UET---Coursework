package bai68;

class ReportService {
    private ReportFormatter formatter;

    public ReportService(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public String export(Report data) {
        return formatter.format(data);
    }
}

class Report {
    private String title;
    private String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
}


interface ReportFormatter {
    String format(Report data);
}


class JsonFormatter implements ReportFormatter {
    @Override
    public String format(Report data) {
        // Giả lập chuỗi chuẩn JSON
        return "{\n" +
                "  \"title\": \"" + data.getTitle() + "\",\n" +
                "  \"content\": \"" + data.getContent() + "\"\n" +
                "}";
    }
}

class XmlFormatter implements ReportFormatter {
    @Override
    public String format(Report data) {
        // Giả lập chuỗi chuẩn XML
        return "<Report>\n" +
                "  <Title>" + data.getTitle() + "</Title>\n" +
                "  <Content>" + data.getContent() + "</Content>\n" +
                "</Report>";
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("=== HỆ THỐNG XUẤT BÁO CÁO (STRATEGY PATTERN) ===");

        // Tạo dữ liệu báo cáo
        Report myReport = new Report("Báo cáo Doanh thu", "Tháng này công ty lãi 10 tỷ VNĐ.");

        // Sếp muốn xuất file JSON
        System.out.println("\n-> Đang xuất theo định dạng JSON:");
        ReportFormatter jsonTool = new JsonFormatter();
        ReportService service1 = new ReportService(jsonTool);
        System.out.println(service1.export(myReport));

        // Khách hàng muốn xem file XML
        System.out.println("\n-> Đang xuất theo định dạng XML:");
        ReportFormatter xmlTool = new XmlFormatter();
        ReportService service2 = new ReportService(xmlTool); // Bơm công cụ XML vào Service
        System.out.println(service2.export(myReport));
    }
}
