package models;

public class Ativo {

	protected String[] campos = new String[] {
		"nmAtivo","vlAtivo","taxaAdmin","taxaCustodia","taxaPerformace","cdTipo"	
	};
	
	public Ativo() {}
	
	public String[] getCampos() {
		return this.campos;
	}
}