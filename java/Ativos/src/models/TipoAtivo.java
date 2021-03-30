package models;

public class TipoAtivo {

	public int id;
	public String tipo;
	public String situacao;
	
	public TipoAtivo(int paramId, String paramTipo, String paramSituacao) {
		this.id			= paramId;
		this.tipo		= paramTipo;
		this.situacao	= paramSituacao;
	}
	
	public String getId() {
		return Integer.toString(this.id);
	}
	public String getTipo() {
		return this.tipo;
	}
	public String getSituacao() {
		return this.situacao;
	}
	
	@Override
	public String toString() {
		return this.id+" - "+this.tipo;
	}
}
