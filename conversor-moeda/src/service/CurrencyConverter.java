package service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.ExchangeResponse;
import util.HttpClientUtil;

public class CurrencyConverter {

    public static Double converter(String moedaBase, String moedaDestino, double valor) {
        String respostaJson = HttpClientUtil.getRates(moedaBase);

        if (respostaJson == null) {
            System.out.println("Erro: sem resposta da API.");
            return null;
        }

        JsonObject jsonObject = JsonParser.parseString(respostaJson).getAsJsonObject();
        String resultado = jsonObject.get("result").getAsString();

        if (!resultado.equals("success")) {
            String tipoErro = jsonObject.has("error-type") ? jsonObject.get("error-type").getAsString() : "erro desconhecido";
            System.out.println("Erro na API: " + tipoErro);
            return null;
        }

        Gson gson = new Gson();
        ExchangeResponse dados = gson.fromJson(respostaJson, ExchangeResponse.class);

        Double taxa = dados.getConversion_rates().get(moedaDestino);

        if (taxa == null) {
            System.out.println("Moeda de destino inválida.");
            return null;
        }

        return valor * taxa;
    }
}
