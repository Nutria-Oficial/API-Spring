package org.example.msnutriamongodb.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.msnutriamongodb.dto.GetTabelaDTO;
import org.example.msnutriamongodb.dto.GetTabelaEAvaliacaoDTO;
import org.example.msnutriamongodb.dto.PostTabelaDTO;
import org.example.msnutriamongodb.dto.exceptiondto.ErrorDTO;
import org.springframework.http.ResponseEntity;

public interface TabelaApi {

  @Operation(
      summary = "Cria uma nova tabela para um produto",
      description =
          "Recebe as informações necessárias para calcular a tabela nutricional de um produto")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "Tabela adicionada com sucesso",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = GetTabelaDTO.class))),
    @ApiResponse(
        responseCode = "422",
        description = "Não foi possível adicionar a nova tabela no banco",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorDTO.class))),
    @ApiResponse(
        responseCode = "500",
        description = "Erro ao serializar os dados da tabela para JSON",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorDTO.class)))
  })
  ResponseEntity<GetTabelaDTO> criarTabela(Integer idUsuario, PostTabelaDTO postTabelaDTO);

  @Operation(
      summary = "Adiciona uma nova tabela para um produto",
      description =
          "Recebe as informações necessárias para calcular a tabela nutricional de um produto")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "Tabela adicionada com sucesso",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = GetTabelaDTO.class))),
    @ApiResponse(
        responseCode = "404",
        description = "Não foi possível encontrar o produto para adicionar a nova tabela",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorDTO.class))),
    @ApiResponse(
        responseCode = "422",
        description = "Não foi possível adicionar a nova tabela no banco",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorDTO.class))),
    @ApiResponse(
        responseCode = "500",
        description = "Erro ao serializar os dados da tabela para JSON",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorDTO.class)))
  })
  ResponseEntity<GetTabelaDTO> adicionarTabela(
      Integer idUsuario, Integer idProduto, PostTabelaDTO postTabelaDTO);

  @Operation(
      summary = "Busca uma tabela nutricional com a avaliação",
      description = "Retorna uma tabela nutricional com a avaliação feita pela IA")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "Tabela encontrada com sucesso",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = GetTabelaEAvaliacaoDTO.class))),
    @ApiResponse(
        responseCode = "404",
        description = "Não foi possível encontrar a tabela",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorDTO.class)))
  })
  ResponseEntity<GetTabelaEAvaliacaoDTO> buscarTabelaComAvaliacao(Integer idTabela);
}
