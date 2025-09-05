package org.example.msnutriamongodb.controller;

import org.example.msnutriamongodb.contract.TabelaApi;
import org.example.msnutriamongodb.service.TabelaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TabelaController implements TabelaApi {
    private final TabelaService tabelaService;

    public TabelaController(TabelaService tabelaService) {
        this.tabelaService = tabelaService;
    }
}
