package org.example.msnutriamongodb.contract;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/chat")
public interface ChatApi {
    @GetMapping("/respostaIA/{id}")
    ResponseEntity<?> pegarRespostaIA(@PathVariable(value = "id") Long id);

    @GetMapping("/{id}")
    ResponseEntity<?> listarChat(@PathVariable(value = "id") Long id);

    @DeleteMapping("/limparChat/{id}")
    ResponseEntity<?> limparChat(@PathVariable(value = "id") Long id);

    }
