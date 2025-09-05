package org.example.msnutriamongodb.repository;

import org.example.msnutriamongodb.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, Long> {
}
