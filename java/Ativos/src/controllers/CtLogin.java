package controllers;

import parametros.Parametros;
import repositories.Request;

public class CtLogin {

	protected String nome;
	protected String senha;
	protected String token;
	public String mensagem;
	public String url;
	
	public CtLogin( String nome, String senha ) {
		this.nome = nome;
		this.senha = senha;
		url = Parametros.getBaseUrl() + "autenticacao";
	}

	public String getToken() {
		return token;
	}
	
	public boolean validaLogin() {
		try {
			Request req = new Request();
			String resposta = req.getRequest( url + "/" + nome + "/" + senha );
			
			mensagem = req.mensagem;
			
			String[] arrResposta = resposta.split(",");
			String strToken = arrResposta[1].replace("\"token\":\"","");
			strToken = strToken.replace("\"}","");
			
			token = strToken;
			
			if( resposta.contains("\"auth\":true") ) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		
	}
	
}
