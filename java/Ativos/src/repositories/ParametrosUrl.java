package repositories;

public class ParametrosUrl {

	public String prepareParamsUrl(String[] params, String[] campos) {
		String strParams = "";
		
		for(int i=0; i<params.length; i++) {
			strParams += "&"+campos[i]+"="+params[i].replaceAll(" ", "%20");
		}
		
		if( strParams.startsWith("&") ) {
			strParams.replaceFirst("&", "");
		}
		
		return strParams;
	}
	
}