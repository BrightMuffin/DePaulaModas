package com.finalcurso.modas.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.finalcurso.modas.entidade.Roupa;
import com.finalcurso.modas.repositorio.RoupaRepositorio;
import com.finalcurso.modas.servico.RoupaService;
import com.finalcurso.modas.servico.RoupaServiceImpl;


@Controller
public class RoupaController {
	private final RoupaService roupaServiceImpl;

	@Autowired
	private RoupaRepositorio roupaRepositorio;
	
	public RoupaController(RoupaServiceImpl roupaServiceImpl){
		this.roupaServiceImpl = roupaServiceImpl;
	}

	@GetMapping("/roupas")
	public String listarRoupas(Model model){
		
		model.addAttribute("roupas", roupaServiceImpl.listarRoupas());
		
		return "index";	
	}
	
	@GetMapping("/roupas/novo")
	public String abrirNovoroupa(Model model) {
		Roupa roupa = new Roupa();
		
		model.addAttribute("roupa", roupa);
		
		return "inserir-roupa";
	}
	
	@PostMapping("/roupas/inserir")
	public String inserirRoupa(Roupa roupa) {
		
		roupaRepositorio.save(roupa);
		return "redirect:/roupas";
	}
	
	@GetMapping("/roupas/alterar/{id}")
	public String abrirAlterarRoupa(@PathVariable Long id , Model model) {
		Roupa roupa = this.roupaServiceImpl.obterRoupa(id);
				
		model.addAttribute("roupa", roupa);
		
		return "alterar-roupa";
	}
	
	@PostMapping("/roupas/alterar")
	public String alterarRoupa (Roupa roupa){
		this.roupaServiceImpl.alterarRoupa(roupa);
		return "redirect:/roupas";
	}
	
	@GetMapping("/roupas/excluir/{id}")
	public String abrirExcluirRoupa(@PathVariable Long id) {
		this.roupaServiceImpl.excluirRoupa(id);
		
		return "redirect:/roupas";
}
	}
