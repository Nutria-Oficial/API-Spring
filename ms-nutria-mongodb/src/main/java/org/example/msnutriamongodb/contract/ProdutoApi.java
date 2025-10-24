package org.example.msnutriamongodb.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.example.msnutriamongodb.dto.GetProdutoDTO;
import org.example.msnutriamongodb.dto.GetTabelaEAvaliacaoDTO;
import org.example.msnutriamongodb.dto.exceptiondto.ErrorDTO;
import org.springframework.http.ResponseEntity;

public interface ProdutoApi {
  @Operation(
      summary = "Busca o histórico de produtos criados",
      description = "Retorna todos os produtos criados por um usuário")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "Histórico retornado com sucesso",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = GetProdutoDTO.class))),
    @ApiResponse(responseCode = "204", description = "Nenhum produto foi encontrado")
  })
  ResponseEntity<List<GetProdutoDTO>> buscarHistoricoPorUsuario(Integer idUsuario, boolean filtrar);

  @Operation(
      summary = "Busca as tabelas de um produto",
      description = "Retorna todos as tabelas adicionadas para um produto")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "Tabelas retornadas com sucesso",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = GetTabelaEAvaliacaoDTO.class))),
    @ApiResponse(
        responseCode = "404",
        description = "Produto não foi encontrado",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorDTO.class)))
  })
  ResponseEntity<List<GetTabelaEAvaliacaoDTO>> buscarTabelasPorProduto(Integer idProduto);
}
