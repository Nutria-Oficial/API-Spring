package org.example.msnutriamongodb.controller;

import org.example.msnutriamongodb.contract.ChatApi;
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

    public ResponseEntity<?> pegarRespostaIA(Long id) {
        Chat chat = chatService.buscarChat(id);
        if(chat == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String resposta = chatService.pegarRespostaIA(id);
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    public ResponseEntity<?> listarChat(Long id){
        Chat chat = chatService.buscarChat(id);
        if(chat == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String[][] chatListado = chatService.listarChat(id);
        return new ResponseEntity<>(chatListado, HttpStatus.OK);
    }

    public ResponseEntity<?> limparChat(Long id){
        if(chatService.limparChat(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


