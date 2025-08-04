
# ONE - Conversor de Moeda Challenge

Projeto desenvolvido como parte do curso *Java e Orientação a Objetos G8 - ONE*, do programa **Oracle Next Education (ONE)**, em parceria com a Alura.  

## Sobre o Projeto

Este é um conversor de moedas interativo via console.  
O usuário escolhe entre diferentes opções de conversão e insere o valor desejado. O programa então realiza a conversão com base nas taxas atuais obtidas pela API [ExchangeRate API](https://www.exchangerate-api.com/).

## Tecnologias Utilizadas

- **Java 17**  
- **API ExchangeRate**
- **HttpClient / HttpRequest / HttpResponse**  
- **Gson**
- **IntelliJ IDEA** 

## Funcionalidades

- Menu interativo no terminal com opções de conversão
- Conversão entre as seguintes moedas:
  - USD ↔ BRL
  - USD ↔ ARS
  - USD ↔ CLP
- Requisições dinâmicas para taxas atualizadas
- Desserialização do JSON de resposta

## 🛡Organização do Código

```
src/
├── Main.java                       # Interface
├── model/ExchangeResponse.java     # Mapeamento da resposta JSON
├── service/CurrencyConverter.java  # Lógica principal de conversão
├── util/HttpClientUtil.java        # Utilitário para requisições
├── util/ApiKeyReader.java          # Leitura segura da API KEY
├── API-KEY.txt                     # (Vazio por segurança, você preenche com sua chave)
```

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/ONE-ConversorMoedaChallenge.git
   ```

2. Abra no IntelliJ e adicione a biblioteca Gson como dependência.

3. Adicione sua API KEY no arquivo `src/API-KEY.txt`.

4. Execute a classe `Main.java`.

## Contribuições

Contribuições são sempre bem-vindas!  
Se você tem sugestões de melhorias, encontrou algum bug ou simplesmente quer dizer "olá 👋🏽", sinta-se à vontade para abrir uma issue ou enviar um pull request.

---
