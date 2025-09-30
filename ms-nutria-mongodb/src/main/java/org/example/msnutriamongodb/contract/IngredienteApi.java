package org.example.msnutriamongodb.contract;

import org.example.msnutriamongodb.dto.GetIngredienteDTO;
import org.example.msnutriamongodb.model.Ingrediente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ingredientes")
public interface IngredienteApi {
    @GetMapping
    ResponseEntity<List<GetIngredienteDTO>> getAllIngredientes();

    @GetMapping("/{id}")
    ResponseEntity<GetIngredienteDTO> getIngredienteById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<Ingrediente> criarIngrediente(@RequestBody Ingrediente ingrediente);
}
