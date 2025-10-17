package org.example.msnutriamongodb.dto;

import java.util.Map;

public record GetComparacaoDTO(
    String nutriente, Map<String, Double> porcaoPorTabela, double valorComparacao) {}
