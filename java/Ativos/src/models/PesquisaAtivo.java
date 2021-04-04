package models;

import java.util.ArrayList;

public class PesquisaAtivo {

	private static String listaAtivo = "";
	private static String listaTipoAtivo = "";
	
	protected PesquisaAtivo() {}
	
	public static void setListaAtivo(ArrayList<String[]> lista) {
		for(int i=0; i<lista.size(); i++) {
			String sinal = ( i == lista.size() - 1 ) ? "" : "&";
			listaAtivo += lista.get(i)[0] +"@"+lista.get(i)[1]+sinal;
		}
	}
	public static void setListaTipoAtivo(ArrayList<String[]> lista) {
		for(int i=0; i<lista.size(); i++) {
			String sinal = ( i == lista.size() - 1 ) ? "" : "&";
			listaTipoAtivo += lista.get(i)[0]+"@"+lista.get(i)[1]+sinal;
		}
	}
	
	public static String getListaAtivo() {
		return listaAtivo;
	}
	public static String getListaTipoAtivo() {
		return listaTipoAtivo;
	}
	
	public static Boolean contemNaListaAtivo(String compare) {
		
		boolean contem = false;
		String[] arrLista = listaAtivo.split("&");
		
		for( int i=0; i<arrLista.length; i++ ) {
			if( arrLista[i].contains(compare) ) {
				contem = true;
				break;
			}
		}
		
		return contem;
	}
	
	public static Boolean contemNaListaTipoAtivo(String compare){
		
		boolean contem = false;
		String[] arrLista = listaTipoAtivo.split("&");
		
		for(int i=0; i<arrLista.length; i++) {
			if( arrLista[i].contains(compare) ) {
				contem = true;
				break;
			}
		}
		
		return contem;
		
	}
	
}
