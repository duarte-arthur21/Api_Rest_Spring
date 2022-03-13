package br.com.mcpac.museuciencias.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mcpac.museuciencias.domain.AdmMuseu;
import br.com.mcpac.museuciencias.exception.RecursoNaoEncontradoException;
import br.com.mcpac.museuciencias.repository.AdmMuseuRepository;

@Service
public class AdmMuseuService {
	@Autowired
	private AdmMuseuRepository admMuseuRepository;
	
	public AdmMuseu buscarCodigo(Integer telefone) {
		Optional<AdmMuseu> resultado = admMuseuRepository.findById(telefone);
		
		if (resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		AdmMuseu monitor = resultado.get();
		return monitor;		
	}
	
	
	public List<AdmMuseu> listar(){
		List<AdmMuseu> resultado = admMuseuRepository.findAll(); //Retorna todos os registros da tabela
		return resultado;
	}

	public AdmMuseu inserir(AdmMuseu monitor) { //ResquestBody é Usado para enviar um objeto em formato de JSON
		AdmMuseu resultado = admMuseuRepository.save(monitor);
		return resultado;
	}
	
	public Optional<AdmMuseu> excluir(Integer telefone) {
		Optional<AdmMuseu> adm = admMuseuRepository.findById(telefone);
		admMuseuRepository.delete(adm.get());//get() usado para  obter o conteudo do objeto
		return adm;
	}
	
	public AdmMuseu editar(AdmMuseu monitor) {
		AdmMuseu admEditada = admMuseuRepository.save(monitor); //Save recebe o valor do objeto e altera seu valor atual
		return admEditada;
	}

}

