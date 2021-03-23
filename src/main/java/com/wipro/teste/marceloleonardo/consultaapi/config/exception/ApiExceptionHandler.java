package com.wipro.teste.marceloleonardo.consultaapi.config.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.wipro.teste.marceloleonardo.consultaapi.config.exception.Excessao.DetalhamentoErro;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource mensagens;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ArrayList<Excessao.DetalhamentoErro> erros = new ArrayList<Excessao.DetalhamentoErro>();
		
		for(ObjectError error: ex.getBindingResult().getAllErrors()) {
			String nomeCampo = ((FieldError) error).getField();
			
			String detalhamentoErro = mensagens.getMessage(error, LocaleContextHolder.getLocale());
			
			erros.add(new DetalhamentoErro(nomeCampo, detalhamentoErro));
		}
		
		Excessao excessao = new Excessao();
		excessao.setCodigo(status.value());
		excessao.setDescricaoResumida("Existem campos com preenchimento inválido. "
				+ "Preencha corretamente os campos e tente novamente.");
		excessao.setDataHora(LocalDateTime.now());
		excessao.setDetalhamentoErro(erros);
		
		return super.handleExceptionInternal(ex, excessao, headers, status, request);
	}
	
}
