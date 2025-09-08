package org.example.msnutriamongodb.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.msnutriamongodb.dto.GetProdutoDTO;
import org.example.msnutriamongodb.dto.GetTabelaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/produtos")
public interface ProdutoApi {

    @GetMapping(value = "/usuario/{idUsuario}")
    ResponseEntity<List<GetProdutoDTO>> buscarHistoricoPorUsuario(@PathVariable Long idUsuario);

    @GetMapping(value = "/{idProduto}")
    ResponseEntity<List<GetTabelaDTO>> buscarTabelasPorProduto(@PathVariable Long idProduto);
}
