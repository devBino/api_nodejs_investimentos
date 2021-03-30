package controllers;

import java.util.List;
import java.util.ArrayList;

import repositories.Request2;
import com.google.gson.Gson;
import repositories.DialogoUsuario;
import repositories.StringRegistros;
import models.TipoAtivo;
import parametros.Parametros;

public class CtTipoAtivo {

	public String mensagem;
	public String url = Parametros.baseUrl + "tipoAtivos";
	public DialogoUsuario dialogo = new DialogoUsuario();
	
	public CtTipoAtivo() {}
	
	public void salvar(String nomeTipo) {
		
		String params = "nmTipo="+nomeTipo;
		
		Request2 req = new Request2();
		String resposta = req.postRequest(this.url, params);
		
		if( resposta.contains("\"affectedRows\":1") ) {
			dialogo.sucesso("Tipo de Ativo salvo com sucesso");
		}else {
			dialogo.acaoNaoConcluida("Não foi possível salvar o Tipo de Ativo");
		}
		
	}
	
	public void alterar(String nomeTipo, String idTipo) {
		
		String params = "nmTipo="+nomeTipo+"&id="+idTipo;
		
		Request2 req = new Request2();
		String resposta = req.putRequest(this.url, params);
		
		if( resposta.contains("\"affectedRows\":1") ) {
			dialogo.sucesso("Tipo de Ativo salvo com sucesso");
		}else {
			dialogo.acaoNaoConcluida("Não foi possível salvar o Tipo de Ativo");
		}
		
	}
	
	public void deletar(String idTipo) {
		Request2 req = new Request2();
		String resposta = req.delRequest(this.url+"/"+idTipo);
		
		if( resposta.contains("\"affectedRows\":1") ) {
			dialogo.sucesso("Tipo de Ativo salvo com sucesso");
		}else {
			dialogo.acaoNaoConcluida("Não foi possível salvar o Tipo de Ativo");
		}
	}
	
	public ArrayList<String[]> listar() {
	
		//busca os dados da API
		Request2 req = new Request2();
		String resposta = req.listar(this.url);
		StringRegistros strRegistros = new StringRegistros(resposta);
		
		//inicia retorno
		ArrayList<String[]> arrReturn = new ArrayList<String[]>();
		
		//trata registros que vieram em forma de string
		for(String str : strRegistros.getRegistros()) {
			
			String[] arrRegistro = str.split(",");
			String[] arrLinha = new String[3];
			
			for( int i=0; i<arrRegistro.length; i++ ) {
				String[] arrChave = arrRegistro[i].split(":");
				arrLinha[i] = arrChave[1].replaceAll("\"", "");
			}
			
			arrReturn.add(arrLinha);
		}
		
		return arrReturn;
	}
	
}
