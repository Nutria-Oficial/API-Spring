package org.example.msnutriamongodb.controller;

import jakarta.validation.Valid;
import org.example.msnutriamongodb.contract.TabelaApi;
import org.example.msnutriamongodb.dto.GetTabelaDTO;
import org.example.msnutriamongodb.dto.GetTabelaEAvaliacaoDTO;
import org.example.msnutriamongodb.dto.PostTabelaDTO;
import org.example.msnutriamongodb.service.TabelaProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tabelas")
public class TabelaController implements TabelaApi {
  private final TabelaProdutoService tabelaProdutoService;

  public TabelaController(TabelaProdutoService tabelaProdutoService) {
    this.tabelaProdutoService = tabelaProdutoService;
  }

  @Override
  @PostMapping("/{idUsuario}")
  public ResponseEntity<GetTabelaDTO> criarTabela(
      @PathVariable Integer idUsuario, @Valid @RequestBody PostTabelaDTO postTabelaDTO) {
    GetTabelaDTO tabelaDTO = tabelaProdutoService.criarTabela(null, postTabelaDTO, idUsuario);
    return new ResponseEntity<>(tabelaDTO, HttpStatus.OK);
  }

  @Override
  @PostMapping("/{idUsuario}/{idProduto}")
  public ResponseEntity<GetTabelaDTO> adicionarTabela(
      @PathVariable Integer idUsuario,
      @PathVariable Integer idProduto,
      @Valid @RequestBody PostTabelaDTO postTabelaDTO) {
    GetTabelaDTO tabelaDTO = tabelaProdutoService.criarTabela(idProduto, postTabelaDTO, idUsuario);
    return new ResponseEntity<>(tabelaDTO, HttpStatus.OK);
  }

  @Override
  @GetMapping("/{idTabela}")
  public ResponseEntity<GetTabelaEAvaliacaoDTO> buscarTabelaComAvaliacao(
      @PathVariable Integer idTabela) {
    GetTabelaEAvaliacaoDTO tabelaDTO = tabelaProdutoService.buscarTabelaEAvaliacao(idTabela);
    return new ResponseEntity<>(tabelaDTO, HttpStatus.OK);
  }
}
