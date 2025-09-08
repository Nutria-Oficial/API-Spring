package org.example.msnutriamongodb.dto;

import java.util.List;

public record GetTabelaDTO(
        Long tabelaId,
        String nomeTabela,
        double quantidadeTotal,
        double porcao,
        List<GetNutrienteDTO> nutrientes

) {
}
