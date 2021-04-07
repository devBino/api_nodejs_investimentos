package repositories;

public class ParametrosUrl {

	private static String id;
	private static boolean setarId;
	
	public ParametrosUrl() {
		id = null;
		setarId = false;
	}
	
	public static void setarId(String paramId) {
		try {
			//valor default
			id = paramId;
			setarId = true;
			
			//se passado null
			if( id == null ) {
				setarId = false;
			}
			
			//se não passado null mas vazio
			if( id != null ) {
				if( id.isEmpty() ) {
					id = null;
					setarId = false;
				}
			}
		}catch(Exception e) {
			id = null;
			setarId = false;
		}
	}
	
	public static String prepareParamsUrl(String[] params, String[] campos) {
		
		String strParams = "";
		
		for(int i=0; i<params.length; i++) {
			String sinal = (i == 0) ? "" : "&";
			strParams += sinal+campos[i]+"="+params[i].replaceAll(" ", "%20");
		}

		if( setarId ) {
			strParams += "&id="+id;
		}
		
		return strParams;
	}
	
}