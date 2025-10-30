package org.example.msnutriamongodb.dto;

import java.util.Map;

public class GetComparacaoDTO {
    String nutriente;
    Map<String, Double> porcaoPorTabela;
    double valorComparacao;

    public GetComparacaoDTO() {
    }

    public GetComparacaoDTO(String nutriente, Map<String, Double> porcaoPorTabela, double valorComparacao) {
        this.nutriente = nutriente;
        this.porcaoPorTabela = porcaoPorTabela;
        this.valorComparacao = valorComparacao;
    }

    public String getNutriente() {
        return nutriente;
    }

    public void setNutriente(String nutriente) {
        this.nutriente = nutriente;
    }

    public Map<String, Double> getPorcaoPorTabela() {
        return porcaoPorTabela;
    }

    public void setPorcaoPorTabela(Map<String, Double> porcaoPorTabela) {
        this.porcaoPorTabela = porcaoPorTabela;
    }

    public double getValorComparacao() {
        return valorComparacao;
    }

    public void setValorComparacao(double valorComparacao) {
        this.valorComparacao = valorComparacao;
    }
}
