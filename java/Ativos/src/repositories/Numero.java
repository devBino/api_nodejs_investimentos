package repositories;

import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Numero {

	public String getNumero(String strNumero) {
	
		if( strNumero.isEmpty() ) {
			return "0.00";
		}
		
		String numero = "0.00";
	
		try {
			DecimalFormat df = new DecimalFormat("0.#####");
			numero = df.format( Double.parseDouble(strNumero.replaceAll(",",".")) );
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return numero;
	}
	
}
