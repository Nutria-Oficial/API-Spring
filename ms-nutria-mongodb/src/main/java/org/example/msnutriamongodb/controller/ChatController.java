package org.example.msnutriamongodb.controller;

import org.example.msnutriamongodb.contract.ChatApi;
import org.example.msnutriamongodb.service.ChatService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController implements ChatApi {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }
}
