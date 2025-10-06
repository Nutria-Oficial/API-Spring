package org.example.msnutriamongodb.service;

import org.example.msnutriamongodb.dto.exceptiondto.ErrorDTO;
import org.example.msnutriamongodb.exception.DatabaseInsertException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class FastApiService {
    private final WebClient webClient;

    public FastApiService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://127.0.0.1:8000").build();
    }
    public void criarTabelaNutricional(int id) {
        webClient.post()
                .uri("/tablecreator/{cod_user}", id)
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse ->
                        clientResponse.bodyToMono(ErrorDTO.class).map(errorDTO -> new DatabaseInsertException(errorDTO.message()))
                ).bodyToMono(String.class).block();
    }
}
