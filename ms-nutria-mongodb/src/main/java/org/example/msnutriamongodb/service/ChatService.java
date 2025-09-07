package org.example.msnutriamongodb.service;

import org.example.msnutriamongodb.dto.ArmazenarPerguntaDTO;
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
    public Chat buscarChat(Long id) {
        return chatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chat não encontrado"));
    }

    public void armazenarPergunta(Long id, ArmazenarPerguntaDTO armazenarPerguntaDTO){
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().push("lUser", armazenarPerguntaDTO.pergunta());
        mongoTemplate.updateFirst(query, update, "chat");
    }

    public String pegarRespostaIA(Long id){
        Chat chatOpt = buscarChat(id);
        return chatOpt.getListaBot().getLast();
    }

    public String[][] listarChat(Long id){
        Chat chatOpt = buscarChat(id);

        int quantidadePerguntas = chatOpt.getListaUsuario().size();
        int quantidadeRespostas = chatOpt.getListaBot().size();
        int linhas;

        if(quantidadePerguntas>=quantidadePerguntas){
            linhas = quantidadePerguntas;
        }else{
            linhas = quantidadeRespostas;
        }

        String[][] perguntaResposta = new String[linhas][2];

        for(int i = 0; i < chatOpt.getListaUsuario().size(); i++){
            perguntaResposta[i][0] = chatOpt.getListaUsuario().get(i);
        }
        for(int i = 0; i < chatOpt.getListaBot().size(); i++){
            perguntaResposta[i][1] = chatOpt.getListaBot().get(i);
        }

        return perguntaResposta;
    }

    //se for um método só
//        public String armazenarPerguntaPegarResposta(String pergunta, Long id){
//        Chat chatOpt = mostrarChat(id);
//
//        chatOpt.getListaUsuario().add(pergunta);
//        chatRepository.save(chatOpt);
//
//        return chatOpt.getListaBot().getLast();
//    }
}
