package org.example.msnutriamongodb.controller;

import org.example.msnutriamongodb.contract.ProdutoApi;
import org.example.msnutriamongodb.service.ProdutoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController implements ProdutoApi {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
}
