package repositories;

public class Cotacao {

	private String respostaApi;
	private String marcadorGetPrecoInicial;
	private String marcadorGetPrecoFinal;
	
	public Cotacao( String paramResposta ) {
		respostaApi = paramResposta;
		marcadorGetPrecoInicial = "\"price\":";
		marcadorGetPrecoFinal = "\"change_percent\"";
	}
	
	public String getValor() {
		
		String preco = "0.00";
		
		if( respostaNull() ) {
			return preco;
		}
		
		if( !existeMarcadores() ) {
			return preco;
		}
		
		preco = extrairPreco();
		
		return preco;
		
	}
	
	public boolean respostaNull() {
		return ( respostaApi == null );
	}
	
	public boolean existeMarcadores() {
		boolean marcadorInicial = respostaApi.contains(marcadorGetPrecoInicial);
		boolean marcadorFinal = respostaApi.contains(marcadorGetPrecoFinal);
		
		return ( marcadorInicial && marcadorFinal );
	}
	
	public String extrairPreco() {
		int posicaoInicio = respostaApi.indexOf(marcadorGetPrecoInicial) + marcadorGetPrecoInicial.length();
		int posicaoFinal = respostaApi.indexOf(marcadorGetPrecoFinal);
		
		String preco = respostaApi.substring(posicaoInicio, posicaoFinal);
		preco = preco.replace(",","");
		
		return preco;
	}
	
}
