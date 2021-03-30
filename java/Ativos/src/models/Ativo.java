package models;

public class Ativo {

	public String[] campos = new String[] {
		"nmAtivo","vlAtivo","taxaAdmin","taxaCustodia","taxaPerformace","cdTipo"	
	};
	
	public Ativo() {}
	
	public String[] getCampos() {
		return this.campos;
	}
}