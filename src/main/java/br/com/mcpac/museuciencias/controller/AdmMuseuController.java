package br.com.mcpac.museuciencias.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.mcpac.museuciencias.domain.AdmMuseu;
import br.com.mcpac.museuciencias.repository.AdmMuseuRepository;

@RestController //Controlador que usa rest
@Controller
@RequestMapping("admMuseu")
public class AdmMuseuController {
	@Autowired //Injeta a instancia na classe
	private AdmMuseuRepository admMuseuRepository;
	
	@GetMapping
	public List<AdmMuseu> listar(){
		List<AdmMuseu> resultado = admMuseuRepository.findAll(); //Retorna todos os registros da tabela
		return resultado;
	}
	
	@GetMapping("/{telefone}")
	public Optional<AdmMuseu> buscar(@PathVariable Integer telefone) {
		Optional<AdmMuseu> resultado = admMuseuRepository.findById(telefone);
			return resultado;			
		}
	
	@PostMapping //Metodo de envio
	public AdmMuseu inserir(@RequestBody AdmMuseu monitor) { //ResquestBody é Usado para enviar um objeto em formato de JSON
		AdmMuseu adm = admMuseuRepository.save(monitor);
		return adm;
	}
	
	@DeleteMapping("/{telefone}")//O valor null vai substiruir o valor atual do ID
	public Optional<AdmMuseu> excluir(@PathVariable Integer telefone) {
		Optional<AdmMuseu> adm = admMuseuRepository.findById(telefone);
		admMuseuRepository.delete(adm.get());//get() usado para  obter o conteudo do objeto
		return adm;
	}

	@PutMapping //Metodo de Edição
	public AdmMuseu editar(@RequestBody AdmMuseu monitor) {
		AdmMuseu admEditada = admMuseuRepository.save(monitor); //Save recebe o valor do objeto e altera seu valor atual
		return admEditada;
	}
}

