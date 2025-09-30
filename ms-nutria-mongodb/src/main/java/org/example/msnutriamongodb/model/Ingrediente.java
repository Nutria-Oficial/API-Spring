package org.example.msnutriamongodb.model;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ingrediente")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
//    colocar a anotação notblank
    @Id
    @Field(name= "_id")
    private Long id;

    @Field(name= "cNmIngrediente")
    private String nomeIngrediente;

    @Field(name= "cCategoria")
    private String categoria;

    @Field(name= "nCaloria(kcal)")
    private double caloria;

    @Field(name= "nProteina(g)")
    private double proteina;

    @Field(name= "nCarboidrato(g)")
    private double carboidrato;

    @Field(name= "nAcucar(g)")
    private double acucar;

    @Field(name= "nFibra(g)")
    private double fibra;

    @Field(name= "nGorduraTotal(g)")
    private double gorduraTotal;

    @Field(name= "nGorduraSaturada(g)")
    private double gorduraSaturada;

    @Field(name= "nGorduraMonoinsaturada(g)")
    private double gorduraMonoinsaturada;

    @Field(name= "nGorduraPoliinsaturada(g)")
    private double gorduraPoliinsaturada;

    @Field(name= "nColesterol(mg)")
    private double colesterol;

    @Field(name= "nRetinol(mcg)")
    private double retinol;

    @Field(name= "nTiamina(mg)")
    private double tiamina;

    @Field(name= "nRiboflavina(mg)")
    private double riboflavina;

    @Field(name= "nNiacina(mg)")
    private double niacina;

    @Field(name= "nVitB6(mg)")
    private double vitaminaB6;

    @Field(name= "nFolato(mcg)")
    private double folato;

    @Field(name= "nColina(mg)")
    private double colina;

    @Field(name= "nVitB12(mcg)")
    private double vitaminaB12;

    @Field(name= "nVitC(mg)")
    private double vitaminaC;

    @Field(name= "nVitD(mcg)")
    private double vitaminaD;

    @Field(name= "nVitE(mg)")
    private double vitaminaE;

    @Field(name= "nVitK(mcg)")
    private double vitaminaK;

    @Field(name= "nCalcio(mg)")
    private double calcio;

    @Field(name= "nFosforo(mg)")
    private double fosforo;

    @Field(name= "nMagnesio(mg)")
    private double magnesio;

    @Field(name= "nFerro(mg)")
    private double ferro;

    @Field(name= "nZinco(mg)")
    private double zinco;

    @Field(name= "nCobre(mg)")
    private double cobre;

    @Field(name= "nSelenio(mcg)")
    private double selenio;

    @Field(name= "nPotassio(mg)")
    private double potassio;

    @Field(name= "nSodio(mg)")
    private double sodio;

    @Field(name= "nCafeina(mg)")
    private double cafeina;

    @Field(name= "nTeobromina(mg)")
    private double teobromina;

    @Field(name= "nAlcool(g)")
    private double alcool;

    @Field(name= "nAgua(g)")
    private double agua;

    //teste pois o lombok nao ta indo
    public Long getId() {
        return id;
    }

    public String getNomeIngrediente() {
        return nomeIngrediente;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getCaloria() {
        return caloria;
    }

    public double getProteina() {
        return proteina;
    }

    public double getCarboidrato() {
        return carboidrato;
    }

    public double getAcucar() {
        return acucar;
    }

    public double getFibra() {
        return fibra;
    }

    public double getGorduraTotal() {
        return gorduraTotal;
    }

    public double getGorduraSaturada() {
        return gorduraSaturada;
    }

    public double getGorduraMonoinsaturada() {
        return gorduraMonoinsaturada;
    }

    public double getGorduraPoliinsaturada() {
        return gorduraPoliinsaturada;
    }

    public double getColesterol() {
        return colesterol;
    }

    public double getRetinol() {
        return retinol;
    }

    public double getTiamina() {
        return tiamina;
    }

    public double getRiboflavina() {
        return riboflavina;
    }

    public double getNiacina() {
        return niacina;
    }

    public double getVitaminaB6() {
        return vitaminaB6;
    }

    public double getFolato() {
        return folato;
    }

    public double getColina() {
        return colina;
    }

    public double getVitaminaB12() {
        return vitaminaB12;
    }

    public double getVitaminaC() {
        return vitaminaC;
    }

    public double getVitaminaD() {
        return vitaminaD;
    }

    public double getVitaminaE() {
        return vitaminaE;
    }

    public double getVitaminaK() {
        return vitaminaK;
    }

    public double getCalcio() {
        return calcio;
    }

    public double getFosforo() {
        return fosforo;
    }

    public double getMagnesio() {
        return magnesio;
    }

    public double getFerro() {
        return ferro;
    }

    public double getZinco() {
        return zinco;
    }

    public double getCobre() {
        return cobre;
    }

    public double getSelenio() {
        return selenio;
    }

    public double getPotassio() {
        return potassio;
    }

    public double getSodio() {
        return sodio;
    }

    public double getCafeina() {
        return cafeina;
    }

    public double getTeobromina() {
        return teobromina;
    }

    public double getAlcool() {
        return alcool;
    }

    public double getAgua() {
        return agua;
    }
}
