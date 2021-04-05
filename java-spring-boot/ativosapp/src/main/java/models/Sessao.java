package models;

public class Sessao {

	private static String token;
	
	private Sessao() {}
	
	public static String getToken() {
		return token;
	}
	public static void setToken(String resposta) {
		
		if( resposta != null ) {
			if( !resposta.isEmpty() ) {
				String[] arrResposta = resposta.split(",");
				String strToken = arrResposta[1].replace("\"token\":\"","");
				strToken = strToken.replace("\"}","");
				
				token = strToken;
			}else {
				token = "";
			}
		}else {
			token = "";
		}
	}
	
}