package bai51;

public class Main {

    public static void useString() {
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 100000; i++) {
            str += "Hello";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("1. Thời gian chạy của String: " + (endTime - startTime) + " ms");
    }

    public static void useStringBuffer() {
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            sb.append("Hello");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("2. Thời gian chạy của StringBuffer: " + (endTime - startTime) + " ms");
    }

    public static void contentAnalysis(String text) {
        System.out.println("\nPhân tích văn bản");
        String[] sentences = text.split("[.?!]+");
        System.out.println("Số lượng câu: " + sentences.length);

        String replacedText = text.replace("Java", "Python");
        System.out.println("Văn bản sau khi Replace (Java -> Python):\n" + replacedText);
    }

    public static void main(String[] args) {
        useString();
        useStringBuffer();

        String document = "Hello world. This is a Java program! Do you like Java? Yes, Java is great.";
        contentAnalysis(document);
    }
}