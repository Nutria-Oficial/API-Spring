package org.example.msnutriamongodb.service;

import java.util.Collections;
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

  public String[][] listarChat(Integer id) {
    Chat chatOpt = buscarChat(id);

    int quantidadePerguntas = chatOpt.getListaUsuario().size();
    int quantidadeRespostas = chatOpt.getListaBot().size();
    int linhas;

    if (quantidadePerguntas >= quantidadePerguntas) {
      linhas = quantidadePerguntas;
    } else {
      linhas = quantidadeRespostas;
    }
    String[][] perguntaResposta = new String[linhas][2];

    for (int i = 0; i < chatOpt.getListaUsuario().size(); i++) {
      perguntaResposta[i][0] = chatOpt.getListaUsuario().get(i);
    }
    for (int i = 0; i < chatOpt.getListaBot().size(); i++) {
      perguntaResposta[i][1] = chatOpt.getListaBot().get(i);
    }

    return perguntaResposta;
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
