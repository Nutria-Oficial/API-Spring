package org.example.msnutriamongodb.contract;

import org.example.msnutriamongodb.dto.RequestIngredienteDTO;
import org.example.msnutriamongodb.dto.ResponseIngredienteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IngredienteApi {
    ResponseEntity<List<ResponseIngredienteDTO>> getAllIngredientes();

    ResponseEntity<ResponseIngredienteDTO> getIngredienteById(Integer id);

    ResponseEntity<ResponseIngredienteDTO> criarIngrediente(RequestIngredienteDTO ingrediente);
}
