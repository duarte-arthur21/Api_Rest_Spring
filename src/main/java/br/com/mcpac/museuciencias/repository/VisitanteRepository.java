package br.com.mcpac.museuciencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mcpac.museuciencias.domain.Visitante;

public interface VisitanteRepository extends JpaRepository<Visitante, Integer>{

}
