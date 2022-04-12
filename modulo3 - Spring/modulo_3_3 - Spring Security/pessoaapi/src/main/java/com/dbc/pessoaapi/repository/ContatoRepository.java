package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {


    @Query("select c " +
            "from CONTATO c " +
            "where c.tipoContato = :tipo")
    List<ContatoEntity> findContatoPorTipoContato(TipoContato tipo);

    @Query(value = "SELECT c FROM CONTATO c WHERE c.ID_PESSOA = ?1", nativeQuery = true)
    List<ContatoEntity> findContatoPorId(Integer idPessoa);

    @Query(value = "select c from CONTATO c where upper(c.descricao) like upper(c.descricao)")
    Page<ContatoEntity> contatoPorDescricao(Pageable pageable);



}
