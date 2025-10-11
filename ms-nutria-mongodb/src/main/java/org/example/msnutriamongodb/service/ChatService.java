package org.example.msnutriamongodb.service;

import org.example.msnutriamongodb.repository.ChatRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
  private final ChatRepository chatRepository;

  public ChatService(ChatRepository chatRepository) {
    this.chatRepository = chatRepository;
  }
}
