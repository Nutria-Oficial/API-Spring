package org.example.msnutriamongodb.controller;

import org.example.msnutriamongodb.contract.IngredienteApi;
import org.example.msnutriamongodb.dto.GetIngredienteDTO;
import org.example.msnutriamongodb.model.Ingrediente;
import org.example.msnutriamongodb.service.IngredienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredienteController implements IngredienteApi {
    private final IngredienteService ingredienteService;

    public IngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @Override
    public ResponseEntity<List<GetIngredienteDTO>> getAllIngredientes() {
        List<GetIngredienteDTO> getIngredienteDTO = ingredienteService.buscarIngredientesCadastrados();
        return new ResponseEntity<>(getIngredienteDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GetIngredienteDTO> getIngredienteById(Long id) {
        GetIngredienteDTO getIngredienteDTO = ingredienteService.buscarIngredientePeloId(id);
        return new ResponseEntity<>(getIngredienteDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Ingrediente> criarIngrediente(Ingrediente ingrediente) {
        ingredienteService.criarIngrediente(ingrediente);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}