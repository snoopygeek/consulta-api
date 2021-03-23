package com.wipro.teste.marceloleonardo.consultaapi.controller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.teste.marceloleonardo.consultaapi.domain.model.Medico;
import com.wipro.teste.marceloleonardo.consultaapi.domain.repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repository;

	public List<Medico> buscarTodos() {
		return repository.findAll();
	}
	
	public ResponseEntity<Medico> buscarPorId(Long id) {
		Optional<Medico> medico = repository.findById(id);
		
		if (medico.isPresent()) {
			return ResponseEntity.ok(medico.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public Medico salvar(Medico medico) {
		
		System.out.println("nome: " + medico.getNome());
		System.out.println("data nascimento: " + medico.getDataNascimento());
		System.out.println("situacao: " + medico.getSituacao());
		return repository.save(medico);
	}
	
	public ResponseEntity<Medico> alterar(Long id, Medico medico) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		medico.setId(id);
		medico = this.salvar(medico);
		
		return ResponseEntity.ok(medico);
	}	
		
	public ResponseEntity<Void> excluir(Long id) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
