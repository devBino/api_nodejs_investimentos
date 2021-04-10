package models;

import java.util.Map;
import java.util.HashMap;

public class Aporte {

	private Map<String,String> campos;
	
	public Aporte() {
		
		campos = new HashMap<String,String>();
		
		campos.put("0", "ID;cdAporte");
		campos.put("1", "ATIVO;nmAtivo");
		campos.put("2", "TIPO;nmTipo");
		campos.put("3", "VALOR;vlAporte");
		campos.put("4", "QTDE;qtde");
		campos.put("5", "SUBTOTAL;subTotal");
		campos.put("6", "DATA;dtAporte");
		campos.put("7", "TAXA RETORNO;taxaRetorno");

	}
	
	public String[] getArrayNomesCampos() {
		String[] nomesCampos = new String[campos.size()];
		
		for(String numChave : campos.keySet()) {
			String[] arrValorChave = campos.get(numChave).split(";");
			nomesCampos[ Integer.parseInt(numChave) ] = arrValorChave[0];
		}
		
		return nomesCampos;
	}
	
	public String[] getCamposApi(String opcaoId) {
		if( opcaoId != null ) {
			return new String[] {
				"id",
				"cdAtivo",
				"vlAporte",
				"qtde",
				"subTotal",
				"dtAporte",
				"taxaRetorno"
			};
		}else {
			return new String[] {
				"cdAtivo",
				"vlAporte",
				"qtde",
				"subTotal",
				"dtAporte",
				"taxaRetorno"
			};
		}
	}
	
}