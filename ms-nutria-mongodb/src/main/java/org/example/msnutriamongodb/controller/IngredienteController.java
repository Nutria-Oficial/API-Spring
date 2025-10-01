package org.example.msnutriamongodb.controller;

import org.example.msnutriamongodb.contract.IngredienteApi;
import org.example.msnutriamongodb.dto.RequestIngredienteDTO;
import org.example.msnutriamongodb.dto.ResponseIngredienteDTO;
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
    public ResponseEntity<List<ResponseIngredienteDTO>> getAllIngredientes() {
        List<ResponseIngredienteDTO> responseIngredienteDTO = ingredienteService.buscarIngredientesCadastrados();
        return new ResponseEntity<>(responseIngredienteDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseIngredienteDTO> getIngredienteById(Integer id) {
        ResponseIngredienteDTO responseIngredienteDTO = ingredienteService.buscarIngredientePeloId(id);
        return new ResponseEntity<>(responseIngredienteDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseIngredienteDTO> criarIngrediente(RequestIngredienteDTO ingrediente) {
        ResponseIngredienteDTO responseIngredienteDTO = ingredienteService.criarIngrediente(ingrediente);
        return new ResponseEntity<>(responseIngredienteDTO, HttpStatus.OK);
    }
}