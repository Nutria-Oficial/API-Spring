package org.example.msnutriamongodb.dto;

import org.example.msnutriamongodb.model.TabelaAvaliacao;

import java.util.List;

public record GetTabelaEAvaliacaoDTO(
        Integer tabelaId,
        String nomeTabela,
        double quantidadeTotal,
        double porcao,
        List<GetNutrienteDTO> nutrientes,
        TabelaAvaliacao avaliacao
) {
}
