package controllers;

import repositories.Request2;
import repositories.DialogoUsuario;
import repositories.StringRegistros;
import models.Ativo;
import models.TipoAtivo;
import parametros.Parametros;

import java.util.List;
import java.util.ArrayList;


public class CtAtivo {

	public String nomeAtivo;
	public String url = Parametros.baseUrl + "ativos";
	public DialogoUsuario dialogo = new DialogoUsuario();
	public Ativo model = new Ativo();
	
	public CtAtivo() {}
	
	public void salvar(String[] params) {
		//prepara os parametros
		
		String[] campos = model.getCampos();
		String strParams = "";
		
		for(int i=0; i<params.length; i++) {
			strParams += "&"+campos[i]+"="+params[i].replaceAll(" ", "%20");
		}
		
		if( strParams.startsWith("&") ) {
			strParams.replaceFirst("&", "");
		}
		
		//inicia Request2 e submete requisição
		Request2 req = new Request2();
		String resposta = req.postRequest(this.url, strParams);
		
		if( resposta.contains("\"affectedRows\":1") ) {
			dialogo.sucesso("Ativo de Investimentos salvo com sucesso...");
		}else {
			dialogo.aviso("Não foi possível salvar o Ativo de Investimentos...");
		}
		
	}
	public void alterar(String[] params, String idAtivo) {
		
	}
	public void listar() {
		
	}
	public ArrayList<TipoAtivo> listarCombo() {
		
		//busca os dados
		String urlTipoAtivos = Parametros.baseUrl + "tipoAtivos";
		Request2 req = new Request2();
		String strLista = req.listar(urlTipoAtivos);
		
		//inicia retorno
		ArrayList<TipoAtivo> arrReturn = new ArrayList<TipoAtivo>();
		
		StringRegistros strRegistros = new StringRegistros(strLista);
		
		for(String str : strRegistros.getRegistros()) {
			String[] arrStr = str.split(",");
			String[] arrLinha = new String[arrStr.length];
			for(int i=0; i<arrStr.length; i++) {
				String[] arrChave = arrStr[i].split(":");
				arrLinha[i] = arrChave[1];
			}
			
			arrReturn.add(new TipoAtivo(
					Integer.parseInt(arrLinha[0].replaceAll("\"", "")),
					arrLinha[1].replaceAll("\"", ""),
					arrLinha[2].replaceAll("\"", "")
			));
		}
		
		return arrReturn;
	}
	public void deletar() {
		
	}
	
	
}
