package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.PessoaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findByNomeContainingIgnoreCase(String nome);
    List<PessoaEntity> findByCpf(String cpf);
    List<PessoaEntity> findByNomeOrDataNascimento(String nome, LocalDate dataNascimento);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate dataNascimentoInicial, LocalDate dataNascimentoFinal);

//    @Query("select .... from PESSOA p where p.nome = ?1")
@Query("select p " +
        "from PESSOA p " +
        " join fetch p.contatos c " +
        "where p.nome = :nome")
    List<PessoaEntity> findByNomeJPQL();


    @Query("select p " +
            "from PESSOA p " +
            "where p.dataNascimento BETWEEN :dataInicial AND :dataFinal")
    List<PessoaEntity> pessoaPorDataNascimentoEntreDatas(LocalDate dataInicial, LocalDate dataFinal);

//    @Query("select p from PESSOA p " +
//       "" +
//       "")
//    List<PessoaEntity> pessoasQuePossuemEndereco();


    @Query("select p FROM PESSOA p " +
            "left join fetch p.contatos c" +
            "left join fetch p.enderecos e " +
            "where p.idPessoa = ?1")
    List<PessoaEntity> pessoasComEnderecoEContatoPorId(Integer id);

    @Query("select p from PESSOA p " +
            "left join fetch p.contatos c" +
            "left join fetch p.enderecos e")
    List<PessoaEntity> pessoasComEnderecoEContato();

    @Query(value = "SELECT * FROM FROM VEM_SER.PESSOA P LEFT JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO PE "
    + " ON P.ID_PESSOA = PE.ID_PESSOA WHERE PE.ID_PESSOA IS NULL", nativeQuery = true)
    List<PessoaEntity> pessoasSemEndereco();


    @Query(value = "select p from PESSOA p where upper(p.nome) like upper(:nome)")
    Page<PessoaEntity> findByNamePaged(String nome, Pageable pageable);


}
