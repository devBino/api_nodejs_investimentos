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
			filtro.ativos( params.get("ativos") );
		}
		
		if( !params.get("tipos").isEmpty() ) {
			filtro.tipos( params.get("tipos") );
		}
		
		if( !params.get("valorMaiorIgual").isEmpty() ) {
			if( !params.get("valorMaiorIgual").replace(",",".").equals("0.00") ) {
				filtro.valorMaiorIgual( params.get("valorMaiorIgual") );
			}
		}
		
		if( !params.get("valorMenorIgual").isEmpty() ) {
			if( !params.get("valorMenorIgual").replace(",",".").equals("0.00") ) {
				filtro.valorMenorIgual( params.get("valorMenorIgual") );
			}
		}
		
		if( !params.get("qtdeMaiorIgual").isEmpty() ) {
			String[] arrQtde = params.get("qtdeMaiorIgual").split(",");
			if( !params.get("qtdeMaiorIgual").replace(",",".").equals("0.00") ) {
				filtro.qtdeMaiorIgual(arrQtde[0]);
			}
		}
		
		if( !params.get("qtdeMenorIgual").isEmpty() ) {
			String[] arrQtde = params.get("qtdeMenorIgual").split(",");
			if( !params.get("qtdeMenorIgual").replace(",",".").equals("0.00") ) {
				filtro.qtdeMenorIgual(arrQtde[0]);
			}
		}
		
		if( !params.get("subTotalMaiorIgual").isEmpty() ) {
			if( !params.get("subTotalMaiorIgual").replace(",",".").equals("0.00") ) {
				filtro.subTotalMaiorIgual(params.get("subTotalMaiorIgual"));
			}
		}
		
		if( !params.get("subTotalMenorIgual").isEmpty() ) {
			if( !params.get("subTotalMenorIgual").replace(",",".").equals("0.00") ) {
				filtro.subTotalMenorIgual(params.get("subTotalMenorIgual"));
			}
		}
		
		if( !params.get("dataInicio").isEmpty() ) {
			if( !params.get("dataInicio").replace("/","").trim().isEmpty() ) {
				filtro.dataMaiorIgual(params.get("dataInicio"));
			}
		}
		
		if( !params.get("dataFim").isEmpty() ) {
			if( !params.get("dataFim").replace("/","").trim().isEmpty() ) {
				filtro.dataMenorIgual(params.get("dataFim"));
			}
		}
		
		if( !params.get("taxaRetorno").isEmpty() ) {
			if( !params.get("taxaRetorno").replace(",",".").equals("0.00") ) {
				filtro.taxaMenorIgual(params.get("taxaRetorno"));
			}
		}
		
		return filtro.getModel();
	}
	
}