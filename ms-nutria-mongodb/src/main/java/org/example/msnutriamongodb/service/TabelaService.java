package org.example.msnutriamongodb.service;

import org.example.msnutriamongodb.repository.TabelaRepository;
import org.springframework.stereotype.Service;

@Service
public class TabelaService {
    private final TabelaRepository tabelaRepository;

    public TabelaService(TabelaRepository tabelaRepository) {
        this.tabelaRepository = tabelaRepository;
    }
}
