package org.example.msnutriamongodb.repository;

import java.util.List;
import org.example.msnutriamongodb.model.Tabela;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabelaRepository extends MongoRepository<Tabela, Integer> {
  List<Tabela> findAllByIdProduto(Integer idProduto);
}
