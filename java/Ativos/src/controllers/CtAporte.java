package controllers;

import java.util.List;
import java.util.ArrayList;

import models.Sessao;
import parametros.Parametros;
import repositories.DialogoUsuario;
import repositories.StringRegistros;
import repositories.Request;
import repositories.ParametrosUrl;

public class CtAporte {

	public DialogoUsuario dialogo;
	public ParametrosUrl parametrosUrl;
	public String url;
	
	public CtAporte() {
		dialogo = new DialogoUsuario();
		parametrosUrl = new ParametrosUrl();
		url = Parametros.baseUrl + "aportes";
	}
	
	public void salvar() {
	}
	
	public void alterar() {
		
	}
	public ArrayList<String[]> listar() {
		Request req = new Request();
		String resposta = req.listar(url);
		StringRegistros stringRegistro = new StringRegistros(resposta);
		
		return stringRegistro.getListaRegistros();
	}
	public void deletar() {
		
	}
	
}
