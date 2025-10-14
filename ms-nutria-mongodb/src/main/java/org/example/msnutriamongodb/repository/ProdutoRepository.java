package org.example.msnutriamongodb.repository;

import java.util.List;
import org.example.msnutriamongodb.model.Produto;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, Integer> {
  List<Produto> findAllByIdUsuarioCriacao(Integer idUsuario);

  @Aggregation(pipeline = {"{$sort:{_id:-1}}", "{$limit:1}", "{$project:{_id:1}}"})
  Integer findLastProdutoId();

  @Aggregation(
      pipeline = {
        "{$match:{nCdUsuarioCriacao:?0}}",
        "{$lookup:{from:'tabela',localField:'_id',foreignField:'nCdProduto',as:'tabelas'}}",
        "{$match:{$expr:{$gt:[{$size:'$tabelas'},1]}}}",
        "{$project:{tabelas:0}}"
      })
  List<Produto> findAllByMoreThenOneTable(Integer idUsuario);
}
