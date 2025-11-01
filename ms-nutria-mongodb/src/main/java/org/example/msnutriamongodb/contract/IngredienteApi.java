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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface IngredienteApi {

  @Operation(
      summary = "Lista os ingredientes cadastrados, paginando os resultados",
      description = "Retorna os ingredientes cadastrados no banco de dados, paginando os resultados, com 50 ingredientes por página. Default da página = 1")
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

    @Operation(
            summary = "Busca um ingrediente com o nome que foi passado",
            description = "Busca um ingrediente no banco, exatamente igual ao nome que foi passado")
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
                    description = "Nenhum ingrediente encontrado",
                    content =
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class)))
    })
    @GetMapping("/nomeExato/{nome}")
    ResponseEntity<List<GetNomeIdIngredienteDTO>> buscarPorNomeExato(@PathVariable String nome);

    @Operation(
            summary = "Busca os ingredientes que começam com o nome que foi passado",
            description = "Busca os ingredientes no banco, que começam exatamente com o começo do nome que foi passado")
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
                    description = "Nenhum ingrediente encontrado",
                    content =
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class)))
    })
    @GetMapping("/nomeParcial/{nome}")
    ResponseEntity<List<GetNomeIdIngredienteDTO>> buscarPorInicioDoNome(@PathVariable String nome);
}
