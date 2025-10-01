package org.example.msnutriamongodb.contract;

import org.example.msnutriamongodb.dto.RequestIngredienteDTO;
import org.example.msnutriamongodb.dto.ResponseIngredienteDTO;
import org.example.msnutriamongodb.model.Ingrediente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ingredientes")
public interface IngredienteApi {
    @GetMapping
    ResponseEntity<List<ResponseIngredienteDTO>> getAllIngredientes();

    @GetMapping("/{id}")
    ResponseEntity<ResponseIngredienteDTO> getIngredienteById(@PathVariable Integer id);

    @PostMapping
    ResponseEntity<ResponseIngredienteDTO> criarIngrediente(@RequestBody RequestIngredienteDTO ingrediente);
}
