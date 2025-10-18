package org.example.msnutriamongodb.service;

import java.util.*;
import org.example.msnutriamongodb.dto.GetComparacaoDTO;
import org.example.msnutriamongodb.exception.NotFoundException;
import org.example.msnutriamongodb.model.Tabela;
import org.example.msnutriamongodb.repository.TabelaRepository;
import org.springframework.stereotype.Service;

@Service
public class TabelaService {
  private final TabelaRepository tabelaRepository;

  public TabelaService(TabelaRepository tabelaRepository) {
    this.tabelaRepository = tabelaRepository;
  }

  public List<GetComparacaoDTO> calcularComparacaoPorNutriente(
      Integer idTabela1, Integer idTabela2) {
    Optional<Tabela> tabela1 = tabelaRepository.findById(idTabela1);
    if (tabela1.isEmpty()) {
      throw new NotFoundException("Tabela com id " + idTabela1 + " não encontrada");
    }
    Optional<Tabela> tabela2 = tabelaRepository.findById(idTabela2);
    if (tabela2.isEmpty()) {
      throw new NotFoundException("Tabela com id " + idTabela2 + " não encontrada");
    }
    return compararPorNutriente(
        tabela1.get().getNomeTabela(),
        tabela1.get().getListaPorcao(),
        tabela2.get().getNomeTabela(),
        tabela2.get().getListaPorcao(),
        tabela1.get().getListaNutrientes());
  }

  public List<GetComparacaoDTO> compararPorNutriente(
      String nomeTabela1,
      List<Double> listaPorcao1,
      String nomeTabela2,
      List<Double> listaPorcao2,
      List<String> listaNutrientes) {
    List<String> nutrientesObrigatorios =
        List.of(
            "Valor Calórico (kcal)",
            "Carboidrato (g)",
            "Açúcar Total (g)",
            "Proteína (g)",
            "Gordura Total (g)",
            "Gordura Saturada (g)",
            "Sódio (mg)",
            "Fibra alimentar (g)");

    for (int i = listaNutrientes.size() - 1; i >= 0; i--) {
      if (!nutrientesObrigatorios.contains(listaNutrientes.get(i))) {
        listaNutrientes.remove(i);
        listaPorcao1.remove(i);
        listaPorcao2.remove(i);
      }
    }
    List<GetComparacaoDTO> comparacaoDTOS = new ArrayList<>();
    for (int i = 0; i < listaNutrientes.size(); i++) {
      Map<String, Double> tabelaMap = new HashMap<>();
      tabelaMap.put(nomeTabela1, listaPorcao1.get(i));
      tabelaMap.put(nomeTabela2, listaPorcao2.get(i));

      comparacaoDTOS.add(
          new GetComparacaoDTO(
              listaNutrientes.get(i),
              tabelaMap,
              tabelaMap.get(nomeTabela1) - tabelaMap.get(nomeTabela2)));
    }
    return comparacaoDTOS;
  }
}
