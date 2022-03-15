package br.com.mcpac.museuciencias.model;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mcpac.museuciencias.domain.Agendamento;
import br.com.mcpac.museuciencias.repository.AgendamentoRepository;

public class Post {
	@Autowired
	AgendamentoRepository agedamentoRepository;
	
	public AgendamentoRepository getAgedamntoRepository() {
		return agedamentoRepository;
	}

	public void setAgedamntoRepository(AgendamentoRepository agedamntoRepository) {
		this.agedamentoRepository = agedamntoRepository;
	}
	
	
}
