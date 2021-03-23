package com.wipro.teste.marceloleonardo.consultaapi.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="medicos")
public class Medico implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank
	@Size(min = 10, max = 128)
	@Column(name="NOME")
	private String nome;

	@Column(name="DATA_NASCIMENTO")
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "medicos_especialidades", joinColumns = @JoinColumn(name = "id_medico")
		, inverseJoinColumns = @JoinColumn(name = "id_especialidade"))
	private Set<Especialidade> especialidades = new HashSet<Especialidade>(0);

	public Medico() {
	}
	
	public Medico(Long id, @NotBlank @Size(min = 20, max = 128) String nome, LocalDate dataNascimento,
			@NotBlank Situacao situacao, Set<Especialidade> especialidades) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.situacao = situacao;
		this.especialidades = especialidades;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Set<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Medico [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", situacao=" + situacao
				+ ", especialidades=" + especialidades + "]";
	}

}
