package org.example.msnutriamongodb.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Optional;
import org.example.msnutriamongodb.dto.RequestIngredienteDTO;
import org.example.msnutriamongodb.dto.ResponseIngredienteDTO;
import org.example.msnutriamongodb.exception.DuplicateException;
import org.example.msnutriamongodb.exception.NotFoundException;
import org.example.msnutriamongodb.model.Ingrediente;
import org.example.msnutriamongodb.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService {
  private final IngredienteRepository ingredienteRepository;
  private final ObjectMapper objectMapper;

  public IngredienteService(
      IngredienteRepository ingredienteRepository, ObjectMapper objectMapper) {
    this.ingredienteRepository = ingredienteRepository;
    this.objectMapper = objectMapper;
  }

  public List<ResponseIngredienteDTO> buscarIngredientesCadastrados() {
    return ingredienteRepository.findAll().stream()
        .map(ingrediente -> objectMapper.convertValue(ingrediente, ResponseIngredienteDTO.class))
        .toList();
  }

  public ResponseIngredienteDTO buscarIngredientePeloId(Integer id) {
    Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);
    ResponseIngredienteDTO ingredienteDTO =
        objectMapper.convertValue(ingrediente, ResponseIngredienteDTO.class);
    if (ingredienteDTO == null) {
      throw new NotFoundException("O ingrediente não foi encontrado.");
    }
    return ingredienteDTO;
  }

  public ResponseIngredienteDTO criarIngrediente(RequestIngredienteDTO ingredienteDTO) {
    Integer proximoId = ingredienteRepository.findLastIngredienteId() + 1;
    Ingrediente ingrediente = objectMapper.convertValue(ingredienteDTO, Ingrediente.class);
    boolean ingredienteJaExiste =
        ingredienteRepository.existsByNomeIngrediente(ingrediente.getNomeIngrediente());
    if (ingredienteJaExiste) {
      throw new DuplicateException("Um ingrediente já foi cadastrado com esse nome.");
    }
    ingrediente.setId(proximoId);
    ingredienteRepository.save(ingrediente);
    return objectMapper.convertValue(ingrediente, ResponseIngredienteDTO.class);
  }
}
