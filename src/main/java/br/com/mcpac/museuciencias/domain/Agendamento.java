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

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyy")
	private LocalDate data;
	
	@Column(nullable = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "hh-mm")
	private LocalTime horario;
	
	
	@ManyToOne //Muitas visitas pertencem a Um visitante
	@JoinColumn (nullable = false)
	private Visitante visitante;
	
	//Metodos get e Set
	public int getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}
	
}
