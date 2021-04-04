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
			System.out.println("Ocorreu um erro ao tratar uma string para número...");
		}
		
		return String.format("%.2f", Double.parseDouble( numero.replace(",",".")) );
	}
	
	public String getNumeroContabil(String strNumero) {
		
		if( strNumero.isEmpty() ) {
			return "R$ 0,00";
		}
		
		String numero = "0.00";
	
		try {
			DecimalFormat df = new DecimalFormat("0.#####");
			numero = df.format( Double.parseDouble(strNumero.replaceAll(",",".")) );
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tratar uma string para número...");
		}
		
		return "R$ " + String.format("%.2f", Double.parseDouble( numero.replace(",",".") ));
	}
	
}
