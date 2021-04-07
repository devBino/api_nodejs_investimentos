package controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import repositories.Configs;
import repositories.Request;
import repositories.StringRegistros;
import repositories.ParametrosUrl;
import models.TipoAtivo;

@Controller
public class TipoAtivos {

	private String recurso = "tipoAtivos/";
	
	@RequestMapping("/tiposAtivos")
	public ModelAndView index(Model model) {
	
		Request req = new Request();
		String resposta = req.listar(Configs.getBaseUrl()+recurso);
		StringRegistros stringRegistros = new StringRegistros(resposta);
		
		ArrayList<String[]> lista = stringRegistros.getListaRegistros();
		
		model.addAttribute("lista",lista);
		
		return new ModelAndView("tiposAtivos");
	}

	@RequestMapping("/salvarTipoAtivo")
	public String salvarTipoAtivo(@RequestParam String tipoAtivo) {
		
		Request req = new Request();
		
		String params = ParametrosUrl.prepareParamsUrl(new String[] {tipoAtivo}, TipoAtivo.getCampos() );
		String resposta = req.postRequest(Configs.getBaseUrl() + recurso, params);
				
		return "redirect:/tiposAtivos";
		
	}
	
	@RequestMapping("/deletarTipoAtivo/{id}")
	public String deletarTipoAtivo(@PathVariable("id") int id) {
		
		Request req = new Request();
		String resposta = req.delRequest(Configs.getBaseUrl()+recurso+id);
		
		return "redirect:/tiposAtivos";
		
	}
	
}