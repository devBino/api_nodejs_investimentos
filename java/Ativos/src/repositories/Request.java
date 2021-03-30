package repositories;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;


public class Request {

	/**
	 * @see https://www.youtube.com/watch?v=OaJ43rTJRqw&ab_channel=Nick%E2%80%99sDesk
	 * atributos necessários para
	 * classe atual que irá intermediar as requisições get e post
	 * para esse projeto
	*/
	private double API_VERSION = 0;
	private String API = "";
	private String METHOD = "POST";
	private String TYPE = "application/x-www-form-urlencoded";
	private String USER_AGENT = "Mozilla/5.0";
	private String data = "";
	private URL connection;
	private HttpURLConnection finalConnection;
	private HashMap<String,String> fields = new HashMap<String,String>();

	//construtor
	public Request(String[] endpoint, String url, double version) {
		this.API_VERSION = version;
		this.API = url;
		fields.put("version",String.valueOf(version));
		for( int i=0; i<endpoint.length; i++ ) {
			String[] points = endpoint[i].split(";");
			for( int j=0; j<points.length; j++ ) {
				fields.put(points[j].split(":")[0],points[j].split(":")[1]);
			}
		}
	}
	
	//geters
	public String getApiVersion() {
		return String.valueOf(this.API_VERSION);
	}
	public String getEndpoints() {
		return this.fields.toString();
	}
	public String getEndpointsValue(String key) {
		return this.fields.get(key);
	}
	public void setUserAgent(String userAgent) {
		this.USER_AGENT = userAgent;
	}
	public void setMethod(String method) {
		this.METHOD = method;
	}
	public void setRequestType(String type) {
		this.TYPE = type;
	}
	
	private InputStream readwithAccess(URL url, String data) {
		try {
			byte[] out = data.toString().getBytes();
			this.finalConnection = (HttpURLConnection) url.openConnection();
			this.finalConnection.setRequestMethod(this.METHOD);
			this.finalConnection.setDoOutput(true);
			this.finalConnection.addRequestProperty("User-Agent", this.USER_AGENT);
			this.finalConnection.addRequestProperty("Content-type", this.TYPE);
			this.finalConnection.connect();
			try {
				OutputStream os = this.finalConnection.getOutputStream();
				os.write(out);
				return this.finalConnection.getInputStream();
			}catch(Exception e) {
				System.err.println(e.getMessage());
				return null;
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}
	}

	public String buildRequest() {
		
		StringBuilder content = new StringBuilder();
		
		//se nenhuma chave estiver vazia e se existirem os paramtetros em fields
		if( !this.getEndpoints().equalsIgnoreCase("") && !this.getEndpoints().isEmpty() ) {
			String vars = "";
			String vals = "";
			try {
				for(Map.Entry<String, String> entry : fields.entrySet()) {
					vars = entry.getKey();
					vals = entry.getValue();
					data += ("&"+vars+"="+vals);
				}
				if(data.startsWith("&")) {
					data.replaceFirst("&", "");
				}
				this.connection = new URL(this.API);
				BufferedReader reader = new BufferedReader(new InputStreamReader(readwithAccess(connection, data)));
				
				String line;
				while( (line = reader.readLine()) != null ) {
					content.append(line+"\n");
				}
				reader.close();
				return content.toString();
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}else {
			return null;
		}
	}
	
	
}
