package bai64;

import java.util.ArrayList;
import java.util.List;

class ReportTemplate implements Cloneable {
    private String title;
    private String footer;
    private List<String> sections;

    public ReportTemplate(String title, String footer, List<String> sections) {
        this.title = title;
        this.footer = footer;
        this.sections = sections;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Hàm thực hiện việc Photocopy
    @Override
    public ReportTemplate clone() {
        try {
            // Bước 1: Photo một bản nông (Shallow copy)
            ReportTemplate copy = (ReportTemplate) super.clone();

            // Bước 2: BẮT BUỘC phải Photo sâu (Deep copy) cái danh sách sections.
            // Nếu không làm bước này, khi bản sao sửa sections, bản gốc cũng bị đổi theo!
            copy.sections = new ArrayList<>(this.sections);

            return copy;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Lỗi khi clone object", e);
        }
    }

    @Override
    public String toString() {
        return "ReportTemplate [Title: '" + title + "', Footer: '" + footer + "', Sections: " + sections + "]";
    }
}
