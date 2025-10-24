package org.example.msnutriamongodb.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.example.msnutriamongodb.dto.RequestIngredienteDTO;
import org.example.msnutriamongodb.dto.ResponseIngredienteDTO;
import org.example.msnutriamongodb.dto.exceptiondto.ErrorDTO;
import org.springframework.http.ResponseEntity;

public interface IngredienteApi {

  @Operation(
      summary = "Lista todos os ingredientes cadastrados",
      description = "Retorna todos os ingredientes cadastrados no banco de dados.")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "Ingredientes retornados com sucesso",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ResponseIngredienteDTO.class))),
    @ApiResponse(responseCode = "204", description = "Nenhum ingrediente encontrado")
  })
  ResponseEntity<List<ResponseIngredienteDTO>> getAllIngredientes();

  @Operation(
      summary = "Busca um ingrediente pelo ID",
      description = "Retorna os dados do ingrediente correspondente ao ID passado.")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "Ingrediente encontrado com sucesso",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ResponseIngredienteDTO.class))),
    @ApiResponse(
        responseCode = "404",
        description = "Ingrediente não encontrado",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorDTO.class)))
  })
  ResponseEntity<ResponseIngredienteDTO> getIngredienteById(Integer id);

  @Operation(
      summary = "Cria um novo ingrediente",
      description = "Cadastra um novo ingrediente com os dados informados no corpo da requisição.")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "Ingrediente criado com sucesso",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ResponseIngredienteDTO.class))),
    @ApiResponse(
        responseCode = "400",
        description = "Dados inválidos fornecidos para o cadastro",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorDTO.class)))
  })
  ResponseEntity<ResponseIngredienteDTO> criarIngrediente(RequestIngredienteDTO ingrediente);
}
