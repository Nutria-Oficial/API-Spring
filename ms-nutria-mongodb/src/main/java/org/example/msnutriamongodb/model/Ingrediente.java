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
  private Double caloria;

  @Field(name = "nCarboidrato(g)")
  private Double carboidrato;

  @Field(name = "nAcucar(g)")
  private Double acucar;

  @Field(name = "nProteina(g)")
  private Double proteina;

  @Field(name = "nGorduraTotal(g)")
  private Double gorduraTotal;

  @Field(name = "nGorduraSaturada(g)")
  private Double gorduraSaturada;

  @Field(name = "nSodio(mg)")
  private Double sodio;

  @Field(name = "nFibra(g)")
  private Double fibra;

  @Field(name = "nAgua(g)")
  private Double agua;

  @Field(name = "nGorduraMonoinsaturada(g)")
  private Double gorduraMonoinsaturada;

  @Field(name = "nGorduraPoliinsaturada(g)")
  private Double gorduraPoliinsaturada;

  @Field(name = "nColesterol(mg)")
  private Double colesterol;

  @Field(name = "nAlcool(g)")
  private Double alcool;

  @Field(name = "nVitB6(mg)")
  private Double vitaminaB6;

  @Field(name = "nVitB12(mcg)")
  private Double vitaminaB12;

  @Field(name = "nVitC(mg)")
  private Double vitaminaC;

  @Field(name = "nVitD(mcg)")
  private Double vitaminaD;

  @Field(name = "nVitE(mg)")
  private Double vitaminaE;

  @Field(name = "nVitK(mcg)")
  private Double vitaminaK;

  @Field(name = "nTeobromina(mg)")
  private Double teobromina;

  @Field(name = "nCafeina(mg)")
  private Double cafeina;

  @Field(name = "nColina(mg)")
  private Double colina;

  @Field(name = "nCalcio(mg)")
  private Double calcio;

  @Field(name = "nFosforo(mg)")
  private Double fosforo;

  @Field(name = "nMagnesio(mg)")
  private Double magnesio;

  @Field(name = "nPotassio(mg)")
  private Double potassio;

  @Field(name = "nFerro(mg)")
  private Double ferro;

  @Field(name = "nZinco(mg)")
  private Double zinco;

  @Field(name = "nCobre(mg)")
  private Double cobre;

  @Field(name = "nSelenio(mcg)")
  private Double selenio;

  @Field(name = "nRetinol(mcg)")
  private Double retinol;

  @Field(name = "nTiamina(mg)")
  private Double tiamina;

  @Field(name = "nRiboflavina(mg)")
  private Double riboflavina;

  @Field(name = "nNiacina(mg)")
  private Double niacina;

  @Field(name = "nFolato(mcg)")
  private Double folato;

  // getters e setters

  public void setId(Integer id) {
    this.id = id;
  }

  public void setNomeIngrediente(String nomeIngrediente) {
    this.nomeIngrediente = nomeIngrediente;
  }

  public void setCaloria(Double caloria) {
    this.caloria = caloria;
  }

  public void setProteina(Double proteina) {
    this.proteina = proteina;
  }

  public void setCarboidrato(Double carboidrato) {
    this.carboidrato = carboidrato;
  }

  public void setAcucar(Double acucar) {
    this.acucar = acucar;
  }

  public void setFibra(Double fibra) {
    this.fibra = fibra;
  }

  public void setGorduraTotal(Double gorduraTotal) {
    this.gorduraTotal = gorduraTotal;
  }

  public void setGorduraSaturada(Double gorduraSaturada) {
    this.gorduraSaturada = gorduraSaturada;
  }

  public void setGorduraMonoinsaturada(Double gorduraMonoinsaturada) {
    this.gorduraMonoinsaturada = gorduraMonoinsaturada;
  }

  public void setGorduraPoliinsaturada(Double gorduraPoliinsaturada) {
    this.gorduraPoliinsaturada = gorduraPoliinsaturada;
  }

  public void setColesterol(Double colesterol) {
    this.colesterol = colesterol;
  }

  public void setRetinol(Double retinol) {
    this.retinol = retinol;
  }

  public void setTiamina(Double tiamina) {
    this.tiamina = tiamina;
  }

  public void setRiboflavina(Double riboflavina) {
    this.riboflavina = riboflavina;
  }

  public void setNiacina(Double niacina) {
    this.niacina = niacina;
  }

  public void setVitaminaB6(Double vitaminaB6) {
    this.vitaminaB6 = vitaminaB6;
  }

  public void setFolato(Double folato) {
    this.folato = folato;
  }

  public void setColina(Double colina) {
    this.colina = colina;
  }

  public void setVitaminaB12(Double vitaminaB12) {
    this.vitaminaB12 = vitaminaB12;
  }

  public void setVitaminaC(Double vitaminaC) {
    this.vitaminaC = vitaminaC;
  }

  public void setVitaminaD(Double vitaminaD) {
    this.vitaminaD = vitaminaD;
  }

  public void setVitaminaE(Double vitaminaE) {
    this.vitaminaE = vitaminaE;
  }

  public void setVitaminaK(Double vitaminaK) {
    this.vitaminaK = vitaminaK;
  }

  public void setCalcio(Double calcio) {
    this.calcio = calcio;
  }

  public void setFosforo(Double fosforo) {
    this.fosforo = fosforo;
  }

  public void setMagnesio(Double magnesio) {
    this.magnesio = magnesio;
  }

  public void setFerro(Double ferro) {
    this.ferro = ferro;
  }

  public void setZinco(Double zinco) {
    this.zinco = zinco;
  }

  public void setCobre(Double cobre) {
    this.cobre = cobre;
  }

  public void setSelenio(Double selenio) {
    this.selenio = selenio;
  }

  public void setPotassio(Double potassio) {
    this.potassio = potassio;
  }

  public void setSodio(Double sodio) {
    this.sodio = sodio;
  }

  public void setCafeina(Double cafeina) {
    this.cafeina = cafeina;
  }

  public void setTeobromina(Double teobromina) {
    this.teobromina = teobromina;
  }

  public void setAlcool(Double alcool) {
    this.alcool = alcool;
  }

  public void setAgua(Double agua) {
    this.agua = agua;
  }

  public Integer getId() {
    return id;
  }

  public String getNomeIngrediente() {
    return nomeIngrediente;
  }

  public Double getCaloria() {
    return caloria;
  }

  public Double getProteina() {
    return proteina;
  }

  public Double getCarboidrato() {
    return carboidrato;
  }

  public Double getAcucar() {
    return acucar;
  }

  public Double getFibra() {
    return fibra;
  }

  public Double getGorduraTotal() {
    return gorduraTotal;
  }

  public Double getGorduraSaturada() {
    return gorduraSaturada;
  }

  public Double getGorduraMonoinsaturada() {
    return gorduraMonoinsaturada;
  }

  public Double getGorduraPoliinsaturada() {
    return gorduraPoliinsaturada;
  }

  public Double getColesterol() {
    return colesterol;
  }

  public Double getRetinol() {
    return retinol;
  }

  public Double getTiamina() {
    return tiamina;
  }

  public Double getRiboflavina() {
    return riboflavina;
  }

  public Double getNiacina() {
    return niacina;
  }

  public Double getVitaminaB6() {
    return vitaminaB6;
  }

  public Double getFolato() {
    return folato;
  }

  public Double getColina() {
    return colina;
  }

  public Double getVitaminaB12() {
    return vitaminaB12;
  }

  public Double getVitaminaC() {
    return vitaminaC;
  }

  public Double getVitaminaD() {
    return vitaminaD;
  }

  public Double getVitaminaE() {
    return vitaminaE;
  }

  public Double getVitaminaK() {
    return vitaminaK;
  }

  public Double getCalcio() {
    return calcio;
  }

  public Double getFosforo() {
    return fosforo;
  }

  public Double getMagnesio() {
    return magnesio;
  }

  public Double getFerro() {
    return ferro;
  }

  public Double getZinco() {
    return zinco;
  }

  public Double getCobre() {
    return cobre;
  }

  public Double getSelenio() {
    return selenio;
  }

  public Double getPotassio() {
    return potassio;
  }

  public Double getSodio() {
    return sodio;
  }

  public Double getCafeina() {
    return cafeina;
  }

  public Double getTeobromina() {
    return teobromina;
  }

  public Double getAlcool() {
    return alcool;
  }

  public Double getAgua() {
    return agua;
  }
}
