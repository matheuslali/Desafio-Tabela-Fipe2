package br.com.alura.desafio.tabelaFipe.Desafio.Tabela.Fipe.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    public String consume(String e) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder().uri(URI.create(e)).build();
        HttpResponse<String> response = null;
        try {
             response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        var json = response.body();
        return json;
    }
}
