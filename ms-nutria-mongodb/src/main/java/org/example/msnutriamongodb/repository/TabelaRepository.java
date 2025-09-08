package org.example.msnutriamongodb.repository;

import org.example.msnutriamongodb.model.Produto;
import org.example.msnutriamongodb.model.Tabela;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TabelaRepository extends MongoRepository<Tabela, Long> {
    List<Tabela> findAllByIdProduto(Long idProduto);
}
