package bai53;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String text = "Hello world! This is a Java program. Java is fast, Java is strong. Hello everyone, welcome to the world of Java.";

        System.out.println("\nVăn bản gốc: " + text);
        String lowerText = text.toLowerCase();
        String cleanedText = lowerText.replaceAll("[^a-z\\s]", "");
        System.out.println("\n[1] Sau khi chuẩn hóa: " + cleanedText);

        String[] words = cleanedText.split("\\s+");
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            if (wordCountMap.containsKey(word)) {
                int oldValue = wordCountMap.get(word);
                wordCountMap.put(word, oldValue + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        String maxWord = "";
        int maxCount = 0;
        List<String> uniqueWords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            String currentWord = entry.getKey();
            int currentCount = entry.getValue();

            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxWord = currentWord;
            }

            if (currentCount == 1) {
                uniqueWords.add(currentWord);
            }
        }

        System.out.println("\n1. Từ xuất hiện nhiều nhất: '" + maxWord + "' (" + maxCount + " lần)");
        System.out.println("2. Các từ xuất hiện đúng 1 lần (Unique words): " + uniqueWords);
    }
}
