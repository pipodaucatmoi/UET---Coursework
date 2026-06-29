package bai54;
import java.util.HashMap;
import java.util.Map;

class WordCounter {
    private Map<String, Integer> map = new HashMap<>();

    public void analyze(String text) {

        String cleanedText = text.toLowerCase().replaceAll("[,.]", "");
        String[] words = cleanedText.split("\\s+");
        for (String word : words) {
            if (word.isEmpty()) continue;

            if (map.containsKey(word)) {
                int oldValue = map.get(word);
                map.put(word, oldValue + 1);
            } else {
                map.put(word, 1);
            }
        }
    }


    public void displayResult() {
        System.out.println("--- DANH SÁCH TẦN SUẤT TỪ ---");
        String maxWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());

            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
        }

        System.out.println("\n=> TỪ KHÓA CHÍNH (Xuất hiện nhiều nhất): '" + maxWord + "' (" + maxCount + " lần)");
    }
}
