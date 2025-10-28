package org.example.msnutriamongodb.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.example.msnutriamongodb.model.Chat;
import org.example.msnutriamongodb.repository.ChatRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
  private final ChatRepository chatRepository;
  private final MongoTemplate mongoTemplate;

  public ChatService(ChatRepository chatRepository, MongoTemplate mongoTemplate) {
    this.chatRepository = chatRepository;
    this.mongoTemplate = mongoTemplate;
  }

  public Chat buscarChat(Integer id) {
    return chatRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Chat não encontrado"));
  }

  public String pegarRespostaIA(Integer id) {
    Chat chatOpt = buscarChat(id);
    return chatOpt.getListaBot().getLast();
  }

  public List<String> listarChat(Integer id) {
    Chat chat = buscarChat(id);

    List<String> usuario = chat.getListaUsuario();
    List<String> bot = chat.getListaBot();

    List<String> resultado = new ArrayList<>();

    int i = 0, j = 0;
    while (i < usuario.size() || j < bot.size()) {
      if (i < usuario.size()) {
        resultado.add(usuario.get(i));
        i++;
      }
      if (j < bot.size()) {
        resultado.add(bot.get(j));
        j++;
      }
    }

    return resultado;
  }

  public boolean limparChat(Integer id) {
    Chat chatBuscado = buscarChat(id);
    if (chatBuscado != null) {
      Query query = new Query(Criteria.where("_id").is(id));
      Update update =
          new Update().set("lUser", Collections.emptyList()).set("lBot", Collections.emptyList());
      mongoTemplate.updateFirst(query, update, Chat.class);
      return true;
    }
    return false;
  }
}
