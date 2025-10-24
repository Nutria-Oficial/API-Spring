package org.example.msnutriamongodb.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.msnutriamongodb.dto.exceptiondto.ErrorDTO;
import org.springframework.http.ResponseEntity;

public interface ChatApi {
  @Operation(
      summary = "Busca a resposta da IA para um chat",
      description =
          "Busca no banco de dados o chat correspondente ao ID e retorna a resposta gerada pela IA.")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "Resposta da IA retornada com sucesso",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = String.class))),
    @ApiResponse(
        responseCode = "404",
        description = "Chat não encontrado",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorDTO.class)))
  })
  ResponseEntity<String> pegarRespostaIA(Integer id);

  @Operation(
      summary = "Lista todas as mensagens do chat",
      description =
          "Retorna todas as mensagens do chat com o ID passado em formato de matriz, onde cada linha representa um par de mensagens (usuário e IA).")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "Mensagens do chat retornadas com sucesso",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = String[][].class))),
    @ApiResponse(
        responseCode = "404",
        description = "Chat não encontrado",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorDTO.class)))
  })
  ResponseEntity<String[][]> listarChat(Integer id);

  @Operation(
      summary = "Limpa o histórico de um chat",
      description = "Remove todas as mensagens do chat com o ID passado.")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Histórico do chat limpo com sucesso"),
    @ApiResponse(
        responseCode = "404",
        description = "Chat não encontrado",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorDTO.class)))
  })
  ResponseEntity<Void> limparChat(Integer id);
}
