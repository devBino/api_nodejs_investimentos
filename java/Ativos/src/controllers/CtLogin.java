package controllers;

import repositories.Request2;
import models.Auth;
import parametros.Parametros;

//https://medium.com/programmers-blockchain/importing-gson-into-eclipse-ec8cf678ad52
import com.google.gson.Gson;

public class CtLogin {

	protected String nome;
	protected String senha;
	protected String token;
	public String mensagem;
	public String url = Parametros.baseUrl + "autenticacao";
	
	public CtLogin( String nome, String senha ) {
		this.nome = nome;
		this.senha = senha;
	}

	public String getToken() {
		return this.token;
	}
	
	public boolean validaLogin() {
		try {
			Request2 req = new Request2();
			String resposta = req.getRequest( this.url + "/" + this.nome + "/" + this.senha );
			
			this.mensagem = req.mensagem;
			
			Gson gson = new Gson();
			Auth auth  = gson.fromJson(resposta,Auth.class);
			
			this.token = auth.token;
			
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
