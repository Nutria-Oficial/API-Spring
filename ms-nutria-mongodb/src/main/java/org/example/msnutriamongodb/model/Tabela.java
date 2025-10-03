package org.example.msnutriamongodb.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "tabela")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tabela {
    @Id
    @Field(name= "_id")
    private Integer id;

    @Field(name= "nCdProduto")
    private Long idProduto;

    @Field(name= "cNmTabela")
    private String nomeTabela;

    @Field(name= "nTotal")
    private double quantidadeTotal;

    @Field(name= "nPorcao")
    private double porcao;

    @Field(name= "lIngredientes")
    private List<ItemIngrediente> listaIngredientes = new ArrayList<>();

    @Field(name= "lNutrientes")
    private List<String> listaNutrientes = new ArrayList<>();

    @Field(name= "lTotal")
    private List<Double> listaTotal = new ArrayList<>();

    @Field(name= "lPorcao")
    private List<Double> listaPorcao = new ArrayList<>();

    @Field(name= "lVd")
    private List<Double> listaValorDiario = new ArrayList<>();

    @Field(name= "jAvaliacao")
    private TabelaAvaliacao avaliacao;

}
