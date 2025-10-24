package org.example.msnutriamongodb.service;

import java.time.Duration;
import org.example.msnutriamongodb.dto.exceptiondto.ErrorDTO;
import org.example.msnutriamongodb.exception.DatabaseInsertException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Service
public class FastApiService {
  private final WebClient webClient;

  public FastApiService(WebClient.Builder builder) {
    HttpClient httpClient =
        HttpClient.create().responseTimeout(Duration.ofSeconds(30)); // espera até 30s pela resposta

    this.webClient =
        builder
            .baseUrl("${FASTAPI_URL}")
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
                    .map(errorDTO -> new DatabaseInsertException(errorDTO.message())))
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
                    .map(errorDTO -> new DatabaseInsertException(errorDTO.message())))
        .bodyToMono(String.class)
        .block();
  }
}
