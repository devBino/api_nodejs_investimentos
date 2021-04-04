package repositories;

import java.util.Calendar;

public class Data {

	private String data;
	
	public Data(String data) {
		this.data = data;
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
	
}
