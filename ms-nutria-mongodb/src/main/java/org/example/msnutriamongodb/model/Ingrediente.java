package org.example.msnutriamongodb.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ingrediente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
  @Id
  @Field(name = "_id")
  private Long id;

  @Field(name = "cNmIngrediente")
  private String nomeIngrediente;

  @Field(name = "cCategoria")
  private String categoria;

  @Field(name = "nCaloria(kcal)")
  private double caloria;

  @Field(name = "nProteina(g)")
  private double proteina;

  @Field(name = "nCarboidrato(g)")
  private double carboidrato;

  @Field(name = "nAcucar(g)")
  private double acucar;

  @Field(name = "nFibra(g)")
  private double fibra;

  @Field(name = "nGorduraTotal(g)")
  private double gorduraTotal;

  @Field(name = "nGorduraSaturada(g)")
  private double gorduraSaturada;

  @Field(name = "nGorduraMonoinsaturada(g)")
  private double gorduraMonoinsaturada;

  @Field(name = "nGorduraPoliinsaturada(g)")
  private double gorduraPoliinsaturada;

  @Field(name = "nColesterol(mg)")
  private double colesterol;

  @Field(name = "nRetinol(mcg)")
  private double retinol;

  @Field(name = "nTiamina(mg)")
  private double tiamina;

  @Field(name = "nRiboflavina(mg)")
  private double riboflavina;

  @Field(name = "nNiacina(mg)")
  private double niacina;

  @Field(name = "nVitB6(mg)")
  private double vitaminaB6;

  @Field(name = "nFolato(mcg)")
  private double folato;

  @Field(name = "nColina(mg)")
  private double colina;

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

  @Field(name = "nCalcio(mg)")
  private double calcio;

  @Field(name = "nFosforo(mg)")
  private double fosforo;

  @Field(name = "nMagnesio(mg)")
  private double magnesio;

  @Field(name = "nFerro(mg)")
  private double ferro;

  @Field(name = "nZinco(mg)")
  private double zinco;

  @Field(name = "nCobre(mg)")
  private double cobre;

  @Field(name = "nSelenio(mcg)")
  private double selenio;

  @Field(name = "nPotassio(mg)")
  private double potassio;

  @Field(name = "nSodio(mg)")
  private double sodio;

  @Field(name = "nCafeina(mg)")
  private double cafeina;

  @Field(name = "nTeobromina(mg)")
  private double teobromina;

  @Field(name = "nAlcool(g)")
  private double alcool;

  @Field(name = "nAgua(g)")
  private double agua;
}
