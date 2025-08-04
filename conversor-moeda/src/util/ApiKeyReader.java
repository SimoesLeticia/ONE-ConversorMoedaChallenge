package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ApiKeyReader {

    public static String getApiKey() {
        try {
            return Files.readString(Paths.get("src/API-KEY.txt")).trim();
        } catch (IOException e) {
            System.out.println("Erro ao ler API-KEY: " + e.getMessage());
            return null;
        }
    }
}
