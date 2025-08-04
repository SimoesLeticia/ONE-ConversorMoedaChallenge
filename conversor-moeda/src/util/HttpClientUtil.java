package util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientUtil {

    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static String getRates(String baseCurrency) {
        String apiKey = ApiKeyReader.getApiKey();
        if (apiKey == null) {
            return null;
        }

        String url = BASE_URL + apiKey + "/latest/" + baseCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao fazer requisição: " + e.getMessage());
            return null;
        }
    }
}
