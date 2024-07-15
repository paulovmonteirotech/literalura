package com.examplo.catalogo.livros.service;

import com.examplo.catalogo.livros.model.Autor;
import com.examplo.catalogo.livros.model.Livro;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class GutendexService {

    private static final String API_URL = "https://gutendex.com/books";

    public List<Livro> buscarLivros(String parametros) {
        List<Livro> livros = new ArrayList<>();
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + "?" + parametros))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());
            JsonNode results = root.path("results");

            for (JsonNode node : results) {
                Livro livro = new Livro();
                livro.setId(node.path("id").asLong());
                livro.setTitulo(node.path("title").asText());

                // Converte o JsonNode de idiomas em uma lista de Strings
                JsonNode languagesNode = node.path("languages");
                List<String> languages = new ArrayList<>();
                for (JsonNode languageNode : languagesNode) {
                    languages.add(languageNode.asText());
                }
                livro.setIdiomas(String.join(",", languages));

                livro.setDownloadCount(node.path("download_count").asInt());

                // Supondo que você só pega o primeiro autor
                JsonNode authorNode = node.path("authors").get(0);
                Autor autor = new Autor();
                autor.setNome(authorNode.path("name").asText());
                autor.setAnoNascimento(authorNode.path("birth_year").asInt());
                autor.setAnoFalecimento(authorNode.path("death_year").asInt());

                livro.setAutor(autor);
                livros.add(livro);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return livros;
    }
}
