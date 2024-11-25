package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsumoAPI {
    public String obterDados(String endereco){
        //CRIA UMA INSTANCIA DE CLIENTE HTTP
        HttpClient client = HttpClient.newHttpClient();

        //CRIA UM CONSTRUTOR DE REQUISIÇÃO HTTP, ONDE DEFINO URL, HEADERS, ETC
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

        //REPRESENTA A RESPOSTA HTTP
        HttpResponse<String> response = null;

        try {
            //ENVIA A REQUISIÇÃO, APÓS ISSO RECEBE A RESPOSTA, CONVERTE EM STRING E GUA
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }
}
