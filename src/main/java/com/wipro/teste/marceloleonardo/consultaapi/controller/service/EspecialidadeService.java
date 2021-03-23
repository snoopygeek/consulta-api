package com.wipro.teste.marceloleonardo.consultaapi.controller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.teste.marceloleonardo.consultaapi.domain.model.Especialidade;
import com.wipro.teste.marceloleonardo.consultaapi.domain.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {
	
	@Autowired
	private EspecialidadeRepository repository;

	public List<Especialidade> buscarTodos() {
		return repository.findAll();
	}
	
	public ResponseEntity<Especialidade> buscarPorId(Long id) {
		Optional<Especialidade> especialidade = repository.findById(id);
		
		if (especialidade.isPresent()) {
			return ResponseEntity.ok(especialidade.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public Especialidade salvar(Especialidade especialidade) {
		return repository.save(especialidade);
	}
	
	public ResponseEntity<Especialidade> alterar(Long id, Especialidade especialidade) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		especialidade.setId(id);
		especialidade = this.salvar(especialidade);
		
		return ResponseEntity.ok(especialidade);
	}	
		
	public ResponseEntity<Void> excluir(Long id) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

}
