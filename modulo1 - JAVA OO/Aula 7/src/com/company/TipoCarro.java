package com.company;

public enum TipoCarro {
    SEDAN("sedan"),
    HATCH("hatch"),
    SUV("suv");


    private String descricao;
    TipoCarro(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
