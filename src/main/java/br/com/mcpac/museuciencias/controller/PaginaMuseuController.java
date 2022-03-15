package br.com.mcpac.museuciencias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.mcpac.museuciencias.domain.Agendamento;
import br.com.mcpac.museuciencias.service.serviceImp.PaginaMuseuService;

import java.util.List;

@Controller
public class PaginaMuseuController{

	@Autowired
	PaginaMuseuService museuService;
	
//	@RequestMapping(value = "/posts", method = RequestMethod.GET)
//	public ModelAndView getPosts() {
//		ModelAndView mv = new ModelAndView(viewName: "posts");
//		List<Agendamento> posts = museuService.findAll();
//		mv.addObject(atributteName: "posts", posts);
//		return mv;
//		
//	}
}
