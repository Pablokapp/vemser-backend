package com.dbc.pessoaapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "USUARIO")
public class UsuarioEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQUENCIA")
    @SequenceGenerator(name = "USUARIO_SEQUENCIA", sequenceName = "seq_usuario", allocationSize = 1)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @ManyToMany
    @JoinTable(
            name = "USUARIO_GRUPO",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_grupo")
    )
    private Set<GrupoEntity> grupos;

    @Override
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> regras = new ArrayList<>();
        for(GrupoEntity grupoEntity: grupos){
            regras.addAll(grupoEntity.getRegras());
        }
        return regras;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
