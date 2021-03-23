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

import com.wipro.teste.marceloleonardo.consultaapi.controller.service.EspecialidadeService;
import com.wipro.teste.marceloleonardo.consultaapi.domain.model.Especialidade;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeResource {
	
	@Autowired
	private EspecialidadeService service;
	
	@GetMapping
	public List<Especialidade> getAll() {
		return service.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialidade> getById(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Especialidade post(@Valid @RequestBody Especialidade especialidade) {
		return service.salvar(especialidade);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Especialidade> put(@Valid @PathVariable Long id, @RequestBody Especialidade especialidade) {
		return service.alterar(id, especialidade);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		return service.excluir(id);
	}

}
