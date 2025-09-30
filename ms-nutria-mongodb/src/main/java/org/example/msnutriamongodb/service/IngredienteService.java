package org.example.msnutriamongodb.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.msnutriamongodb.dto.GetIngredienteDTO;
import org.example.msnutriamongodb.exception.DuplicateException;
import org.example.msnutriamongodb.exception.NotFoundException;
import org.example.msnutriamongodb.model.Ingrediente;
import org.example.msnutriamongodb.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {
    private final IngredienteRepository ingredienteRepository;
    private final ObjectMapper objectMapper;

    public IngredienteService(IngredienteRepository ingredienteRepository, ObjectMapper objectMapper) {
        this.ingredienteRepository = ingredienteRepository;
        this.objectMapper = objectMapper;
    }

    public List<GetIngredienteDTO> buscarIngredientesCadastrados(){
        return ingredienteRepository.findAll()
                .stream()
                .map(ingrediente -> objectMapper.convertValue(ingrediente, GetIngredienteDTO.class))
                .toList();
    }
    public GetIngredienteDTO buscarIngredientePeloId(Long id){
        Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);
        GetIngredienteDTO ingredienteDTO = objectMapper.convertValue(ingrediente, GetIngredienteDTO.class);
        if (ingredienteDTO == null){
            throw new NotFoundException("O ingrediente não foi encontrado.");
        }
        return ingredienteDTO;
    }

    public Ingrediente criarIngrediente(Ingrediente ingrediente){
//        GetIngredienteDTO dto = objectMapper.convertValue(ingrediente, GetIngredienteDTO.class);
        boolean ingredienteJaExiste = ingredienteRepository.existsByNomeIngrediente(ingrediente.getNomeIngrediente());
        if (ingredienteJaExiste) {
            throw new DuplicateException("Um ingrediente já foi cadastrado com esse nome.");
        }
        return ingredienteRepository.save(ingrediente);
    }
}