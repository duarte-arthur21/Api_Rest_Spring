package br.com.mcpac.museuciencias.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mcpac.museuciencias.domain.Agendamento;
import br.com.mcpac.museuciencias.repository.AgendamentoRepository;

@RestController //Controlador que usa rest
@Controller
@RequestMapping("agendamento")
public class AgendamentoConstroller {
	
	@Autowired //Injeta a instancia na classe
	private AgendamentoRepository agendamentoRepository;
	
	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {
		request.setAttribute("horario", request);
		return "agendamento";
	}
	
	@GetMapping("/home")
	public String home(ModelMap  model) {
		model.addAttribute("nomeDoAtributo", "Treinaweb");
		return "home";
	}
	
	@GetMapping
	public List<Agendamento> listar(){
		List<Agendamento> agenda = agendamentoRepository.findAll(); //Retorna todos os registros da tabela
		return agenda;
	}
	
	@GetMapping("/{idVisita}")
	public Optional<Agendamento> buscar(@PathVariable Integer idVisita){
		Optional<Agendamento> resultado = agendamentoRepository.findById(idVisita);
			return resultado;		
	}
	
	@PostMapping //Metodo de envio
	public Agendamento inserir(@RequestBody Agendamento agenda) { //ResquestBody é Usado para enviar um objeto em formato de JSON
		Agendamento agendaSalva = agendamentoRepository.save(agenda);
		return agendaSalva;
	}
	
	@DeleteMapping("/{idVisita}")//O valor null vai substiruir o valor atual do ID 
	public Optional<Agendamento> excluir(@PathVariable Integer idVisita) {
		Optional<Agendamento> agenda = agendamentoRepository.findById(idVisita);
		agendamentoRepository.delete(agenda.get());//get() usado para  obter o conteudo do objeto
		return agenda;
	}
	
	@PutMapping //Metodo de Edição
	public Agendamento editar(@RequestBody Agendamento agenda) {
		Agendamento agendaEditada = agendamentoRepository.save(agenda);//Save recebe o valor do objeto e altera seu valor atual
		return agendaEditada;
	}
	

}
