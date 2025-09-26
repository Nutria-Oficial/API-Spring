package org.example.msnutriamongodb.repository;

import org.example.msnutriamongodb.model.Produto;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, Long> {
    List<Produto> findAllByIdUsuarioCriacao(Long idUsuario);
    @Aggregation(pipeline = {
            "{$sort:{_id:-1}}",
            "{$limit:1}",
            "{$project:{_id:1}}"
    })
    Long findLastProdutoId();
}
