package controllers;

import java.util.ArrayList;

import repositories.Request;
import repositories.DialogoUsuario;
import repositories.StringRegistros;
import parametros.Parametros;

public class CtTipoAtivo {

	public String mensagem;
	public String url;
	public DialogoUsuario dialogo;
	
	public CtTipoAtivo() {
		url = Parametros.baseUrl + "tipoAtivos";
		dialogo = new DialogoUsuario();
	}
	
	public void salvar(String nomeTipo) {
		
		String params = "nmTipo="+nomeTipo;
		
		Request req = new Request();
		String resposta = req.postRequest(this.url, params);
		
		dialogo.mensagemCrud("salvo", "salvar", resposta);

	}
	
	public void alterar(String nomeTipo, String idTipo) {
		
		String params = "nmTipo="+nomeTipo+"&id="+idTipo;
		
		Request req = new Request();
		String resposta = req.putRequest(this.url, params);
		
		dialogo.mensagemCrud("alterado", "alterar", resposta);
		
	}
	
	public void deletar(String idTipo) {
		
		Request req = new Request();
		String resposta = req.delRequest(this.url+"/"+idTipo);
		
		dialogo.mensagemCrud("deletado","deletar",resposta);

	}
	
	public ArrayList<String[]> listar() {
	
		Request req = new Request();
		String resposta = req.listar(this.url);
		StringRegistros strRegistros = new StringRegistros(resposta);
		
		return strRegistros.getListaRegistros();
	}
	
}