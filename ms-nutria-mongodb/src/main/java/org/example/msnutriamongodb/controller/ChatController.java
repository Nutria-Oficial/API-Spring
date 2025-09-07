package org.example.msnutriamongodb.controller;

import org.example.msnutriamongodb.contract.ChatApi;
import org.example.msnutriamongodb.dto.ArmazenarPerguntaDTO;
import org.example.msnutriamongodb.service.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.msnutriamongodb.model.Chat;

@RestController
@RequestMapping("/chat")
public class ChatController implements ChatApi {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PutMapping("/armazenarPergunta/{id}")
    public ResponseEntity<?> armazenarPergunta(@PathVariable(value = "id") Long id, @RequestBody ArmazenarPerguntaDTO perguntaDTO) {
        Chat chat = chatService.buscarChat(id);
        if(chat == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        chatService.armazenarPergunta(id, perguntaDTO);
        return new ResponseEntity<>(perguntaDTO, HttpStatus.OK);
    }

    @PostMapping("/respostaIA/{id}")
    public ResponseEntity<?> pegarRespostaIA(@PathVariable(value = "id") Long id) {
        Chat chat = chatService.buscarChat(id);
        if(chat == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String resposta = chatService.pegarRespostaIA(id);
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> listarChat(@PathVariable(value = "id") Long id){
        Chat chat = chatService.buscarChat(id);
        if(chat == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String[][] chatListado = chatService.listarChat(id);
        return new ResponseEntity<>(chatListado, HttpStatus.OK);
    }
}


