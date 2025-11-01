package org.example.msnutriamongodb.controller;

import jakarta.validation.Valid;
import org.example.msnutriamongodb.contract.IngredienteApi;
import org.example.msnutriamongodb.dto.GetIngredienteDTO;
import org.example.msnutriamongodb.dto.PostIngredienteDTO;
import org.example.msnutriamongodb.dto.GetNomeIdIngredienteDTO;
import org.example.msnutriamongodb.service.IngredienteService;
import org.springframework.data.domain.Page;
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
  public ResponseEntity<Page<GetNomeIdIngredienteDTO>> getAllIngredientes(
          @RequestParam(defaultValue = "1") int pagina
  ) {
    Page<GetNomeIdIngredienteDTO> responseIngredienteDTO =
            ingredienteService.buscarIngredientesCadastrados(pagina);

    return ResponseEntity.ok(responseIngredienteDTO);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<GetIngredienteDTO> getIngredienteById(@PathVariable Integer id) {
    GetIngredienteDTO responseIngredienteDTO = ingredienteService.buscarIngredientePeloId(id);
    return ResponseEntity.ok(responseIngredienteDTO);
  }

  @Override
  @PostMapping
  public ResponseEntity<GetNomeIdIngredienteDTO> criarIngrediente(
      @Valid @RequestBody PostIngredienteDTO ingrediente) {
    GetNomeIdIngredienteDTO responseIngredienteDTO =
        ingredienteService.criarIngrediente(ingrediente);
    return ResponseEntity.ok(responseIngredienteDTO);
  }
}
