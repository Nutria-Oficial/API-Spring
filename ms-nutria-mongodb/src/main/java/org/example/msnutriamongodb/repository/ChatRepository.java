package org.example.msnutriamongodb.repository;

import org.example.msnutriamongodb.model.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRepository extends MongoRepository<Chat, Integer> {
    Optional<Chat> findByIdUsuario(Integer idUsuario);
}
