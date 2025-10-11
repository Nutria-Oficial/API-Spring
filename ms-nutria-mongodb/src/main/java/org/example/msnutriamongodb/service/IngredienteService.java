package org.example.msnutriamongodb.service;

import org.example.msnutriamongodb.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService {
  private final IngredienteRepository ingredienteRepository;

  public IngredienteService(IngredienteRepository ingredienteRepository) {
    this.ingredienteRepository = ingredienteRepository;
  }
}
