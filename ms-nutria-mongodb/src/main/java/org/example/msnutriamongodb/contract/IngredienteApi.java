package org.example.msnutriamongodb.contract;

import java.util.List;
import org.example.msnutriamongodb.dto.RequestIngredienteDTO;
import org.example.msnutriamongodb.dto.ResponseIngredienteDTO;
import org.springframework.http.ResponseEntity;

public interface IngredienteApi {
  ResponseEntity<List<ResponseIngredienteDTO>> getAllIngredientes();

  ResponseEntity<ResponseIngredienteDTO> getIngredienteById(Integer id);

  ResponseEntity<ResponseIngredienteDTO> criarIngrediente(RequestIngredienteDTO ingrediente);
}
