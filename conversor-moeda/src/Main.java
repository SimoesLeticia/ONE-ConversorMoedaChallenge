import service.CurrencyConverter;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> nomesMoedas = Map.of(
                "USD", "Dólar",
                "BRL", "Real",
                "ARS", "Peso Argentino",
                "CLP", "Peso Chileno"
        );

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== CONVERSOR DE MOEDAS ===");
            System.out.println("1 - " + nomesMoedas.get("USD") + " (USD) → " + nomesMoedas.get("BRL") + " (BRL)");
            System.out.println("2 - " + nomesMoedas.get("BRL") + " (BRL) → " + nomesMoedas.get("USD") + " (USD)");
            System.out.println("3 - " + nomesMoedas.get("USD") + " (USD) → " + nomesMoedas.get("ARS") + " (ARS)");
            System.out.println("4 - " + nomesMoedas.get("ARS") + " (ARS) → " + nomesMoedas.get("USD") + " (USD)");
            System.out.println("5 - " + nomesMoedas.get("USD") + " (USD) → " + nomesMoedas.get("CLP") + " (CLP)");
            System.out.println("6 - " + nomesMoedas.get("CLP") + " (CLP) → " + nomesMoedas.get("USD") + " (USD)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            String moedaBase = null;
            String moedaDestino = null;

            switch (opcao) {
                case 1 -> { moedaBase = "USD"; moedaDestino = "BRL"; }
                case 2 -> { moedaBase = "BRL"; moedaDestino = "USD"; }
                case 3 -> { moedaBase = "USD"; moedaDestino = "ARS"; }
                case 4 -> { moedaBase = "ARS"; moedaDestino = "USD"; }
                case 5 -> { moedaBase = "USD"; moedaDestino = "CLP"; }
                case 6 -> { moedaBase = "CLP"; moedaDestino = "USD"; }
                case 0 -> {
                    System.out.println("Programa encerrado.");
                    continuar = false;
                }
                default -> System.out.println("Opção inválida.");
            }

            if (moedaBase != null && moedaDestino != null) {
                System.out.print("Digite o valor que deseja converter: ");
                double valor = scanner.nextDouble();

                Double resultado = CurrencyConverter.converter(moedaBase, moedaDestino, valor);

                if (resultado != null) {
                    System.out.printf("\n%.2f %s (%s) = %.2f %s (%s)%n",
                            valor, nomesMoedas.get(moedaBase), moedaBase,
                            resultado, nomesMoedas.get(moedaDestino), moedaDestino);
                }
            }
        }

        scanner.close();
    }
}
