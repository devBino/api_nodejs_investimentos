package parametros;

public class Parametros {

	protected static String baseUrl = "http://localhost:3000/";
	protected static String[] situacoes = new String[] {"","Ativo","Inativo"};
	
	protected Parametros() {}

	public static String getBaseUrl() {
		return baseUrl;
	}
	public static String[] getSituacoes() {
		return situacoes;
	}
}
