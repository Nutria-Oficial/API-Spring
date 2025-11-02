package org.example.msnutriamongodb.service;

// Padrão de Projeto utilizado: Factory Method e Builder Pattern
// Estamos usando o Builder Pattern para criar o WebClient
// Estamos usando o Factory Method para criar o ReactorClientHttpConnector

import java.time.Duration;
import org.example.msnutriamongodb.dto.exceptiondto.ErrorDTO;
import org.example.msnutriamongodb.exception.DatabaseInsertException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Service
public class FastApiService {
  private final WebClient webClient;

  public FastApiService(WebClient.Builder builder, @Value("${fastapi.url}") String fastApiUrl) {
    HttpClient httpClient =
        HttpClient.create().responseTimeout(Duration.ofSeconds(30));


    this.webClient =
        builder
            .baseUrl(fastApiUrl)
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            .build();
  }

  public void criarTabelaNutricional(int id) {
    webClient
        .post()
        .uri("/tablecreator/{cod_user}", id)
        .retrieve()
        .onStatus(
            HttpStatusCode::isError,
            clientResponse ->
                clientResponse
                    .bodyToMono(ErrorDTO.class)
                    .map(errorDTO -> new DatabaseInsertException(errorDTO.getMessage())))
        .bodyToMono(String.class)
        .block();
  }

  public void criarEmbedding() {
    webClient
        .post()
        .uri("/embedding/")
        .retrieve()
        .onStatus(
            HttpStatusCode::isError,
            clientResponse ->
                clientResponse
                    .bodyToMono(ErrorDTO.class)
                    .map(errorDTO -> new DatabaseInsertException(errorDTO.getMessage())))
        .bodyToMono(String.class)
        .block();
  }
}
