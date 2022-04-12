package com.dbc.pessoaapi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="CONTATO")
public class ContatoEntity {

    @Column(name="id_contato")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTATO")
    @SequenceGenerator(name="SEQ_CONTATO", sequenceName = "SEQ_CONTATO", allocationSize = 1)
    @Id
    private Integer idContato;

    @Column(name="id_pessoa", insertable = false, updatable = false)
    private Integer idPessoa;

    @Column(name="tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoContato tipoContato;

    @Column(name="numero")
    private String numero;

    @Column(name="descricao")
    private String descricao;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_pessoa", referencedColumnName = "id_pessoa")
    private PessoaEntity pessoaEntity;
}




