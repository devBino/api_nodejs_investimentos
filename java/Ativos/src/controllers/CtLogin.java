package controllers;

import repositories.Request;
import models.Auth;
import parametros.Parametros;

//https://medium.com/programmers-blockchain/importing-gson-into-eclipse-ec8cf678ad52
import com.google.gson.Gson;

public class CtLogin {

	protected String nome;
	protected String senha;
	protected String token;
	public String mensagem;
	public String url;
	
	public CtLogin( String nome, String senha ) {
		this.nome = nome;
		this.senha = senha;
		url = Parametros.baseUrl + "autenticacao";
	}

	public String getToken() {
		return token;
	}
	
	public boolean validaLogin() {
		try {
			Request req = new Request();
			String resposta = req.getRequest( url + "/" + nome + "/" + senha );
			
			mensagem = req.mensagem;
			
			Gson gson = new Gson();
			Auth auth  = gson.fromJson(resposta,Auth.class);
			
			token = auth.token;
			
			if( auth.auth ) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		
	}
	
}
