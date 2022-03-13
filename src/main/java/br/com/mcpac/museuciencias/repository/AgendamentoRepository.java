package br.com.mcpac.museuciencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.mcpac.museuciencias.domain.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer>{

}
