package org.example.msnutriamongodb.repository;

import org.example.msnutriamongodb.model.Ingrediente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends MongoRepository<Ingrediente, Long> {
}
