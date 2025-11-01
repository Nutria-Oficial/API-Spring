package org.example.msnutriamongodb.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;

import org.example.msnutriamongodb.dto.GetIngredienteDTO;
import org.example.msnutriamongodb.dto.PostIngredienteDTO;
import org.example.msnutriamongodb.dto.GetNomeIdIngredienteDTO;
import org.example.msnutriamongodb.dto.exceptiondto.ErrorDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IngredienteApi {

  @Operation(
      summary = "Lista os ingredientes cadastrados, paginando os resultados",
      description = "Retorna os ingredientes cadastrados no banco de dados, paginando os resultados. Default da página = 1")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "Ingredientes retornados com sucesso",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = GetNomeIdIngredienteDTO.class))),
    @ApiResponse(responseCode = "204", description = "Nenhum ingrediente encontrado")
  })
  ResponseEntity<Page<GetNomeIdIngredienteDTO>> getAllIngredientes(@RequestParam(defaultValue = "1") int pagina);

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
                schema = @Schema(implementation = GetNomeIdIngredienteDTO.class))),
    @ApiResponse(
        responseCode = "404",
        description = "Ingrediente não encontrado",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorDTO.class)))
  })
  ResponseEntity<GetIngredienteDTO> getIngredienteById(Integer id);

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
                schema = @Schema(implementation = GetNomeIdIngredienteDTO.class))),
    @ApiResponse(
        responseCode = "400",
        description = "Dados inválidos fornecidos para o cadastro",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorDTO.class)))
  })
  ResponseEntity<GetNomeIdIngredienteDTO> criarIngrediente(PostIngredienteDTO ingrediente);
}
