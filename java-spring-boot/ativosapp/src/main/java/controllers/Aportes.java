package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import repositories.Configs;
import repositories.Request;
import repositories.StringRegistros;

@Controller
public class Aportes {

	private String recurso = "aportes/";
	
	@RequestMapping("/aportes")
	public ModelAndView index(Model model) {
	
		Request req = new Request();
		String resposta = req.listar( Configs.getBaseUrl()+recurso );
		StringRegistros stringRegistros = new StringRegistros(resposta);
		ArrayList<String[]> lista = stringRegistros.getListaRegistros();
		
		model.addAttribute("lista",lista);
		
		return new ModelAndView("aportes");
	}
	
}
