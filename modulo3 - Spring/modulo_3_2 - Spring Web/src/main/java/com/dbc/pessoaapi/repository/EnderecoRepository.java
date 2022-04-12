package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.TipoEndereco;
import io.swagger.models.auth.In;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer>{

    @Query("select e " +
            "from ENDERECO_PESSOA e " +
            "where e.pais = ?1")
    List<EnderecoEntity> findEnderecoPorPais(String pais);

    @Query(value = "SELECT E FROM ENDEREÇO_PESSOA E WHERE E.CIDADE = ?1", nativeQuery = true)
    List<EnderecoEntity> findEnderecoPorCidade(String cidade);

    @Query(value = "select e " +
            "from ENDERECO_PESSOA e " +
            "where e.complemento = null", nativeQuery = true)
    List<EnderecoEntity> findEnderecosSemComplemento();



    @Query("select ep " +
            "from ENDERECO_PESSOA ep " +
            " join fetch ep.pessoas p " +
            "where p.idPessoa = ?1")
    List<EnderecoEntity > findEnderecoPorIdPessoa(Integer idPessoa);

    @Query(value = "select ep from ENDERECO_PESSOA ep")
    Page<EnderecoEntity> enderecoPorCep(Pageable pageable);

    @Query(value = "select ep from ENDERECO_PESSOA ep where upper(ep.pais) like upper(:pais)")
    Page<EnderecoEntity> enderecoPorPais(Pageable pageable, String pais);


    Page<EnderecoEntity> findAllByPais(String pais, Pageable pageable);





}
