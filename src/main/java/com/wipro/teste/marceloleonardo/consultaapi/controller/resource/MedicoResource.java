package com.wipro.teste.marceloleonardo.consultaapi.controller.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.teste.marceloleonardo.consultaapi.controller.service.MedicoService;
import com.wipro.teste.marceloleonardo.consultaapi.domain.model.Medico;

@RestController
@RequestMapping("/medicos")
public class MedicoResource {
	
	@Autowired
	private MedicoService service;
	
	@GetMapping
	public List<Medico> getAll() {
		return service.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medico> getById(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Medico post(@Valid @RequestBody Medico medico) {
		return service.salvar(medico);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Medico> put(@Valid @PathVariable Long id, @RequestBody Medico medico) {
		return service.alterar(id, medico);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		return service.excluir(id);
	}

}
