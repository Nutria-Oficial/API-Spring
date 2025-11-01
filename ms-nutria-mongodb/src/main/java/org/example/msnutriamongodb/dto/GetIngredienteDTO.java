package org.example.msnutriamongodb.dto;

public class GetIngredienteDTO {
    private Integer id;
    private String nomeIngrediente;
    private Double caloria;
    private Double carboidrato;
    private Double acucar;
    private Double proteina;
    private Double gorduraTotal;
    private Double gorduraSaturada;
    private Double sodio;
    private Double fibra;
    private Double agua;
    private Double gorduraMonoinsaturada;
    private Double gorduraPoliinsaturada;
    private Double colesterol;
    private Double alcool;
    private Double vitaminaB6;
    private Double vitaminaB12;
    private Double vitaminaC;
    private Double vitaminaD;
    private Double vitaminaE;
    private Double vitaminaK;
    private Double teobromina;
    private Double cafeina;
    private Double colina;
    private Double calcio;
    private Double fosforo;
    private Double magnesio;
    private Double potassio;
    private Double ferro;
    private Double zinco;
    private Double cobre;
    private Double selenio;
    private Double retinol;
    private Double tiamina;
    private Double riboflavina;
    private Double niacina;
    private Double folato;

    public GetIngredienteDTO() {
    }

    public GetIngredienteDTO(Integer id, String nomeIngrediente, Double caloria, Double carboidrato,
        Double acucar, Double proteina, Double gorduraTotal, Double gorduraSaturada, Double sodio,
        Double fibra, Double agua, Double gorduraMonoinsaturada, Double gorduraPoliinsaturada,
        Double colesterol, Double alcool, Double vitaminaB6, Double vitaminaB12, Double vitaminaC,
        Double vitaminaD, Double vitaminaE, Double vitaminaK, Double teobromina, Double cafeina,
        Double colina, Double calcio, Double fosforo, Double magnesio, Double potassio, Double ferro,
        Double zinco, Double cobre, Double selenio, Double retinol, Double tiamina,
        Double riboflavina, Double niacina, Double folato) {
        this.id = id;
        this.nomeIngrediente = nomeIngrediente;
        this.caloria = caloria;
        this.carboidrato = carboidrato;
        this.acucar = acucar;
        this.proteina = proteina;
        this.gorduraTotal = gorduraTotal;
        this.gorduraSaturada = gorduraSaturada;
        this.sodio = sodio;
        this.fibra = fibra;
        this.agua = agua;
        this.gorduraMonoinsaturada = gorduraMonoinsaturada;
        this.gorduraPoliinsaturada = gorduraPoliinsaturada;
        this.colesterol = colesterol;
        this.alcool = alcool;
        this.vitaminaB6 = vitaminaB6;
        this.vitaminaB12 = vitaminaB12;
        this.vitaminaC = vitaminaC;
        this.vitaminaD = vitaminaD;
        this.vitaminaE = vitaminaE;
        this.vitaminaK = vitaminaK;
        this.teobromina = teobromina;
        this.cafeina = cafeina;
        this.colina = colina;
        this.calcio = calcio;
        this.fosforo = fosforo;
        this.magnesio = magnesio;
        this.potassio = potassio;
        this.ferro = ferro;
        this.zinco = zinco;
        this.cobre = cobre;
        this.selenio = selenio;
        this.retinol = retinol;
        this.tiamina = tiamina;
        this.riboflavina = riboflavina;
        this.niacina = niacina;
        this.folato = folato;
    }

    // Getters e Setters

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

    public Double getCaloria() {
        return caloria;
    }

    public void setCaloria(Double caloria) {
        this.caloria = caloria;
    }

    public Double getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(Double carboidrato) {
        this.carboidrato = carboidrato;
    }

    public Double getAcucar() {
        return acucar;
    }

    public void setAcucar(Double acucar) {
        this.acucar = acucar;
    }

    public Double getProteina() {
        return proteina;
    }

    public void setProteina(Double proteina) {
        this.proteina = proteina;
    }

    public Double getGorduraTotal() {
        return gorduraTotal;
    }

    public void setGorduraTotal(Double gorduraTotal) {
        this.gorduraTotal = gorduraTotal;
    }

    public Double getGorduraSaturada() {
        return gorduraSaturada;
    }

    public void setGorduraSaturada(Double gorduraSaturada) {
        this.gorduraSaturada = gorduraSaturada;
    }

    public Double getSodio() {
        return sodio;
    }

    public void setSodio(Double sodio) {
        this.sodio = sodio;
    }

    public Double getFibra() {
        return fibra;
    }

    public void setFibra(Double fibra) {
        this.fibra = fibra;
    }

    public Double getAgua() {
        return agua;
    }

    public void setAgua(Double agua) {
        this.agua = agua;
    }

    public Double getGorduraMonoinsaturada() {
        return gorduraMonoinsaturada;
    }

    public void setGorduraMonoinsaturada(Double gorduraMonoinsaturada) {
        this.gorduraMonoinsaturada = gorduraMonoinsaturada;
    }

    public Double getGorduraPoliinsaturada() {
        return gorduraPoliinsaturada;
    }

    public void setGorduraPoliinsaturada(Double gorduraPoliinsaturada) {
        this.gorduraPoliinsaturada = gorduraPoliinsaturada;
    }

    public Double getColesterol() {
        return colesterol;
    }

    public void setColesterol(Double colesterol) {
        this.colesterol = colesterol;
    }

    public Double getAlcool() {
        return alcool;
    }

    public void setAlcool(Double alcool) {
        this.alcool = alcool;
    }

    public Double getVitaminaB6() {
        return vitaminaB6;
    }

    public void setVitaminaB6(Double vitaminaB6) {
        this.vitaminaB6 = vitaminaB6;
    }

    public Double getVitaminaB12() {
        return vitaminaB12;
    }

    public void setVitaminaB12(Double vitaminaB12) {
        this.vitaminaB12 = vitaminaB12;
    }

    public Double getVitaminaC() {
        return vitaminaC;
    }

    public void setVitaminaC(Double vitaminaC) {
        this.vitaminaC = vitaminaC;
    }

    public Double getVitaminaD() {
        return vitaminaD;
    }

    public void setVitaminaD(Double vitaminaD) {
        this.vitaminaD = vitaminaD;
    }

    public Double getVitaminaE() {
        return vitaminaE;
    }

    public void setVitaminaE(Double vitaminaE) {
        this.vitaminaE = vitaminaE;
    }

    public Double getVitaminaK() {
        return vitaminaK;
    }

    public void setVitaminaK(Double vitaminaK) {
        this.vitaminaK = vitaminaK;
    }

    public Double getTeobromina() {
        return teobromina;
    }

    public void setTeobromina(Double teobromina) {
        this.teobromina = teobromina;
    }

    public Double getCafeina() {
        return cafeina;
    }

    public void setCafeina(Double cafeina) {
        this.cafeina = cafeina;
    }

    public Double getColina() {
        return colina;
    }

    public void setColina(Double colina) {
        this.colina = colina;
    }

    public Double getCalcio() {
        return calcio;
    }

    public void setCalcio(Double calcio) {
        this.calcio = calcio;
    }

    public Double getFosforo() {
        return fosforo;
    }

    public void setFosforo(Double fosforo) {
        this.fosforo = fosforo;
    }

    public Double getMagnesio() {
        return magnesio;
    }

    public void setMagnesio(Double magnesio) {
        this.magnesio = magnesio;
    }

    public Double getPotassio() {
        return potassio;
    }

    public void setPotassio(Double potassio) {
        this.potassio = potassio;
    }

    public Double getFerro() {
        return ferro;
    }

    public void setFerro(Double ferro) {
        this.ferro = ferro;
    }

    public Double getZinco() {
        return zinco;
    }

    public void setZinco(Double zinco) {
        this.zinco = zinco;
    }

    public Double getCobre() {
        return cobre;
    }

    public void setCobre(Double cobre) {
        this.cobre = cobre;
    }

    public Double getSelenio() {
        return selenio;
    }

    public void setSelenio(Double selenio) {
        this.selenio = selenio;
    }

    public Double getRetinol() {
        return retinol;
    }

    public void setRetinol(Double retinol) {
        this.retinol = retinol;
    }

    public Double getTiamina() {
        return tiamina;
    }

    public void setTiamina(Double tiamina) {
        this.tiamina = tiamina;
    }

    public Double getRiboflavina() {
        return riboflavina;
    }

    public void setRiboflavina(Double riboflavina) {
        this.riboflavina = riboflavina;
    }

    public Double getNiacina() {
        return niacina;
    }

    public void setNiacina(Double niacina) {
        this.niacina = niacina;
    }

    public Double getFolato() {
        return folato;
    }

    public void setFolato(Double folato) {
        this.folato = folato;
    }
}