package bai63;
import java.util.Scanner;

class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Nút bấm kiểu WINDOWS");
    }
}
class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Ô đánh dấu Checkbox kiểu WINDOWS");
    }
}

class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Nút bấm kiểu MACOS");
    }
}
class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Ô đánh dấu Checkbox kiểu MACOS");
    }
}
    //Window
class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() { return new WindowsButton(); }

    @Override
    public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}

    //Mac
class MacFactory implements UIFactory {
    @Override
    public Button createButton() { return new MacButton(); }

    @Override
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập hệ điều hành của bạn (win / mac): ");
        String osConfig = scanner.nextLine().trim().toLowerCase();

        UIFactory factory;

        if (osConfig.equals("win")) {
            factory = new WindowsFactory();
        } else if (osConfig.equals("mac")) {
            factory = new MacFactory();
        } else {
            System.out.println("Hệ điều hành không hợp lệ! Mặc định sẽ dùng Windows.");
            factory = new WindowsFactory();
        }

        System.out.println("\n-> Đang khởi tạo giao diện từ nhà máy bạn chọn...");

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();

        scanner.close();
    }
}
