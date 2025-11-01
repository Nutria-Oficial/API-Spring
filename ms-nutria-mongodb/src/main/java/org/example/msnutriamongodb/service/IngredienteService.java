package org.example.msnutriamongodb.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Optional;

import org.example.msnutriamongodb.dto.GetIngredienteDTO;
import org.example.msnutriamongodb.dto.PostIngredienteDTO;
import org.example.msnutriamongodb.dto.GetNomeIdIngredienteDTO;
import org.example.msnutriamongodb.exception.DuplicateException;
import org.example.msnutriamongodb.exception.NotFoundException;
import org.example.msnutriamongodb.model.Ingrediente;
import org.example.msnutriamongodb.repository.IngredienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

  public Page<GetNomeIdIngredienteDTO> buscarIngredientesCadastrados(int page) {
    int pageSize = 100;
    int pageNumber;

    if (page < 1) {
      pageNumber = 0; // se o usuário passar um número inválido, (0 ou negativo), começa da primeira página
    } else {
      pageNumber = page - 1; // ajusta para o índice que o Spring usa, já que ele começa pelo 0 e a minha paginação começa pelo 1
    }

    Pageable pageable = PageRequest.of(pageNumber, pageSize);
    Page<Ingrediente> ingredientesPage = ingredienteRepository.findAll(pageable);

    return ingredientesPage.map(ingrediente ->
            objectMapper.convertValue(ingrediente, GetNomeIdIngredienteDTO.class)
    );
  }


  public GetIngredienteDTO buscarIngredientePeloId(Integer id) {
    Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);
    GetIngredienteDTO ingredienteDTO =
        objectMapper.convertValue(ingrediente, GetIngredienteDTO.class);
    if (ingredienteDTO == null) {
      throw new NotFoundException("O ingrediente não foi encontrado.");
    }
    return ingredienteDTO;
  }

  public GetNomeIdIngredienteDTO criarIngrediente(PostIngredienteDTO ingredienteDTO) {
    Integer proximoId = ingredienteRepository.findLastIngredienteId() + 1;
    Ingrediente ingrediente = objectMapper.convertValue(ingredienteDTO, Ingrediente.class);
    boolean ingredienteJaExiste =
        ingredienteRepository.existsByNomeIngrediente(ingrediente.getNomeIngrediente());
    if (ingredienteJaExiste) {
      throw new DuplicateException("Um ingrediente já foi cadastrado com esse nome.");
    }
    ingrediente.setId(proximoId);
    ingredienteRepository.save(ingrediente);
    return objectMapper.convertValue(ingrediente, GetNomeIdIngredienteDTO.class);
  }
}
