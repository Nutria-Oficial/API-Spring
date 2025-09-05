package org.example.msnutriamongodb.controller;

import org.example.msnutriamongodb.contract.IngredienteApi;
import org.example.msnutriamongodb.service.IngredienteService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredienteController implements IngredienteApi {
    private final IngredienteService ingredienteService;

    public IngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }
}
