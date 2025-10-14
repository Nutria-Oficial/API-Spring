package org.example.msnutriamongodb.controller;

import jakarta.validation.Valid;
import org.example.msnutriamongodb.contract.IngredienteApi;
import org.example.msnutriamongodb.dto.RequestIngredienteDTO;
import org.example.msnutriamongodb.dto.ResponseIngredienteDTO;
import org.example.msnutriamongodb.service.IngredienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController implements IngredienteApi {
    private final IngredienteService ingredienteService;

    public IngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ResponseIngredienteDTO>> getAllIngredientes() {
        List<ResponseIngredienteDTO> responseIngredienteDTO = ingredienteService.buscarIngredientesCadastrados();
        return new ResponseEntity<>(responseIngredienteDTO, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ResponseIngredienteDTO> getIngredienteById(@PathVariable Integer id) {
        ResponseIngredienteDTO responseIngredienteDTO = ingredienteService.buscarIngredientePeloId(id);
        return new ResponseEntity<>(responseIngredienteDTO, HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<ResponseIngredienteDTO> criarIngrediente(@Valid @RequestBody RequestIngredienteDTO ingrediente) {
        ResponseIngredienteDTO responseIngredienteDTO = ingredienteService.criarIngrediente(ingrediente);
        return new ResponseEntity<>(responseIngredienteDTO, HttpStatus.OK);
    }
}