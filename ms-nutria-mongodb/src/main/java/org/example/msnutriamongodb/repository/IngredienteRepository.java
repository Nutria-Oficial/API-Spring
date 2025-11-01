package org.example.msnutriamongodb.repository;

import java.util.List;
import java.util.Optional;
import org.example.msnutriamongodb.model.Ingrediente;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends MongoRepository<Ingrediente, Integer> {
  Boolean existsByNomeIngrediente(String nomeIngrediente);

  Optional<Ingrediente> findById(Integer id);

  @Aggregation(pipeline = {"{$sort:{_id:-1}}", "{$limit:1}", "{$project:{_id:1}}"})
  Integer findLastIngredienteId();

  // busca por nome exato
  List<Ingrediente> findByNomeIngrediente(String nomeIngrediente);

  // busca por início do nome, usando regex
  @Query("{ 'cNmIngrediente' : { $regex: ?0, $options: 'i' } }")
  List<Ingrediente> findByNomeIngredienteRegex(String regex);
}
