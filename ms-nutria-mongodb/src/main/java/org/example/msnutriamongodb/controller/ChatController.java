package org.example.msnutriamongodb.controller;

import org.example.msnutriamongodb.contract.ChatApi;
import org.example.msnutriamongodb.model.Chat;
import org.example.msnutriamongodb.service.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController implements ChatApi {
  private final ChatService chatService;

  public ChatController(ChatService chatService) {
    this.chatService = chatService;
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<List<String>> listarChat(@PathVariable Integer id) {
    Chat chat = chatService.buscarChat(id);
    if (chat == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    List<String> chatListado = chatService.listarChat(id);
    return new ResponseEntity<>(chatListado, HttpStatus.OK);
  }

  @Override
  @DeleteMapping("/limparChat/{id}")
  public ResponseEntity<Void> limparChat(@PathVariable Integer id) {
    if (chatService.limparChat(id)) {
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
