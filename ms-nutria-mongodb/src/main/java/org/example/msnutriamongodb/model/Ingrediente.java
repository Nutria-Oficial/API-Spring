package org.example.msnutriamongodb.model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ingrediente")
public class Ingrediente {
    @Id
    @Field(name = "_id")
    private Integer id;

    @Field(name = "cNmIngrediente")
    private String nomeIngrediente;

    @Field(name = "nCaloria(kcal)")
    private double caloria;

    @Field(name = "nCarboidrato(g)")
    private double carboidrato;

    @Field(name = "nAcucar(g)")
    private double acucar;

    @Field(name = "nProteina(g)")
    private double proteina;

    @Field(name = "nGorduraTotal(g)")
    private double gorduraTotal;

    @Field(name = "nGorduraSaturada(g)")
    private double gorduraSaturada;

    @Field(name = "nSodio(mg)")
    private double sodio;

    @Field(name = "nFibra(g)")
    private double fibra;

    @Field(name = "nAgua(g)")
    private double agua;

    @Field(name = "nGorduraMonoinsaturada(g)")
    private double gorduraMonoinsaturada;

    @Field(name = "nGorduraPoliinsaturada(g)")
    private double gorduraPoliinsaturada;

    @Field(name = "nColesterol(mg)")
    private double colesterol;

    @Field(name = "nAlcool(g)")
    private double alcool;

    @Field(name = "nVitB6(mg)")
    private double vitaminaB6;

    @Field(name = "nVitB12(mcg)")
    private double vitaminaB12;

    @Field(name = "nVitC(mg)")
    private double vitaminaC;

    @Field(name = "nVitD(mcg)")
    private double vitaminaD;

    @Field(name = "nVitE(mg)")
    private double vitaminaE;

    @Field(name = "nVitK(mcg)")
    private double vitaminaK;

    @Field(name = "nTeobromina(mg)")
    private double teobromina;

    @Field(name = "nCafeina(mg)")
    private double cafeina;

    @Field(name = "nColina(mg)")
    private double colina;

    @Field(name = "nCalcio(mg)")
    private double calcio;

    @Field(name = "nFosforo(mg)")
    private double fosforo;

    @Field(name = "nMagnesio(mg)")
    private double magnesio;

    @Field(name = "nPotassio(mg)")
    private double potassio;

    @Field(name = "nFerro(mg)")
    private double ferro;

    @Field(name = "nZinco(mg)")
    private double zinco;

    @Field(name = "nCobre(mg)")
    private double cobre;

    @Field(name = "nSelenio(mcg)")
    private double selenio;

    @Field(name = "nRetinol(mcg)")
    private double retinol;

    @Field(name = "nTiamina(mg)")
    private double tiamina;

    @Field(name = "nRiboflavina(mg)")
    private double riboflavina;

    @Field(name = "nNiacina(mg)")
    private double niacina;

    @Field(name = "nFolato(mcg)")
    private double folato;

    //getters e setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNomeIngrediente(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }

    public void setCaloria(double caloria) {
        this.caloria = caloria;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public void setCarboidrato(double carboidrato) {
        this.carboidrato = carboidrato;
    }

    public void setAcucar(double acucar) {
        this.acucar = acucar;
    }

    public void setFibra(double fibra) {
        this.fibra = fibra;
    }

    public void setGorduraTotal(double gorduraTotal) {
        this.gorduraTotal = gorduraTotal;
    }

    public void setGorduraSaturada(double gorduraSaturada) {
        this.gorduraSaturada = gorduraSaturada;
    }

    public void setGorduraMonoinsaturada(double gorduraMonoinsaturada) {
        this.gorduraMonoinsaturada = gorduraMonoinsaturada;
    }

    public void setGorduraPoliinsaturada(double gorduraPoliinsaturada) {
        this.gorduraPoliinsaturada = gorduraPoliinsaturada;
    }

    public void setColesterol(double colesterol) {
        this.colesterol = colesterol;
    }

    public void setRetinol(double retinol) {
        this.retinol = retinol;
    }

    public void setTiamina(double tiamina) {
        this.tiamina = tiamina;
    }

    public void setRiboflavina(double riboflavina) {
        this.riboflavina = riboflavina;
    }

    public void setNiacina(double niacina) {
        this.niacina = niacina;
    }

    public void setVitaminaB6(double vitaminaB6) {
        this.vitaminaB6 = vitaminaB6;
    }

    public void setFolato(double folato) {
        this.folato = folato;
    }

    public void setColina(double colina) {
        this.colina = colina;
    }

    public void setVitaminaB12(double vitaminaB12) {
        this.vitaminaB12 = vitaminaB12;
    }

    public void setVitaminaC(double vitaminaC) {
        this.vitaminaC = vitaminaC;
    }

    public void setVitaminaD(double vitaminaD) {
        this.vitaminaD = vitaminaD;
    }

    public void setVitaminaE(double vitaminaE) {
        this.vitaminaE = vitaminaE;
    }

    public void setVitaminaK(double vitaminaK) {
        this.vitaminaK = vitaminaK;
    }

    public void setCalcio(double calcio) {
        this.calcio = calcio;
    }

    public void setFosforo(double fosforo) {
        this.fosforo = fosforo;
    }

    public void setMagnesio(double magnesio) {
        this.magnesio = magnesio;
    }

    public void setFerro(double ferro) {
        this.ferro = ferro;
    }

    public void setZinco(double zinco) {
        this.zinco = zinco;
    }

    public void setCobre(double cobre) {
        this.cobre = cobre;
    }

    public void setSelenio(double selenio) {
        this.selenio = selenio;
    }

    public void setPotassio(double potassio) {
        this.potassio = potassio;
    }

    public void setSodio(double sodio) {
        this.sodio = sodio;
    }

    public void setCafeina(double cafeina) {
        this.cafeina = cafeina;
    }

    public void setTeobromina(double teobromina) {
        this.teobromina = teobromina;
    }

    public void setAlcool(double alcool) {
        this.alcool = alcool;
    }

    public void setAgua(double agua) {
        this.agua = agua;
    }

    public Integer getId() {
        return id;
    }

    public String getNomeIngrediente() {
        return nomeIngrediente;
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
