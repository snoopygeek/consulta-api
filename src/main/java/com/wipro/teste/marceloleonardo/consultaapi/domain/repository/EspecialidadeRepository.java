package com.wipro.teste.marceloleonardo.consultaapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.teste.marceloleonardo.consultaapi.domain.model.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
	
}
