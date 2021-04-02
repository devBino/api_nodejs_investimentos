package repositories;

import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Numero {

	private String num;
	
	public Numero(String param) {
		this.num = param;
	}
	
	public String getNumero() {
		
		String numero = "0.00";
		
		try {
			DecimalFormat df = new DecimalFormat("0.#####");
			numero = df.format( Double.parseDouble(num.replaceAll(",",".")) );
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return numero;
	}
	
}
