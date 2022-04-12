package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ProfessorEntity;
import com.dbc.pessoaapi.entity.pk.ProfessorPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, ProfessorPK> {
}
