package br.com.mcpac.museuciencias.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Visitante {
	
	@Column(length = 50, nullable = false, unique = true)
	private String nome;
	
	@Id
	@Column(length = 11, nullable = false)
	private int telefone;
	
	
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(length = 20, nullable = false, unique = true)
	private String senha;
	
}
