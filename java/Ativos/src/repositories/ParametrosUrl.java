package repositories;

public class ParametrosUrl {

	private String id;
	private boolean setarId;
	
	public ParametrosUrl() {
		id = null;
		setarId = false;
	}
	
	public void setarId(String id) {
		try {
			//valor default
			this.id = id;
			this.setarId = true;
			
			//se passado null
			if( this.id == null ) {
				this.setarId = false;
			}
			
			//se não passado null mas vazio
			if( this.id != null ) {
				if( this.id.isEmpty() ) {
					this.id = null;
					this.setarId = false;
				}
			}
		}catch(Exception e) {
			this.id = null;
			this.setarId = false;
		}
	}
	
	public String prepareParamsUrl(String[] params, String[] campos) {
		
		String strParams = "";
		
		for(int i=0; i<params.length; i++) {
			String sinal = (i == 0) ? "" : "&";
			strParams += sinal+campos[i]+"="+params[i].replaceAll(" ", "%20");
		}

		if( setarId ) {
			strParams += "&id="+this.id;
		}
		
		return strParams;
	}
	
}