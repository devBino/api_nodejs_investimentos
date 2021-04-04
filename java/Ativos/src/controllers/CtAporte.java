package controllers;

import java.util.List;
import java.util.ArrayList;

import models.Sessao;
import models.Aporte;
import parametros.Parametros;
import repositories.DialogoUsuario;
import repositories.StringRegistros;
import repositories.Request;
import repositories.ParametrosUrl;

public class CtAporte {

	public DialogoUsuario dialogo;
	public ParametrosUrl parametrosUrl;
	public String url;
	public Aporte mdAporte;
	
	public CtAporte() {
		dialogo = new DialogoUsuario();
		parametrosUrl = new ParametrosUrl();
		url = Parametros.getBaseUrl() + "aportes";
		mdAporte = new Aporte();
	}
	
	public void salvar(String[] params) {
		String strParams = parametrosUrl.prepareParamsUrl(params,mdAporte.getCamposApi(null));
		
		Request req = new Request();
		String resposta = req.postRequest(url,strParams);
		
		dialogo.mensagemCrud("salvo","salvar",resposta);
	}
	
	public void alterar() {
		
	}
	
	public void deletar(String[] ids) {
		
		Request req = new Request();
		
		for( String id : ids ) {
			String resposta = req.delRequest(url + "/" + id);
		}
		
		dialogo.sucesso("Os registros foram enviados para serem deletados...");
		
	}

	public ArrayList<String[]> listar() {
		Request req = new Request();
		String resposta = req. listar(url);
		StringRegistros stringRegistro = new StringRegistros(resposta);
		
		return stringRegistro.getListaRegistros();
	}
	
	public ArrayList<String[]> listarComboAtivo(){
		Request req = new Request();
		String strLista = req.listar( Parametros.getBaseUrl() + "ativos" );
		StringRegistros strRegistros = new StringRegistros(strLista);
		
		return strRegistros.getListaRegistros();
	}
	
}
