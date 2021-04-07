package models;

public class TipoAtivo {

	private static String[] campos;
	
	public TipoAtivo() {
		campos = new String[] {"nmTipo"};
	}

	public static void setCampos() {
		campos = new String[] {"nmTipo"};
	}
	
	public static String[] getCampos() {
		setCampos();
		return campos;
	}
	
}
