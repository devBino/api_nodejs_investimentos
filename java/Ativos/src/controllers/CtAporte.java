package controllers;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

import models.Aporte;
import parametros.Parametros;
import repositories.DialogoUsuario;
import repositories.FiltroHistorico;
import repositories.ParametrosUrl;
import repositories.Request;
import repositories.StringRegistros;

public class CtAporte {

	public DialogoUsuario dialogo;
	public ParametrosUrl parametrosUrl;
	public String url;
	public Aporte mdAporte;
	public FiltroHistorico filtro;
	
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
	
	public DefaultTableModel filtrar(DefaultTableModel modelParam, Map<String,String> params) {
		
		filtro = new FiltroHistorico(modelParam);
		
		if( !params.get("ativos").isEmpty() ) {
			filtro.filtrarAtivos( params.get("ativos") );
		}
		
		if( !params.get("tipos").isEmpty() ) {
			filtro.filtrarTipos( params.get("tipos") );
		}
		
		return filtro.getModel();
	}
	
}
