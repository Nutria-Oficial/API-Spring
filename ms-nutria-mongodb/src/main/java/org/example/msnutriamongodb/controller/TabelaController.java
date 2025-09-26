package org.example.msnutriamongodb.controller;

import org.example.msnutriamongodb.contract.TabelaApi;
import org.example.msnutriamongodb.dto.GetTabelaDTO;
import org.example.msnutriamongodb.dto.PostTabelaDTO;
import org.example.msnutriamongodb.service.TabelaProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TabelaController implements TabelaApi {
    private final TabelaProdutoService tabelaProdutoService;

    public TabelaController(TabelaProdutoService tabelaProdutoService) {
        this.tabelaProdutoService = tabelaProdutoService;
    }

    @Override
    public ResponseEntity<GetTabelaDTO> criarTabela(Long idUsuario, PostTabelaDTO postTabelaDTO) {
        GetTabelaDTO tabelaDTO = tabelaProdutoService.criarTabela(postTabelaDTO,idUsuario);
        return new ResponseEntity<>(tabelaDTO, HttpStatus.OK);

    }
}
