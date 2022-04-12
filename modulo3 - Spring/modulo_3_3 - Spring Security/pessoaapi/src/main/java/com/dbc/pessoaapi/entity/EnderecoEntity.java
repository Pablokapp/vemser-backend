package com.dbc.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity(name="ENDERECO_PESSOA")
public class EnderecoEntity {

    @Column(name="id_endereco")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ENDERECO")
    @SequenceGenerator(name="SEQ_ENDERECO", sequenceName = "SEQ_ENDERECO_CONTATO", allocationSize = 1)
    @Id
    private Integer idEndereco;


    @Column(name="tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoEndereco tipoEndereco;

    @Column(name="logradouro")
    private String logradouro;

    @Column(name="numero")
    private Integer numero;
    @Column(name="complemento")
    private String complemento;
    @Column(name="cep")
    private String cep;
    @Column(name="cidade")
    private String cidade;
    @Column(name="estado")
    private String estado;
    @Column(name="pais")
    private String pais;

    @JsonIgnore
    @ManyToMany(mappedBy = "enderecos")
    private Set<PessoaEntity> pessoas;

    }

