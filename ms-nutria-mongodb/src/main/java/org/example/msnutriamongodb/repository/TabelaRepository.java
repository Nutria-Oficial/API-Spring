package org.example.msnutriamongodb.repository;

import org.example.msnutriamongodb.model.Tabela;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabelaRepository extends MongoRepository<Tabela, Long> {
}
