package bai510;
import java.util.*;
import java.io.*;

public class Main {
    public static void validateConfig(Map<String, String> config) throws InvalidConfigException {
        if (!config.containsKey("username")) {
            throw new InvalidConfigException("Thiếu tham số 'username'.");
        }
        if (!config.containsKey("timeout")) {
            throw new InvalidConfigException("Thiếu tham số 'timeout'.");
        }
        int timeout = Integer.parseInt(config.get("timeout"));
        if (timeout <= 0) {
            throw new InvalidConfigException("'timeout' phải là số nguyên > 0.");
        }
        if (config.containsKey("maxConnections")) {
            int maxConn = Integer.parseInt(config.get("maxConnections"));
            if (maxConn < 1) {
                throw new InvalidConfigException("'maxConnections' phải >= 1.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập đường dẫn file config (VD: config.txt): ");
        String filePath = sc.nextLine();

        Map<String, String> configMap = new HashMap<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split("=");
                if (parts.length == 2) {
                    configMap.put(parts[0].trim(), parts[1].trim());
                }
            }
            validateConfig(configMap);
            System.out.println("Config loaded successfully.");

        }
        catch (FileNotFoundException e) {
            System.out.println("Config file not found.");
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.out.println("Invalid config: " + e.getMessage());
        }
        finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
            }
            System.out.println("Program finished.");
        }
        sc.close();
    }
}