package org.example.msnutriamongodb.repository;

import org.example.msnutriamongodb.model.Ingrediente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IngredienteRepository extends MongoRepository<Ingrediente, Long> {
    Boolean existsByNomeIngrediente(String nomeIngrediente);
    Optional<Ingrediente> findById(Long id);
}
