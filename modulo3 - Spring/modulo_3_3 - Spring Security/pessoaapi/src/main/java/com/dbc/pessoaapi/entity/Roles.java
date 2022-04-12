package com.dbc.pessoaapi.entity;
import java.util.Arrays;
public enum Roles {
    ADMIN(1),
    USUARIO(2),
    MARKETING(3);

    private final Integer idGrupo;

    Roles(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getRole(){
        return idGrupo;
    }

    public static Roles tipo(Integer idGrupo){
        return Arrays.stream(Roles.values())
                .filter(idDoGrupo -> idDoGrupo.getRole().equals(idGrupo))
                .findFirst()
                .get();
    }
}
