package models;

public class Ativo {

	protected String[] campos;
	
	public Ativo() {
		campos = new String[] {"nmAtivo","vlAtivo","taxaAdmin","taxaCustodia","taxaPerformace","cdTipo"};
	}
	
	public String[] getCampos() {
		return this.campos;
	}
}