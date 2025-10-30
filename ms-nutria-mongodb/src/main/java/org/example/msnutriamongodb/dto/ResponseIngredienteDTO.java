package org.example.msnutriamongodb.dto;

public class ResponseIngredienteDTO {
    Integer id;
    String nomeIngrediente;

    public ResponseIngredienteDTO() {
    }

    public ResponseIngredienteDTO(Integer id, String nomeIngrediente) {
        this.id = id;
        this.nomeIngrediente = nomeIngrediente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeIngrediente() {
        return nomeIngrediente;
    }

    public void setNomeIngrediente(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }
}