package repositories;

import java.util.Calendar;

public class Data {

	private String data;
	
	public Data(String data) {
		this.data = data;
	}
	
	public void setData(String data) {
		String[] arrDt = data.split("-");
		this.data = arrDt[2]+"-"+arrDt[1]+"-"+arrDt[0];
	}
	
	public String formataDataDiaMesAno() {
		String[] arrDt = data.split("-");
		return arrDt[2]+"/"+arrDt[1]+"/"+arrDt[0];
	}
	
	public String getData() {
		
		Calendar c = Calendar.getInstance();
		String[] dtArrParam = data.replace("/","-").split("-"); 
		
		c.set(Calendar.YEAR, Integer.parseInt( dtArrParam[2] ));
		c.set(Calendar.MONTH, Integer.parseInt( dtArrParam[1]) );
		c.set(Calendar.DAY_OF_MONTH, Integer.parseInt( dtArrParam[0] ));
		
		String dataReturn = c.get(Calendar.YEAR)+"-"+c.get(Calendar.MONTH)+"-"+c.get(Calendar.DAY_OF_MONTH);
		dataReturn += " " + c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
				
		return dataReturn;
	}
	
	public boolean comparaDatas(String dataCompare, String dataParam, String tipo) {
		
		boolean returnCompare = false;
		
		Calendar dtCompare = Calendar.getInstance();
		Calendar dtParam = Calendar.getInstance();
		
		String[] arrDataCompare = dataCompare.replace("/","-").split("-");
		String[] arrDataParam = dataParam.replace("/","-").split("-");
		
		dtCompare.set(Calendar.YEAR, Integer.parseInt(arrDataCompare[2]));
		dtCompare.set(Calendar.MONTH, Integer.parseInt(arrDataCompare[1]));
		dtCompare.set(Calendar.DAY_OF_MONTH, Integer.parseInt(arrDataCompare[0]));
		
		dtParam.set(Calendar.YEAR, Integer.parseInt(arrDataParam[2]) );
		dtParam.set(Calendar.MONTH, Integer.parseInt(arrDataParam[1]));
		dtParam.set(Calendar.DAY_OF_MONTH, Integer.parseInt(arrDataParam[0]));
		
		switch(tipo) {
			case "maior":
				returnCompare = dtCompare.after(dtParam);
				break;
			case "maior_igual":
				returnCompare = ( dtCompare.after(dtParam) || dtCompare.equals(dtParam) );
				break;
			case "menor":
				returnCompare = dtCompare.before(dtParam);
				break;
			case "menor_igual":
				returnCompare = ( dtCompare.before(dtParam) || dtCompare.equals(dtParam) );
				break;
			case "igual":
				returnCompare = dtCompare.equals(dtParam);
				break;
			default:
				returnCompare = dtCompare.equals(dtParam);
				break;
		}
		
		return returnCompare;
		
	}
	
}
