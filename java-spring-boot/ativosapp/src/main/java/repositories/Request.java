package repositories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import models.Sessao;

public class Request {
	
	public String mensagem = "";
	private HashMap<String,String> fields = new HashMap<String,String>();
	
	public String getRequest(String strUrl) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			if( con.getResponseCode() != 200 ) {
				this.mensagem = "Erro ao conectar com a API...";
				return null;
			}
			
			BufferedReader resposta = new BufferedReader( new InputStreamReader( con.getInputStream() ) );
			String strJson = this.requestToJson(resposta);
			
			con.disconnect();
			
			return strJson;
		}catch(Exception e) {
			this.mensagem = "Erro: "+e.getMessage();
			return null;
		}
	}
	
	public String postRequest(String strUrl, String params) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.addRequestProperty("User-Agent","Mozilla/5.0");
			con.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.addRequestProperty("x-access-token", Sessao.getToken());
			con.connect();
			
			OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
		    out.write(params);
		    out.flush();
		    
		    /*System.out.println(con.getResponseCode());
		    System.out.println(con.getResponseMessage());*/
		    
			if( con.getResponseCode() != 200 ) {
				this.mensagem = "Erro ao conectar com a API...";
				return null;
			}
			
			BufferedReader resposta = new BufferedReader( new InputStreamReader( con.getInputStream() ) );
			String strJson = this.requestToJson(resposta);
			
			out.close();
		    con.disconnect();
		    
			return strJson;
			
		}catch(Exception e) {
			this.mensagem = "Erro: "+e.getMessage();
			return null;
		}
	}
	
	public String putRequest(String strUrl, String params) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("PUT");
			con.setDoOutput(true);
			con.addRequestProperty("User-Agent","Mozilla/5.0");
			con.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.addRequestProperty("x-access-token", Sessao.getToken());
			con.connect();
			
			OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
		    out.write(params);
		    out.flush();
		    
		    /*System.out.println(con.getResponseCode());
		    System.out.println(con.getResponseMessage());*/
		    
			if( con.getResponseCode() != 200 ) {
				this.mensagem = "Erro ao conectar com a API...";
				return null;
			}
			
			BufferedReader resposta = new BufferedReader( new InputStreamReader( con.getInputStream() ) );
			String strJson = this.requestToJson(resposta);
			
			out.close();
		    con.disconnect();
		    
			return strJson;
		}catch(Exception e) {
			this.mensagem = "Erro: "+e.getMessage();
			return null;
		}
	}
	
	public String delRequest(String strUrl) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("DELETE");
			con.setDoOutput(true);
			con.addRequestProperty("User-Agent","Mozilla/5.0");
			con.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.addRequestProperty("x-access-token", Sessao.getToken());
			con.connect();
			
		    /*System.out.println(con.getResponseCode());
		    System.out.println(con.getResponseMessage());*/
		    
			if( con.getResponseCode() != 200 ) {
				this.mensagem = "Erro ao conectar com a API...";
				return null;
			}
			
			BufferedReader resposta = new BufferedReader( new InputStreamReader( con.getInputStream() ) );
			String strJson = this.requestToJson(resposta);
			
		    con.disconnect();
		    
			return strJson;
		}catch(Exception e) {
			this.mensagem = "Erro: "+e.getMessage();
			return null;
		}
	}
	
	public String listar(String strUrl) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setDoOutput(true);
			con.addRequestProperty("User-Agent","Mozilla/5.0");
			con.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.addRequestProperty("x-access-token", Sessao.getToken());
			con.connect();
			
		    /*System.out.println(con.getResponseCode());
		    System.out.println(con.getResponseMessage());*/
		    
			if( con.getResponseCode() != 200 ) {
				this.mensagem = "Erro ao conectar com a API...";
				return null;
			}
			
			BufferedReader resposta = new BufferedReader( new InputStreamReader( con.getInputStream() ) );
			String strJson = this.requestToJson(resposta);
			
		    con.disconnect();
		    
			return strJson;
			
		}catch(Exception e) {
			this.mensagem = "Erro: "+e.getMessage();
			return null;
		}
	}
	
	public String requestToJson(BufferedReader br ) throws IOException {
		String resposta, strJson = "";
		
		while( (resposta = br.readLine()) != null ) {
			strJson += resposta;
		}
		
		return strJson;
	}
	
}