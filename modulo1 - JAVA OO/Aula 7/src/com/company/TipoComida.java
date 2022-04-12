package com.company;


import java.util.Arrays;

public enum TipoComida {

    JAPONESA("Custa R$50"),
    FAST_FOOD("Custa R$30"),
    TRADICIONAL("Custa R$20");


    private String descricao;

    TipoComida(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


    public static TipoComida valueOfByDescricao(String descricao) {
            return Arrays.asList(values()).stream()
                    .filter(tipoComida -> tipoComida.getDescricao().equalsIgnoreCase(descricao))
                    .findFirst()
                    .orElse(null);
    }
}
