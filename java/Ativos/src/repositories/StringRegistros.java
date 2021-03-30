package repositories;

public class StringRegistros {

	public String strJson;
	
	public StringRegistros(String param) {
		this.strJson = param;
	}
	
	public String[] getRegistros() {

		//pega posição inicia de [{ e final em }] para pegar o que veio na chave data do json na API
		int posiciaoInicio	= this.strJson.indexOf("[{") + 1;
		int posicaoFinal	= this.strJson.indexOf("}]") + 1;
		String strRegistros	= this.strJson.substring(posiciaoInicio, posicaoFinal);
		
		//substitui todas as "}," por pipe | 
		strRegistros = strRegistros.replaceAll("},", "@");
		
		//retorna os registros em array de string
		String[] arrReturn = strRegistros.split("@");
		
		//retira de cada linha as chaves que sobraram
		for(int i=0; i<arrReturn.length; i++) {
			arrReturn[i] = arrReturn[i].replace("{", "");
			arrReturn[i] = arrReturn[i].replace("}", "");
		}
		
		return arrReturn;
	}
	
}