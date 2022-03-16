package br.com.mcpac.museuciencias.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mcpac.museuciencias.domain.Visitante;
import br.com.mcpac.museuciencias.repository.VisitanteRepository;

@Service
public class VisitanteService {
	@Autowired
	private VisitanteRepository visitanteRepository;
	
	//@GetMapping("/{telefone}")
//	public Visitante buscarCodigo( Integer telefone) {
//		Optional<Visitante> resultado = visitanteRepository.findById(telefone);
//		
//		if (resultado.isEmpty()) {
//			throw new RecursoNaoEncontradoException();
//		}
//		Visitante visitantes = resultado.get();
//		return visitantes;
//		
//	}
}
