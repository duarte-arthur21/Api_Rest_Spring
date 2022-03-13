package br.com.mcpac.museuciencias.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//import java.time.LocalDate;
//import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //Construtor padrão
@AllArgsConstructor //Construtor com todos os Argumentos
@Entity //usando quando para dizer que a classe é um entidade
public class AdmMuseu {
	@Id //Usando para identificar a chave primaria
	@Column(length = 11, nullable = false)
	private int telefone;
	
	@Column(length = 50, nullable = false, unique = true)// Collumn é usado em variaveis do tipo String
	private String nome;
	
	@Column(length = 50, nullable = false, unique = true) //length limita os caracteres do texto
	private String endereco;
	
	@Column(length = 50, nullable = false, unique = true)// nullble = false torna o campo obrigatório 
	private String email;
	
	@Column(length = 20, nullable = false, unique = true)//unique = true não permite repetir os valores
	private String senha;
}
