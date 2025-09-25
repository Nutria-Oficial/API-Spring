package org.example.msnutriamongodb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FastApiService {
    private final WebClient webClient;

    public FastApiService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8000").build();
    }
    public Mono<String> criarTabelaNutricional(long id) {
        return webClient.post()
                .uri("/tablecreator/{cod_user}", id)
                .retrieve()
                .bodyToMono(String.class);
    }
}
