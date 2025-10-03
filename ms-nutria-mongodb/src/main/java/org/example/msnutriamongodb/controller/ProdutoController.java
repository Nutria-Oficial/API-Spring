package org.example.msnutriamongodb.controller;

import org.example.msnutriamongodb.contract.ProdutoApi;
import org.example.msnutriamongodb.dto.GetProdutoDTO;
import org.example.msnutriamongodb.dto.GetTabelaDTO;
import org.example.msnutriamongodb.service.TabelaProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoController implements ProdutoApi {
    private final TabelaProdutoService tabelaProdutoService;

    public ProdutoController(TabelaProdutoService tabelaProdutoService) {
        this.tabelaProdutoService = tabelaProdutoService;
    }

    @Override
    public ResponseEntity<List<GetProdutoDTO>> buscarHistoricoPorUsuario(Integer idUsuario){
        List<GetProdutoDTO> produtoList = tabelaProdutoService.buscarHistoricoPorUsuario(idUsuario);
        if (produtoList.isEmpty()){
            return new ResponseEntity<>(produtoList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(produtoList, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<List<GetTabelaDTO>> buscarTabelasPorProduto(Integer idProduto){
        List<GetTabelaDTO> produtoList = tabelaProdutoService.buscarTabelasPorProduto(idProduto);
        return new ResponseEntity<>(produtoList, HttpStatus.OK);
    }

}
