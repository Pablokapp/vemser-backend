package com.dbc.pessoaapi.entity;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="PESSOA")
public class PessoaEntity {

    @Column(name="id_pessoa")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name="PESSOA_SEQ", sequenceName = "SEQ_PESSOA2", allocationSize = 1)
    @Id
    private Integer idPessoa;

    @Column(name="nome")
    private String nome;

    @Column(name="data_nascimento")
    private LocalDate dataNascimento;

    @Column(name="cpf")
    private String cpf;

    @Column(name="email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContatoEntity> contatos;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "PESSOA_X_PESSOA_ENDERECO",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco")
    )
    private Set<EnderecoEntity> enderecos;

}
