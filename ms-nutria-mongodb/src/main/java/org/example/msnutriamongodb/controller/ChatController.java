package org.example.msnutriamongodb.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.msnutriamongodb.contract.ChatApi;
import org.example.msnutriamongodb.dto.exceptiondto.ErrorDTO;
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
  @GetMapping("/respostaIA/{id}")
  public ResponseEntity<String> pegarRespostaIA(@PathVariable Integer id) {
    Chat chat = chatService.buscarChat(id);
    if (chat == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    String resposta = chatService.pegarRespostaIA(id);
    return new ResponseEntity<>(resposta, HttpStatus.OK);
  }

  @ApiResponses({
          @ApiResponse(
                  responseCode = "200",
                  description = "Mensagens do chat retornadas com sucesso",
                  content =
                  @Content(
                          mediaType = "application/json",
                          schema = @Schema(implementation = List.class))),
          @ApiResponse(
                  responseCode = "404",
                  description = "Chat não encontrado",
                  content =
                  @Content(
                          mediaType = "application/json",
                          schema = @Schema(implementation = ErrorDTO.class)))
  })
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
