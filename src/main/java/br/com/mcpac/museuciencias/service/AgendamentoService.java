package br.com.mcpac.museuciencias.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mcpac.museuciencias.domain.Agendamento;
import br.com.mcpac.museuciencias.exception.RecursoNaoEncontradoException;
import br.com.mcpac.museuciencias.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public Agendamento buscarCodigo( Integer idVisita) {
		Optional<Agendamento> resultado = agendamentoRepository.findById(idVisita);
		
		if (resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		Agendamento agenda = resultado.get();
		return agenda;
	}
}
