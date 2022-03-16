package br.com.mcpac.museuciencias.controller;

import java.util.List;
import java.util.Optional;

import br.com.mcpac.museuciencias.domain.Visitante;
import br.com.mcpac.museuciencias.repository.VisitanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Controlador que usa rest
@Controller
@RequestMapping("visitante")
public class VisitanteController {
	@Autowired //Injeta a instancia na classe
	private VisitanteRepository visitanteRepository;
	
	@GetMapping
	public List<Visitante> listar(){
		List<Visitante> visitantes = visitanteRepository.findAll(); //Retorna todos os registros da tabela
		return visitantes;
	}
	
	@GetMapping("/{telefone}")
	public Optional<Visitante> buscar(@PathVariable Integer telefone) {
		Optional<Visitante> resultado = visitanteRepository.findById(telefone);	
			return resultado;
	}
	
	@PostMapping //Metodo de envio
	public Visitante inserir(@RequestBody Visitante visita) { //ResquestBody é Usado para enviar um objeto em formato de JSON
		Visitante visitantes = visitanteRepository.save(visita);
		return visitantes;
	}
	
	@DeleteMapping("/{telefone}") //O valor null vai substiruir o valor atual do ID
	public Optional<Visitante> excluir(@PathVariable Integer telefone) { //PathVariable usado no Mapeamento com Barra
		Optional<Visitante> visitantes = visitanteRepository.findById(telefone);
		visitanteRepository.delete(visitantes.get());//get() usado para  obter o conteudo do objeto
		return visitantes;
	}
	
	@PutMapping //Metodo de Edição
	public Visitante editar(@RequestBody Visitante visita) {//Save recebe o valor do objeto e altera seu valor atual
		Visitante visitaEditada = visitanteRepository.save(visita);
		return visitaEditada;
	}

}
