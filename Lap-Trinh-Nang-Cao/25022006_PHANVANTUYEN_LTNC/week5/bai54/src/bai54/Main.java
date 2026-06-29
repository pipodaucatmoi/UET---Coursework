package bai54;


public class Main {
    public static void main(String[] args) {
        String text = "Hello world. This is a java program. Hello java, hello world.";

        System.out.println("Văn bản đầu vào: " + text + "\n");

        WordCounter counter = new WordCounter();
        counter.analyze(text);
        counter.displayResult();
    }
}