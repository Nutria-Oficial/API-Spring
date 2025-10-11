package org.example.msnutriamongodb.dto;

import java.util.List;
import org.example.msnutriamongodb.model.TabelaAvaliacao;

public record GetTabelaEAvaliacaoDTO(
    Integer tabelaId,
    String nomeTabela,
    double quantidadeTotal,
    double porcao,
    List<GetNutrienteDTO> nutrientes,
    TabelaAvaliacao avaliacao) {}
