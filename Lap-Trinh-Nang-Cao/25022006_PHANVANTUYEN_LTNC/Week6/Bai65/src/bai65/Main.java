package bai65;

abstract class ExportFactory {
    public abstract Export createExport();
}
class PdfFactory extends ExportFactory {
    @Override
    public Export createExport() { return new PdfExport(); }
}
class ExcelFactory extends ExportFactory {
    @Override
    public Export createExport() { return new ExcelExport(); }
}


public class Main {
    public static void main(String[] args) {

        System.out.println("========== 1. TEST SINGLETON (Logger) ==========");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("Hệ thống khởi động thành công.");
        System.out.println("Kiểm tra 2 object có phải là 1 không: " + (logger1 == logger2)); // Phải in ra true


        System.out.println("\n========== 2. TEST FACTORY METHOD (Export) ==========");
        // Không dùng "new PdfExport()" ở đây, giao cho Nhà máy làm
        ExportFactory pdfFactory = new PdfFactory();
        Export myPdf = pdfFactory.createExport();
        myPdf.doExport();

        ExportFactory excelFactory = new ExcelFactory();
        Export myExcel = excelFactory.createExport();
        myExcel.doExport();


        System.out.println("\n========== 3. TEST ADAPTER (Player) ==========");
        // Hệ thống chỉ làm việc với interface Player, không quan tâm OldPlayer
        Player audioPlayer = new PlayerAdapter(new OldPlayer());
        audioPlayer.play("Chuyen_Tình_Lang_Tu.mp3");


        System.out.println("\n========== 4. TEST PROTOTYPE (Config) ==========");
        // Tạo bản gốc
        AppConfig originalConfig = new AppConfig("Dark Mode", "Tiếng Việt");

        // Photocopy ra một bản sao và thay đổi màu nền
        AppConfig userConfig = originalConfig.clone();
        userConfig.setThemeColor("Light Mode");

        // In ra để chứng minh bản gốc không bị ảnh hưởng
        System.out.println("Bản GỐC ban đầu : " + originalConfig);
        System.out.println("Bản SAO của User: " + userConfig);
    }
}
