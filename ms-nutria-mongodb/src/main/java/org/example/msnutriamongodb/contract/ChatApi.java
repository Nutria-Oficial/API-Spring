package org.example.msnutriamongodb.contract;

import org.springframework.http.ResponseEntity;

public interface ChatApi {

  ResponseEntity<String> pegarRespostaIA(Integer id);

  ResponseEntity<String[][]> listarChat(Integer id);

  ResponseEntity<Void> limparChat(Integer id);
}
