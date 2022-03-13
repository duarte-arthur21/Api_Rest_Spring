package br.com.mcpac.museuciencias.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import br.com.mcpac.museuciencias.domain.Visitante;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Agendamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Usado para criar um valor automatico
	private int idVisita;
	
	@Column(nullable = true)
	private LocalDate data;
	
	@Column(nullable = true)
	private LocalTime horario;
	
	
	@ManyToOne //Muitas visitas pertencem a Um visitante
	@JoinColumn (nullable = false)
	private Visitante visitante;
}
