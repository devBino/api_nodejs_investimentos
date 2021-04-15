package controllers;

import parametros.Parametros;
import repositories.Request;
import repositories.Cotacao;

public class CtCotacao {

	private String recurso;
	private String url;
	
	public CtCotacao() {
		url = Parametros.getBaseUrl();
		recurso = "cotacao/";
	}
	
	public String getCotacao(String ativo) {
		
		Request req = new Request();
		String resposta = req.listar( url + recurso + ativo );
		Cotacao cot = new Cotacao(resposta);
		String preco = cot.getValor();
		
		return preco;
				
	}
	
}
