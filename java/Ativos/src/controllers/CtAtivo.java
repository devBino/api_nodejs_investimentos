package controllers;

import repositories.Request;
import repositories.DialogoUsuario;
import repositories.StringRegistros;
import repositories.ParametrosUrl;
import models.Ativo;
import models.TipoAtivo;
import parametros.Parametros;

import java.util.ArrayList;


public class CtAtivo {

	public String nomeAtivo;
	public String url;
	public DialogoUsuario dialogo;
	public ParametrosUrl parametrosUrl;
	public Ativo model;
	
	public CtAtivo() {
		url = Parametros.baseUrl + "ativos";
		dialogo = new DialogoUsuario();
		parametrosUrl = new ParametrosUrl();
		model = new Ativo();
	}
	
	public void salvar(String[] params) {
		
		String strParams = parametrosUrl.prepareParamsUrl(params, model.getCampos());
		
		Request req = new Request();
		String resposta = req.postRequest(this.url, strParams);
		
		dialogo.mensagemCrud("salvo","salvar", resposta);
	}
	
	public void alterar(String[] params, String idAtivo) {
		parametrosUrl.setarId(idAtivo);
		String strParams = parametrosUrl.prepareParamsUrl(params, model.getCampos());
		
		Request req = new Request();
		String resposta = req.putRequest(url, strParams);
		
		dialogo.mensagemCrud("alterado", "alterar", resposta);
	}
	
	public ArrayList<String[]> listar() {
		
		Request req = new Request();
		String strLista = req.listar(this.url);
		
		StringRegistros strRegistros = new StringRegistros(strLista);
		
		return strRegistros.getListaRegistros();
	}
	
	public ArrayList<TipoAtivo> listarCombo() {
		
		String urlTipoAtivos = Parametros.baseUrl + "tipoAtivos";
		Request req = new Request();
		
		String strLista = req.listar(urlTipoAtivos);
		StringRegistros strRegistros = new StringRegistros(strLista);
		
		return strRegistros.getDadosCombo();
	}
	
	public void deletar(String idTipo) {
		Request req = new Request();
		String resposta = req.delRequest(this.url+"/"+idTipo);
		
		dialogo.mensagemCrud("deletado", "deletar", resposta);
	}
	
	
}