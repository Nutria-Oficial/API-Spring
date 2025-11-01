package org.example.msnutriamongodb.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.example.msnutriamongodb.contract.IngredienteApi;
import org.example.msnutriamongodb.dto.GetIngredienteDTO;
import org.example.msnutriamongodb.dto.PostIngredienteDTO;
import org.example.msnutriamongodb.dto.GetNomeIdIngredienteDTO;
import org.example.msnutriamongodb.service.IngredienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController implements IngredienteApi {
  private final IngredienteService ingredienteService;

  public IngredienteController(IngredienteService ingredienteService) {
    this.ingredienteService = ingredienteService;
  }

  @Override
  @GetMapping
  public ResponseEntity<List<GetNomeIdIngredienteDTO>> getAllIngredientes() {
    List<GetNomeIdIngredienteDTO> responseIngredienteDTO =
        ingredienteService.buscarIngredientesCadastrados();
    return new ResponseEntity<>(responseIngredienteDTO, HttpStatus.OK);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<GetIngredienteDTO> getIngredienteById(@PathVariable Integer id) {
    GetIngredienteDTO responseIngredienteDTO = ingredienteService.buscarIngredientePeloId(id);
    return new ResponseEntity<>(responseIngredienteDTO, HttpStatus.OK);
  }

  @Override
  @PostMapping
  public ResponseEntity<GetNomeIdIngredienteDTO> criarIngrediente(
      @Valid @RequestBody PostIngredienteDTO ingrediente) {
    GetNomeIdIngredienteDTO responseIngredienteDTO =
        ingredienteService.criarIngrediente(ingrediente);
    return new ResponseEntity<>(responseIngredienteDTO, HttpStatus.OK);
  }
}
