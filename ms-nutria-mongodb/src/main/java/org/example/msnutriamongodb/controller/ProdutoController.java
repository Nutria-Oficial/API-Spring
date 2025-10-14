package org.example.msnutriamongodb.controller;

import java.util.List;
import org.example.msnutriamongodb.contract.ProdutoApi;
import org.example.msnutriamongodb.dto.GetProdutoDTO;
import org.example.msnutriamongodb.dto.GetTabelaDTO;
import org.example.msnutriamongodb.service.TabelaProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController implements ProdutoApi {
  private final TabelaProdutoService tabelaProdutoService;

  public ProdutoController(TabelaProdutoService tabelaProdutoService) {
    this.tabelaProdutoService = tabelaProdutoService;
  }

  @Override
  @GetMapping(value = "/usuario/{idUsuario}")
  public ResponseEntity<List<GetProdutoDTO>> buscarHistoricoPorUsuario(
      @PathVariable Integer idUsuario, @RequestParam boolean filtrar) {
    List<GetProdutoDTO> produtoList =
        tabelaProdutoService.buscarHistoricoPorUsuario(idUsuario, filtrar);
    if (produtoList.isEmpty()) {
      return new ResponseEntity<>(produtoList, HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(produtoList, HttpStatus.OK);
  }

  @Override
  @GetMapping(value = "/{idProduto}")
  public ResponseEntity<List<GetTabelaDTO>> buscarTabelasPorProduto(
      @PathVariable Integer idProduto) {
    List<GetTabelaDTO> produtoList = tabelaProdutoService.buscarTabelasPorProduto(idProduto);
    return new ResponseEntity<>(produtoList, HttpStatus.OK);
  }
}
