package org.example.msnutriamongodb.controller;

import org.example.msnutriamongodb.contract.ProdutoApi;
import org.example.msnutriamongodb.dto.GetProdutoDTO;
import org.example.msnutriamongodb.dto.GetTabelaDTO;
import org.example.msnutriamongodb.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoController implements ProdutoApi {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Override
    public ResponseEntity<List<GetProdutoDTO>> buscarHistoricoPorUsuario(Long idUsuario){
        List<GetProdutoDTO> produtoList = produtoService.buscarHistoricoPorUsuario(idUsuario);
        if (produtoList.isEmpty()){
            return new ResponseEntity<>(produtoList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(produtoList, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<List<GetTabelaDTO>> buscarTabelasPorProduto(Long idProduto){
        List<GetTabelaDTO> produtoList = produtoService.buscarTabelasPorProduto(idProduto);
        return new ResponseEntity<>(produtoList, HttpStatus.OK);
    }

}
