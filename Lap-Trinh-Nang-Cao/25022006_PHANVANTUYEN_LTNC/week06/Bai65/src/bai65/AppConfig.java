package bai65;

public class AppConfig implements Cloneable{
    private String themeColor;
    private String language;

    public AppConfig(String themeColor, String language) {
        this.themeColor = themeColor;
        this.language = language;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }

    @Override
    public AppConfig clone() {
        try {
            return (AppConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Lỗi sao chép!", e);
        }
    }

    @Override
    public String toString() {
        return "Cấu hình [Màu nền: " + themeColor + " | Ngôn ngữ: " + language + "]";
    }
}
