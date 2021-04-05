package controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import models.Sessao;
import repositories.Configs;
import repositories.Request;
import repositories.Sha1;

@Controller
public class Login {

	private String recurso = "autenticacao/";
	
	@RequestMapping("/")
	public String home() {
		Sessao.setToken(null);
		return "home";
	}
	
	@RequestMapping("/erroLogin")
	public String erroLogin() {
		return "erroLogin";
	}
	
	@RequestMapping("/validarLogin")
	public String validar( @RequestParam String usuario, @RequestParam String senha ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
				
		Request req = new Request();
		Sha1 sha1 = new Sha1(senha);
		String urlLogin = Configs.getBaseUrl() + recurso + usuario +"/"+sha1.getHash();
		String resposta = req.getRequest(urlLogin);
		
		if( resposta.contains("\"auth\":true") ) {
			Sessao.setToken(resposta);
			return "redirect:sistema";	
		}else {
			return "redirect:/erroLogin";
		}
		
	}
	
}
